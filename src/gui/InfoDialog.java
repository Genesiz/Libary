package gui;

import items.Item;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import library.Archive;

public class InfoDialog extends JDialog {
	
	private static final long serialVersionUID = 1L;
	private Image image;
	private JLabel jlRating;
	private Item item;
	private int index;
	private JLabel jlTitle;
	private JLabel jlAuthor;
	private JLabel jlGenre;
	private JLabel jlLength;	
	
	/**
	 * Makes a JDialog that show an Item and delete button
	 * @param frame the main frame of the program
	 * @param item a non null Item
	 * @param index in Archive.getLibrary for delete button
	 */
	public InfoDialog(MainFrame frame, final Item item, Image starImg) {
		super(frame, true);
		index = Archive.library.getIndexOf(item);
		this.item = item;
		image = starImg;
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));
		jlTitle = new JLabel("Title: " + item.getTitle());
		jlAuthor = new JLabel("Author: " + item.getAuthor());
		jlGenre = new JLabel("Genre: " + item.getGenre());
		jlLength = new JLabel("#");
		jlRating = new JLabel("Rating: ");


		switch (item.getType()) {
		case BOOK:
			jlLength = new JLabel("Length: " + item.getLength());
			break;
		case MUSIC:
			jlLength = new JLabel("Pages: " + item.getLength());
			break;		
		}
		
		JButton jbDelete = new JButton("Delete");
		JButton jbEdit   = new JButton("Edit");
		JButton jbCancel = new JButton("Cancel");

		jbDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Archive.library.getLibrary().remove(item);
				ListPanel.updateList();
				dispose();
				Archive.library.setSaved(false);
			}
		});
		
		jbEdit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new EditItemDialog(MainFrame.frame, item, index);
				dispose();
			}
			
		});
		
		jbCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		
		p.add(jlTitle);
		p.add(jlAuthor);
		p.add(jlGenre);
		p.add(jlLength);
		p.add(jlRating);
		
		JPanel p2 = new JPanel();
		p2.add(jbDelete);
		p2.add(jbEdit);
		p2.add(jbCancel);
		
		this.setLayout(new BorderLayout());
		this.add(p, BorderLayout.PAGE_START);
		this.add(p2, BorderLayout.PAGE_END);
		this.setTitle(item.getType().toString());
		this.pack();
		this.setResizable(false);
		this.setLocationRelativeTo(frame);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		int size = jlRating.getHeight();
		int yPoint;
		if (System.getProperty("os.name").equals("Windows 7"))
			yPoint = this.getHeight() - jlRating.getY();
		else 
			yPoint = jlRating.getY();
		int space = size + 2;

		for (int i = 1; i <= item.getRating() ; i++) {
			int xPoint = (jlRating.getWidth() - size) + (i * space);
			g.drawImage(image, xPoint, yPoint, size, size, null); 
		}  
	}
}
