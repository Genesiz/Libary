package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;


public class SaveOnClose extends JDialog {
	
	JButton jbtYes;
	JButton jbtNo;
	JLabel jlbQuestion;
	
	public SaveOnClose(){
		JDialog p = new JDialog();
		p.setLayout(new BorderLayout());
		jbtYes = new JButton("Yes");
		jbtNo = new JButton("No");
		jlbQuestion = new JLabel("Do you wish to save before exiting?");
		
		this.add(jlbQuestion, BorderLayout.NORTH);
		this.add(jbtYes, BorderLayout.SOUTH);
		this.add(jbtNo, BorderLayout.SOUTH);
		
		
	}

}
