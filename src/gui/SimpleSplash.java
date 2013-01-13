package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JWindow;

@SuppressWarnings("serial")
public class SimpleSplash extends JWindow {

	public static SimpleSplash instance = new SimpleSplash();
	
	private SimpleSplash() {
		this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		this.setLayout(new FlowLayout());
		this.add(new JLabel("Loading ... Please wait!"));
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.CYAN);
		this.pack();
		this.setAlwaysOnTop(true);
	}
}
