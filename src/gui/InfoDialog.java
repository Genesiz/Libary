package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import items.Item;
import items.Item.ItemType;
import javax.swing.*;

import library.Archive;

public class InfoDialog extends JDialog {
	
	private static final long serialVersionUID = 1L;

	public InfoDialog(MainFrame frame, Item item, final int index) {
		super(frame, true);
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));
		p.setToolTipText("Item info");
		JLabel jlTitle = new JLabel("Title: " + item.getTitle());
		JLabel jlAuthor = new JLabel("Author: " + item.getAuthor());
		JLabel jlGenre = new JLabel("Genre: " + item.getGenre());
		JLabel jlLength;
		if (item.getType() == (ItemType.MUSIC))
			jlLength = new JLabel("Length: " + item.getLength());
		else
			jlLength = new JLabel("Pages: " + item.getLength());
		
		JLabel jlRating = new JLabel("Rating: " + item.getRating());
		JButton jbDelete = new JButton("Delete");
		JButton jbCancel = new JButton("Cancel");
		
		jbDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Archive.library.getLibrary().remove(index);
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
		this.pack();
		if (item.getType() == (ItemType.MUSIC))
			this.setTitle("Music");
		else
			this.setTitle("Book");
		this.setResizable(false);
		this.setLocationRelativeTo(frame);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);

	}

}
