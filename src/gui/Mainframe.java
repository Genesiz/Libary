package gui;

import items.Item;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import library.Archive;
import library.Archive.ItemInfo;
import library.Search;

public class Mainframe extends JFrame {
	
	private JCheckBox jcbTitle;
	private JCheckBox jcbAuthor;
	private JCheckBox jcbGenre;
	private JCheckBox jcbLength;
	private JCheckBox jcbRating;
	private JTextField jtfSearch;
	private JButton jbtNew;
	private JLabel jlSearch;
	private int i;
	
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
		 jcbTitle = new JCheckBox("Title");
		 jcbAuthor = new JCheckBox("Author");
		 jcbGenre = new JCheckBox("Genre");
		 jcbLength = new JCheckBox("Length");
		 jcbRating = new JCheckBox("Rating");
		 
		 jtfSearch.addActionListener(new SearchListener());
		 jcbTitle.addActionListener(new CheckTitleListener());
		 jcbAuthor.addActionListener(new CheckAuthorListener());
		 jcbGenre.addActionListener(new CheckGenreListener());
//		 jcbLength.addActionListener(new CheckLengthListener());
		 jcbRating.addActionListener(new CheckRatingListener());
		 		 	
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
		
		class CheckTitleListener implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (jcbTitle.isSelected()) {
					jcbAuthor.setEnabled(false);
					jcbGenre.setEnabled(false);
					jcbLength.setEnabled(false);
					jcbRating.setEnabled(false);
					i = 1;
				}
				else {
					jcbAuthor.setEnabled(true);
					jcbGenre.setEnabled(true);
					jcbLength.setEnabled(true);
					jcbRating.setEnabled(true);
					i = 0;
				}
			}
		}

		class CheckAuthorListener implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (jcbAuthor.isSelected()) {
					jcbTitle.setEnabled(false);
					jcbGenre.setEnabled(false);
					jcbLength.setEnabled(false);
					jcbRating.setEnabled(false);
					i = 2;
				}
				else {
					jcbTitle.setEnabled(true);
					jcbGenre.setEnabled(true);
					jcbLength.setEnabled(true);
					jcbRating.setEnabled(true);
					i = 0;
				}	
			}
			
		}
		
		class CheckGenreListener implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (jcbGenre.isSelected()) {
					jcbTitle.setEnabled(false);
					jcbAuthor.setEnabled(false);
					jcbLength.setEnabled(false);
					jcbRating.setEnabled(false);
					i = 3;
				}
				else {
					jcbTitle.setEnabled(true);
					jcbAuthor.setEnabled(true);
					jcbLength.setEnabled(true);
					jcbRating.setEnabled(true);
					i = 0;
				}	
			}
			
		}
		
//		class CheckLengthListener implements ActionListener {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				if (jcbLength.isSelected()) {
//					jcbTitle.setEnabled(false);
//					jcbAuthor.setEnabled(false);
//					jcbGenre.setEnabled(false);
//					jcbRating.setEnabled(false);
//				}
//				else {
//					jcbTitle.setEnabled(true);
//					jcbAuthor.setEnabled(true);
//					jcbGenre.setEnabled(true);
//					jcbRating.setEnabled(true);
//				}	
//			}
//			
//		}
		
		class CheckRatingListener implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (jcbRating.isSelected()) {
					jcbTitle.setEnabled(false);
					jcbAuthor.setEnabled(false);
					jcbGenre.setEnabled(false);
					jcbLength.setEnabled(false);
					i = 5;
				}
				else {
					jcbTitle.setEnabled(true);
					jcbAuthor.setEnabled(true);
					jcbGenre.setEnabled(true);
					jcbLength.setEnabled(true);
					i = 0;
				}	
			}
			
		}
		
		class SearchListener implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				switch (i) {
				case 1 : {
					String input = jtfSearch.getText();
					Search search = new Search();
					Item[] itemList = search.find(input, ItemInfo.TITLE);
					String[] array = search.toStringArray(itemList, ItemInfo.TITLE);
					ListPanel.updateList(array);
					break;
				}
				case 2 : {
					String text = jtfSearch.getText();
					String[] list = Archive.library.getAuthors().find(text);
					for (String current : list) {
						System.out.println(current);
					}
					break;
				}
				
				case 3 : {
					String text = jtfSearch.getText();
					String[] list = Archive.library.getGenre().find(text);
					for (String current : list)
						System.out.println(current);
					break;
				}

				case 5 : {
					String text = jtfSearch.getText();
					int convert = Integer.valueOf(text);
					Integer[] list = Archive.library.getRatings().find(convert);
					for (int current : list) {
						System.out.println(current);
					}
					break;
				}
				
				default : System.out.println("No search criteria!"); break;
				}
				
				jtfSearch.setText("");
				
			}
			
		}
}
