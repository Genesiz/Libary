package gui;


import items.Item;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;


import javax.imageio.ImageIO;
import javax.swing.*;

import library.Archive;

public class InfoDialog extends JDialog {
	
	private static final long serialVersionUID = 1L;
	private Image image;
	private JLabel jlRating;
	private Item item;
	
	/**
	 * Makes a JDialog that show an Item and delete button
	 * @param frame the main frame of the program
	 * @param item a non null Item
	 * @param index in Archive.getLibrary for delete button
	 */
	public InfoDialog(MainFrame frame, final Item item, Image starImg) {
		super(frame, true);
		this.item = item;
		image = starImg;
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));
		JLabel jlTitle = new JLabel("Title: " + item.getTitle());
		JLabel jlAuthor = new JLabel("Author: " + item.getAuthor());
		JLabel jlGenre = new JLabel("Genre: " + item.getGenre());
		JLabel jlLength = new JLabel("#");

		switch (item.getType()) {
		case BOOK:
			jlLength = new JLabel("Length: " + item.getLength());
			break;
		case MUSIC:
			jlLength = new JLabel("Pages: " + item.getLength());
			break;		
		}
		
		JButton jbDelete = new JButton("Delete");
		JButton jbCancel = new JButton("Cancel");

		jlRating = new JLabel("Rating: " + item.getRating());

		jbDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Archive.library.getLibrary().remove(item);
				ListPanel.updateList();
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
		p2 .add(jbDelete);
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
		int size = 15;
	    int space = size + 2;
		for (int i = 1; i <= item.getRating() ; i++) {
			g.drawImage(image, (jlRating.getWidth() - 5) 
	       		+ (i * space), (this.getHeight() - jlRating.getY() + 3),
	       		size, size, null); 
		}  
	}
}
