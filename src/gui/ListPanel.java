package gui;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;

import library.Archive;
import library.TitleList;

/**
 * @author Hjalte S. Jorgensen
 * @version 1.00
 */
public class ListPanel extends JPanel {
	
	private DefaultListModel<String> list;

	public ListPanel() {
		 DefaultListModel<String> listModel = new DefaultListModel<String>();
		 TitleList testList = Archive.library.getTitles();
		 for (String test : testList.getTitles() ) {
			 listModel.addElement(test);
		 }
		 JList list = new JList();
		 list.setModel(listModel);
		 this.add(list);
		 
		
	}

}
