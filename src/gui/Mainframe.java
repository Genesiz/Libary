package gui;

import library.TitleList;
import library.AuthorList;
import library.GenreList;
import library.RatingList;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;

import library.Archieve;

public class Mainframe extends JFrame {
	
	
	
	private JCheckBox jcbTitle;
	private JCheckBox jcbAuthor;
	private JCheckBox jcbGenre;
	private JCheckBox jcbLength;
	private JCheckBox jcbRating;
	private JTextField jtfSearch;
	

	public Mainframe(){
		 JPanel p1 = new JPanel();
		 JPanel p2 = new JPanel();
		 JPanel p3 = new ListPanel();
		 
		 p1.setLayout(new FlowLayout());
		 p2.setLayout(new FlowLayout());

		 
		 JButton jbtNew = new JButton("Add new");
		 JLabel jlSearch = new JLabel("Search:");
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
		 jcbLength.addActionListener(new CheckLengthListener());
		 jcbRating.addActionListener(new CheckRatingListener());
		 
		 JList list = new JList();
		 	
		 		 
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
		 p2.add(jcbLength);
		 p2.add(jcbRating);
		 
		 
		 p3.add(list);
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		 setLayout(new BorderLayout());
	
		 this.add(p1, BorderLayout.NORTH);
		 this.add(p2);
		 
		 this.add(p3, BorderLayout.SOUTH);
		 
		}
		
		int i;
	
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
		
		class CheckLengthListener implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (jcbLength.isSelected()) {
					jcbTitle.setEnabled(false);
					jcbAuthor.setEnabled(false);
					jcbGenre.setEnabled(false);
					jcbRating.setEnabled(false);
					i = 4;
				}
				else {
					jcbTitle.setEnabled(true);
					jcbAuthor.setEnabled(true);
					jcbGenre.setEnabled(true);
					jcbRating.setEnabled(true);
					i = 0;
				}	
			}
			
		}
		
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
				case 0 : System.out.println("YOLO");
				case 1 : {
				String[] list = Archieve.library.getTitles().find(jtfSearch.getText());
				for (String current : list)
					System.out.println(current);
				}
				}
				
				
			}
			
		}
}
