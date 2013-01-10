package gui;

import items.Item;
import items.Item.ItemType;
import javax.swing.*;

public class InfoDialog extends JDialog {
	
	private static final long serialVersionUID = 1L;

	public InfoDialog(MainFrame frame, Item item) {
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

		p.add(jlTitle);
		p.add(jlAuthor);
		p.add(jlGenre);
		p.add(jlLength);
		p.add(jlRating);
		this.add(p);
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
