package gui;


import java.awt.Dimension;

import items.Item;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import library.Archive;

/**
 * @author Hjalte S. Jorgensen
 * @version 1.00
 */
public class ListPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private static DefaultListModel<String> list;
	private static JList<String> jlSearchResult;
	private JScrollPane scrollPane;

	/**
	 * Make it use JTable and rowfilter instead
	 */
	public ListPanel() {
		JLabel jLabel = new JLabel("Search result:");
		jlSearchResult = new JList<String>();
		
		TitledBorder titledBorder = new TitledBorder("Title:");
	      
		jlSearchResult.setBorder(titledBorder);
		scrollPane = new JScrollPane(jlSearchResult);
		
		jlSearchResult.setVisibleRowCount(5);
		jlSearchResult.setSize(100, 100);
		this.add(jLabel);
	    this.add(scrollPane);
	}
	
	public static void updateList(String[] array) {
		 list = new DefaultListModel<String>();
		 for (String test : array) {
			 list.addElement(test);
		 }
		 jlSearchResult.setModel(list);	 
	}

}
