package gui;

import items.Books;
import items.Music;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import library.Archieve;

public class NewItemDialog extends JDialog {
	
	JTextField jtfTitle;
	JTextField jtfAuthor;
	JTextField jtfGenre;
	JTextField jtfRating;
	JTextField jtfLength;
	JComboBox<String> jcbType;
	
	public NewItemDialog() {
		//super(frame, moda); 
		this.setTitle("Add new item to library");
		this.setLayout(new BorderLayout());
		
		
		JLabel jlTitle = new JLabel("Title :");
		JLabel jlAuthor = new JLabel("Author :");
		JLabel jlRating = new JLabel("Rating (0 - 5) :");
		JLabel jlLength = new JLabel("Length :");
		JLabel jlType = new JLabel("Type :");
		JLabel jlGenre = new JLabel("Genre :");
		
	     jtfTitle = new JTextField();
		 jtfAuthor = new JTextField();
		 jtfGenre = new JTextField();
		 jtfRating = new JTextField();
		 jtfLength = new JTextField();
		 jcbType = new JComboBox<String>();
		jcbType.addItem("Book");
		jcbType.addItem("Music");
		
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(6,2));
		
		JPanel p2 = new JPanel();
		JButton jbAdd = new JButton("Add");
		jbAdd.addActionListener(new AddButtonListener());
		
		p1.add(jlTitle);
		p1.add(jtfTitle);
		p1.add(jlAuthor);
		p1.add(jtfAuthor);
		p1.add(jlGenre);
		p1.add(jtfGenre);
		p1.add(jlLength);
		p1.add(jtfLength);
		p1.add(jlRating);
		p1.add(jtfRating);
		p1.add(jlType);
		p1.add(jcbType);
		
		p2.add(jbAdd);
		
		
		
		this.add(p1, BorderLayout.NORTH);
		this.add(p2, BorderLayout.SOUTH);
		
		
		this.pack();
		this.setResizable(false);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
		
		
				
	}
	class AddButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String title = jtfTitle.getText()
			String
			
			if (jcbType.getSelectedItem() == "Music") {
			Archieve.library.addItem(new Music(jtfTitle.getText(), jtfAuthor.getText(), Double.valueOf(jtfLength.getText()));
			}
			else Archieve.library.addItem(new Books());
		}
		
	}


}
