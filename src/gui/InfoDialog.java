package gui;

import items.Items;

import java.awt.*;
import javax.swing.*;

public class InfoDialog extends JDialog {
	
	private static final long serialVersionUID = 1L;

	public InfoDialog(Items item) {
		JPanel panel = new JPanel();
		GridLayout layout = new GridLayout(6,2);
		
		JLabel jlTitle = new JLabel("Title: " + item.GetTitle());
		
		panel.add(jlTitle);
		
		this.setLayout(layout);
		this.add(panel);
		this.pack();
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);

	}

}
