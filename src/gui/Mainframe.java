package gui;

import items.Item;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.*;

import library.Archive.ItemInfo;
import library.Search;

public class Mainframe extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private JRadioButton jrbTitle;
	private JRadioButton jrbAuthor;
	private JRadioButton jrbGenre;
	private JRadioButton jrbLength;
	private JRadioButton jrbRating;
	private JTextField jtfSearch;
	private JButton jbtNew;
	private JLabel jlSearch;
	private ButtonGroup group;

	private JPanel contentPane;
	
	public Mainframe(){
		 JPanel p1 = new JPanel();
		 JPanel p2 = new JPanel();
		 JPanel p3 = new ListPanel();
		 
		 p1.setLayout(new FlowLayout());
		 p2.setLayout(new FlowLayout());
		 p3.setLayout(new FlowLayout());

		 
		 jbtNew = new JButton("Add new");
		 jlSearch = new JLabel("Search:");
		 jtfSearch = new JTextField(10);
		 jrbTitle = new JRadioButton("Title");
		 jrbTitle.setSelected(true);
		 jrbAuthor = new JRadioButton("Author");
		 jrbGenre = new JRadioButton("Genre");
		 jrbLength = new JRadioButton("Length");
		 jrbRating = new JRadioButton("Rating");
		 
		 group = new ButtonGroup();
		 group.add(jrbTitle);
		 group.add(jrbAuthor);
		 group.add(jrbGenre);
		 // false because, else it catches NPE. Instead of //
		 jrbLength.setVisible(false);
		 group.add(jrbLength);
		 group.add(jrbRating);

		 jtfSearch.addActionListener(new SearchListener());
		 		 	
		 jbtNew.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new NewItemDialog();
			}
			 
		 });
		 p1.add(jbtNew);
		 p1.add(jlSearch);
		 p1.add(jtfSearch);
		 
		 p2.add(jrbTitle);
		 p2.add(jrbAuthor);
		 p2.add(jrbGenre);
		 // false because, else it catches NPE. Instead of //
		 jrbLength.setVisible(false);
		 p2.add(jrbLength);
		 p2.add(jrbRating);
		 
		 contentPane = new JPanel();
		 FlowLayout layout = new FlowLayout();
		 layout.setAlignment(FlowLayout.TRAILING);
		 contentPane.setLayout(layout);
		 contentPane.add(p1 );
		 contentPane.add(p2); 
		 contentPane.add(p3);
		 
		 this.setContentPane(contentPane);

		 this.pack();
		 
		 this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		 this.setSize(600,500);
		 this.setResizable(false);
		 this.setLocationRelativeTo(null);
	}	
	
		class SearchListener implements ActionListener {
					
		    public String getSelectedButtonText(ButtonGroup buttonGroup) {
		        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
		            AbstractButton button = buttons.nextElement();

		            if (button.isSelected()) {
		                return button.getText();
		            }
		        }

		        return null;
		    }
			@Override
			public void actionPerformed(ActionEvent e) {
				String input = jtfSearch.getText();
				Search search = new Search();

				switch (this.getSelectedButtonText(group)) {
				case "Title" : {
					Item[] itemList = search.find(input, ItemInfo.TITLE);
					String[] array = search.toStringArray(itemList, ItemInfo.TITLE);
					ListPanel.updateList(array);
					break;
				}
				case "Author" : {
					Item[] itemList = search.find(input, ItemInfo.AUTHOR);
					String[] array = search.toStringArray(itemList, ItemInfo.AUTHOR);
					ListPanel.updateList(array);
					break;
				}
				
				case "Genre" : {
					Item[] itemList = search.find(input, ItemInfo.GENRE);
					String[] array = search.toStringArray(itemList, ItemInfo.GENRE);
					ListPanel.updateList(array);
					break;
				}

				case "Rating" : {
					Item[] itemList = search.find(input, ItemInfo.RATING);
					String[] array = search.toStringArray(itemList, ItemInfo.RATING);
					ListPanel.updateList(array);
					break;
				}
				
				default : System.out.println("No search criteria!"); break;
				}
				
				jtfSearch.setText("");
				
			}
			
		}
}
