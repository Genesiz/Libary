package gui;

import io.LoadListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar {
	
	public static MenuBar instance = new MenuBar();
	public JMenu menu;
	public JMenuItem save; 
	public JMenuItem load;

	private MenuBar(){
		menu = new JMenu("File");
		save =  new JMenuItem("Save");
		load = new JMenuItem("Load");
		
	//	save.addActionListener(new SaveListener());
		load.addActionListener(new LoadListener());
		
		menu.add(save);
		menu.add(load);
		this.add(menu);
	}
	
	
}
