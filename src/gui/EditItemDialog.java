package gui;

import items.Book;
import items.IllegalItemException;
import items.Music;

import items.Item;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

import library.Archive;

public class EditItemDialog extends JDialog {
	
	private static final long serialVersionUID = 1L;
	private JTextField jtfTitle;
	private JTextField jtfAuthor;
	private JTextField jtfGenre;
	private JTextField jtfRating;
	private JTextField jtfLength;
	private JComboBox<Item.ItemType> jcbType;
	private Item.ItemType type;
	private String title;
	private String author;
	private String genre;
	private int rating;
	private double length;
	private int index;
	private JLabel jlLength;
	
	/**
	 * Constructor for a JDialog for adding new Item to Archive
	 * @param frame mainFrame of the program.
	 */
	public EditItemDialog(JFrame frame, Item item, int index) {
		super(frame, true); 
		this.setTitle("Edit item in library");
		this.setLayout(new BorderLayout());
		
		this.type = item.getType();
		this.index = index;
		JLabel jlTitle = new JLabel("Title:");
		JLabel jlAuthor = new JLabel("Author:");
		JLabel jlRating = new JLabel("Rating (0 - 5):");
		jlLength = new JLabel("Length (Pages or Minutes) :");
		JLabel jlType = new JLabel("Type:");
		JLabel jlGenre = new JLabel("Genre:");
		
	    jtfTitle = new JTextField(item.getTitle());
		jtfAuthor = new JTextField(item.getAuthor());
		jtfGenre = new JTextField(item.getGenre());
		jtfRating = new JTextField(Integer.toString(item.getRating()));
		jtfLength = new JTextField(Double.toString(item.getLength()));
		jcbType = new JComboBox<Item.ItemType>();
		JTextField[] textfields = {jtfTitle, jtfAuthor, jtfGenre, jtfRating, jtfLength};
		
		for (Item.ItemType type : Item.ItemType.values())
				jcbType.addItem(type);
		
		for (JTextField field : textfields) {
			field.addKeyListener(new QuickSetListener());
		}
		
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(6,2));
		
		JPanel p2 = new JPanel();
		JButton jbSet = new JButton("Set");
		JButton jbClose = new JButton("Close");
		jbSet.addActionListener(new SetListener());
		jbSet.setToolTipText("Quick Set (Ctrl+Enter)");
		jbClose.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		jcbType.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				jlLength.setText(getLengthString());
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
		
		p2.add(jbSet);
		p2.add(jbClose);
		
		this.add(p1, BorderLayout.NORTH);
		this.add(p2, BorderLayout.SOUTH);
		
		this.pack();
		this.setResizable(false);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(frame);
		this.setVisible(true);
	}
	
	public String getLengthString(){
		switch ((Item.ItemType) jcbType.getSelectedItem()){
		case BOOK : return "Pages :";
		case MUSIC : return "Minutes :";
		default : 
			System.err.println("No case for selected type");
			return "";
		}	
	}
	
	class QuickSetListener extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			if ((e.getKeyCode() == KeyEvent.VK_ENTER) && ((e.getModifiers() & KeyEvent.CTRL_MASK) !=0))
			SetItem();
		}
	}
	
	private void SetItem() {	
		if (!jtfTitle.getText().isEmpty())
			title = jtfTitle.getText();
			
		if (!jtfAuthor.getText().isEmpty())
			author = jtfAuthor.getText();
		
		try  {
		if (!jtfRating.getText().isEmpty()) 
			rating = Integer.valueOf(jtfRating.getText());
		
		if (jtfLength.getText().isEmpty())
			length = Double.valueOf(jtfLength.getText());
		} catch (NumberFormatException e) {
			System.err.print("Input must be a number");
		}
		
		if (!jtfGenre.getText().isEmpty())
			genre = jtfGenre.getText();
		
		try {
		switch (type) {
		case BOOK : Archive.instance.setItem(new Book(title, author, length, genre, rating, type), index); break;
		case MUSIC : Archive.instance.setItem(new Music(title, author, length, genre, rating, type), index); break;
		}
		}
		catch (IllegalItemException e) {
			System.err.println("Illegal type");
		}
		ListPanel.updateList();
		Archive.instance.setSaved(false);
		dispose();
	}
	/**
	 * Listener for AddButton, adds new Item to Archive on
	 * click.
	 */
	class SetListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
		SetItem();	
		}
	}
}
