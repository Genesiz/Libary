package gui;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

public class ListPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private static JTable jlSearchResult;
	private JScrollPane scrollPane;

	/**
	 * Make it use JTable and rowfilter instead
	 */
	public ListPanel() {
		JLabel jLabel = new JLabel("Search result:");
		jlSearchResult = new JTable();
		
		TitledBorder titledBorder = new TitledBorder("Title:");
	      
		jlSearchResult.setBorder(titledBorder);
		scrollPane = new JScrollPane(jlSearchResult);
		
		jlSearchResult.setSize(100, 100);
		this.add(jLabel);
	    this.add(scrollPane);
	}
	
	public static void updateList(String[] array) {

	}

}
