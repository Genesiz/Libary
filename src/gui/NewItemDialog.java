package gui;

import items.Book;
import items.IllegalItemException;
import items.Item;
import items.Item.ItemType;
import items.Music;


import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import library.Archive;

public class NewItemDialog extends JDialog {
	
	private static final long serialVersionUID = 1L;
	JTextField jtfTitle;
	JTextField jtfAuthor;
	JTextField jtfGenre;
	JTextField jtfRating;
	JTextField jtfLength;
	JComboBox<Item.ItemType> jcbType;
	
	/**
	 * Constructor for a JDialog for adding new Item to Archive
	 * @param frame mainFrame of the program.
	 */
	public NewItemDialog(JFrame frame) {
		super(frame, true); 
		this.setTitle("Add new item to library");
		this.setLayout(new BorderLayout());
		
		jcbType = new JComboBox<Item.ItemType>();
		for (Item.ItemType type : Item.ItemType.values())
			 jcbType.addItem(type);
		JLabel jlTitle = new JLabel("Title:");
		JLabel jlAuthor = new JLabel("Author:");
		JLabel jlRating = new JLabel("Rating (0 - 5):");
		JLabel jlLength = new JLabel("Length (Pages or Minutes) :");
		JLabel jlType = new JLabel("Type:");
		JLabel jlGenre = new JLabel("Genre:");

	    jtfTitle = new JTextField();
		jtfAuthor = new JTextField();
		jtfGenre = new JTextField();
		jtfRating = new JTextField();
		jtfLength = new JTextField();
		
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(6,2));
		
		JPanel p2 = new JPanel();
		JButton jbAdd = new JButton("Add");
		JButton jbClose = new JButton("Close");
		jbAdd.addActionListener(new AddListener());
		jbClose.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			} 
		});
		
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
		p2.add(jbClose);
		
		this.add(p1, BorderLayout.NORTH);
		this.add(p2, BorderLayout.SOUTH);
		
		this.pack();
		this.setResizable(false);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.setLocationRelativeTo(frame);
	}
	/**
	 * Listener for AddButton, adds new Item to Archive on
	 * click.
	 */
	class AddListener implements ActionListener{

		private String title;
		private String author;
		private String genre;
		private int rating;
		private double length;
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (jtfTitle.getText().isEmpty())
				 title = "Unknown";
			else
				title = jtfTitle.getText();
			
			if (jtfAuthor.getText().isEmpty())
				author = "Unknown"; 
			else 
				author = jtfAuthor.getText();
			
			try  {
			if (jtfRating.getText().isEmpty()) 
				rating = 0;
			else 
				rating = Integer.valueOf(jtfRating.getText());
			
			if (jtfLength.getText().isEmpty())
				length = 0.0;
			else
				length = Double.valueOf(jtfLength.getText());
			} catch (NumberFormatException e) {
				System.err.print("Input must be a number");
			}
			
			if(jtfGenre.getText().isEmpty())
				genre = "Unknown";
			else 
				genre = jtfGenre.getText();
			
			try {
				if (jcbType.getSelectedItem() == "Music") 
					Archive.library.addItem(new Music(title, author, length, 
							genre, rating, ItemType.MUSIC));
				
				else 
					Archive.library.addItem(new Book(title, author, length,
							genre, rating, ItemType.BOOK));
				ListPanel.updateList();
			} 
			catch (IllegalItemException e) {
				// do statusbar?
			}
			
			jtfTitle.setText("");
			jtfAuthor.setText("");
			jtfGenre.setText("");
			jtfLength.setText("");
			jtfRating.setText("");
			Archive.library.setSaved(false);
		}
	}
}
