package gui;


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
	
	
	
	public Mainframe(){
		 JPanel p1 = new JPanel();
		 JPanel p2 = new JPanel();
		 JPanel p3 = new ListPanel();
		 
		 p1.setLayout(new FlowLayout());
		 p2.setLayout(new FlowLayout());

		 
		 JButton jbtNew = new JButton("Add new");
		 JLabel jlSearch = new JLabel("Search:");
		 JTextField jtfSearch = new JTextField(10);
		 JCheckBox jcbTitle = new JCheckBox("Title");
		 JCheckBox jcbAuthor = new JCheckBox("Author");
		 JCheckBox jcbGenre = new JCheckBox("Genre");
		 JCheckBox jcbLength = new JCheckBox("Length");
		 JCheckBox jcbRating = new JCheckBox("Rating");
		 		 
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
			this.setLocationRelativeTo(null);

		 setLayout(new BorderLayout());
	
		 this.add(p1, BorderLayout.NORTH);
		 this.add(p2);
		 
		 this.add(p3, BorderLayout.SOUTH);

	}

}
