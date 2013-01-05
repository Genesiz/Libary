package gui;

import java.awt.GridLayout;

import javax.swing.*;

public class NewItemDialog extends JDialog {
	
	public NewItemDialog(JFrame frame, boolean moda) {
		super(frame, moda); 
		this.setTitle("Add new item to library");
		this.setLayout(new GridLayout(6,2));
		
		JLabel jlTitle = new JLabel("Title :");
		JLabel jlAuthor = new JLabel("Author :");
		JLabel jlRating = new JLabel("Rating (0 - 5) :");
		JLabel jlLength = new JLabel("Length :");
		JLabel jlType = new JLabel("Type :");
		JLabel jlGenre = new JLabel("Genre :");
		
		JTextField jtfTitle = new JTextField();
		JTextField jtfAuthor = new JTextField();
		JTextField jtfGenre = new JTextField();
		JTextField jtfRating = new JTextField();
		JTextField jtfLength = new JTextField();
		JComboBox jcbType = new JComboBox();
		
		this.add(jlTitle);
		this.add(jtfTitle);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
		
		
				
	}
	


}
