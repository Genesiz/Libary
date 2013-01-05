package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Mainframe extends JFrame {
	
	
	
	public Mainframe(){
		 JPanel p1 = new JPanel();
		 JPanel p2 = new JPanel();
		 
		 p1.setLayout(new FlowLayout());
		
		 
		 JButton jbtNew = new JButton("Add new");
		 JTextField jtfSearch = new JTextField(10);
		 JCheckBox jcbTitle = new JCheckBox("Title");
		 JCheckBox jcbAuthor = new JCheckBox("Author");
		 JCheckBox jcbGenre = new JCheckBox("Genre");
		 JCheckBox jcbLength = new JCheckBox("Length");
		 JCheckBox jcbRating = new JCheckBox("Rating");
		 JTextField jtfSearch2 = new JTextField(10);
		 
		 p2.setLayout(new FlowLayout());
		
		 
		 p1.add(jbtNew);
		 p1.add(jtfSearch);
		 p1.add(jcbTitle);
		 p1.add(jcbAuthor);
		 p1.add(jcbGenre);
		 p1.add(jcbLength);
		 p1.add(jcbRating);
		 
		 p2.add(jtfSearch2);
		 
		 setLayout(new BorderLayout());
	
		 this.add(p1, BorderLayout.WEST);
		 this.add(p2, BorderLayout.EAST);
		 
	}

}
