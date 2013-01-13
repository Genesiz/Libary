package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import io.LoadListener;
import io.SaveListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import library.Archive;

public class MenuBar extends JMenuBar {
	
	private static final long serialVersionUID = 1L;
	public static MenuBar instance = new MenuBar();
	public JMenu menu;
	public JMenuItem save; 
	public JMenuItem load;
	private JMenuItem exit;

	private MenuBar(){
		menu = new JMenu("File");
		save =  new JMenuItem("Save");
		load = new JMenuItem("Load");
		exit = new JMenuItem("Exit");

		save.addActionListener(new SaveListener());
		load.addActionListener(new LoadListener());
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (Archive.library.isSaved())
					System.exit(0);
				else {
					String[] message = {"Yes" , "No"};
					int choice = JOptionPane.showOptionDialog(MainFrame.frame, "Do you wish to save changes before exiting?",
					"Save changes?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null,
					message, message[0]);
					if (choice == 0) 
						SaveListener.saveState();
					System.exit(0);
				}
			}
		});
		menu.add(save);
		menu.add(load);
		menu.add(exit);
		this.add(menu);
	}
	
	
}
