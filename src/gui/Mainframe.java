package gui;

import items.Item;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.*;

import library.Archive;
import library.Archive.ItemInfo;
import library.Search;

public class Mainframe extends JFrame {
	
	private JRadioButton jcbTitle;
	private JRadioButton jcbAuthor;
	private JRadioButton jcbGenre;
	private JRadioButton jcbLength;
	private JRadioButton jcbRating;
	private JTextField jtfSearch;
	private JButton jbtNew;
	private JLabel jlSearch;
	private int i;
	private ButtonGroup group;
	
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
		 jcbTitle = new JRadioButton("Title");
		 jcbTitle.setSelected(true);
		 jcbAuthor = new JRadioButton("Author");
		 jcbGenre = new JRadioButton("Genre");
		 jcbLength = new JRadioButton("Length");
		 jcbRating = new JRadioButton("Rating");
		 
		 group = new ButtonGroup();
		 group.add(jcbTitle);
		 group.add(jcbAuthor);
		 group.add(jcbGenre);
		 // false because, else it catches NPE. Instead of //
		 jcbLength.setVisible(false);
		 group.add(jcbLength);
		 group.add(jcbRating);

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
		 
		 p2.add(jcbTitle);
		 p2.add(jcbAuthor);
		 p2.add(jcbGenre);
		 // false because, else it catches NPE. Instead of //
		 jcbLength.setVisible(false);
		 p2.add(jcbLength);
		 p2.add(jcbRating);
		 this.setLayout(new BorderLayout());
		 this.add(p1, BorderLayout.PAGE_START);
		 this.add(p2, BorderLayout.CENTER); 
		 this.add(p3, BorderLayout.PAGE_END);
		 
		 this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		 this.setSize(500,300);
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
