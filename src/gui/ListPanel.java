package gui;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;

import library.Archieve;
import library.TitleList;

/**
 * @author Hjalte S. Jorgensen
 * @version 1.00
 */
public class ListPanel extends JPanel {
	
	private DefaultListModel<String> listModel;
	private JList list;
	
	public ListPanel() {
		 listModel = new DefaultListModel<String>();
		 TitleList testList = Archieve.library.getTitles();
		 for (String test : testList.getTitles() ) {
			 listModel.addElement(test);
		 }
		 list = new JList();
		 list.setModel(listModel);
		 this.add(list);
	}
	
	public void addToPanel(String item) {
		listModel.addElement(item);
		list.setModel(listModel);
	}

}
