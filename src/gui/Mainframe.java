package gui;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import library.Archieve;

public class Mainframe extends JFrame {
	
	private JCheckBox jcbTitle;
	private JCheckBox jcbAuthor;
	private JCheckBox jcbGenre;
	private JCheckBox jcbLength;
	private JCheckBox jcbRating;
	

	public Mainframe(){
		 JPanel p1 = new JPanel();
		 JPanel p2 = new JPanel();
		 JPanel p3 = new ListPanel();
		 
		 p1.setLayout(new FlowLayout());
		 p2.setLayout(new FlowLayout());

		 
		 JButton jbtNew = new JButton("Add new");
		 JLabel jlSearch = new JLabel("Search:");
		 JTextField jtfSearch = new JTextField(10);
		 jcbTitle = new JCheckBox("Title");
		 jcbAuthor = new JCheckBox("Author");
		 jcbGenre = new JCheckBox("Genre");
		 jcbLength = new JCheckBox("Length");
		 jcbRating = new JCheckBox("Rating");
		 
		 jcbTitle.addActionListener(new CheckTitleListener());
		 jcbAuthor.addActionListener(new CheckAuthorListener());
		 jcbGenre.addActionListener(new CheckGenreListener());
		 jcbLength.addActionListener(new CheckLengthListener());
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
		 p2.add(jcbLength);
		 p2.add(jcbRating);
		 
		 
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		 setLayout(new BorderLayout());
	
		 this.add(p1, BorderLayout.NORTH);
		 this.add(p2);
		 
		 this.add(p3, BorderLayout.SOUTH);
		 
		}
		
	
		class CheckTitleListener implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (jcbTitle.isSelected()) {
					jcbAuthor.setEnabled(false);
					jcbGenre.setEnabled(false);
					jcbLength.setEnabled(false);
					jcbRating.setEnabled(false);
				}
				else {
					jcbAuthor.setEnabled(true);
					jcbGenre.setEnabled(true);
					jcbLength.setEnabled(true);
					jcbRating.setEnabled(true);
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
				}
				else {
					jcbTitle.setEnabled(true);
					jcbGenre.setEnabled(true);
					jcbLength.setEnabled(true);
					jcbRating.setEnabled(true);
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
				}
				else {
					jcbTitle.setEnabled(true);
					jcbAuthor.setEnabled(true);
					jcbLength.setEnabled(true);
					jcbRating.setEnabled(true);
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
				}
				else {
					jcbTitle.setEnabled(true);
					jcbAuthor.setEnabled(true);
					jcbGenre.setEnabled(true);
					jcbRating.setEnabled(true);
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
				}
				else {
					jcbTitle.setEnabled(true);
					jcbAuthor.setEnabled(true);
					jcbGenre.setEnabled(true);
					jcbLength.setEnabled(true);
				}	
			}
			
		}
}
