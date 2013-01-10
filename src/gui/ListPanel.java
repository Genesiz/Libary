package gui;

import items.Item;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import library.Archive;

public class ListPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private static JTable jlSearchResult;
	private JScrollPane scrollPane;
	private static DefaultTableModel model;

	/**
	 * Makes the JTable to list all Items.
	 */
	public ListPanel() {
		model = new DefaultTableModel(null, Archive.library.getInfoNames()) {
			private static final long serialVersionUID = 1L;
			
			public boolean isCellEditable(int row,int cols) {
		    	   return false;
		    }
		};
		int columns = Archive.library.getInfoNames().length;
		model.setColumnCount(columns);
		model.setRowCount(Archive.library.getLibrary().size());
		
		JLabel jLabel = new JLabel("Search result:");
		jlSearchResult = new JTable(model);
		jlSearchResult.getColumnModel().getColumn(columns - 1).setPreferredWidth(10);
		jlSearchResult.getColumnModel().getColumn(columns - 2).setPreferredWidth(10);

		ListSelectionModel selectionModel = jlSearchResult.getSelectionModel();  
        selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  
        selectionModel.addListSelectionListener(new RowListener()); 
		scrollPane = new JScrollPane(jlSearchResult);
		this.add(jLabel);
		jlSearchResult.setToolTipText("Click to see more info");
	    this.add(scrollPane);
	}
	
	/**
	 * Updates the Model for the JTable with the Archive.getLibrary instance
	 */
	public static void updateList() {
		int size = Archive.library.getLibrary().size();
		model.setRowCount(size);
		
		for (int i = 0; i < size; i++) {
			Item item = Archive.library.getItemAt(i);
			model.setValueAt(item.getTitle(), i, 0);
			model.setValueAt(item.getAuthor(), i, 1);
			model.setValueAt(item.getGenre(), i, 2);
			model.setValueAt(item.getLength(), i, 3);
			model.setValueAt(item.getRating(), i, 4);
		}	
		jlSearchResult.setModel(model);

	}
	
	/**
	 * Updates the Model for the JTable with an Item[]
	 * Used for updating table with search results.
	 * @param array Item[]
	 */
	public static void updateList(Item[] array) {
		int size = array.length;
		model.setRowCount(size);

		for (int i = 0; i < size; i++) {
			Item item = array[i];
			model.setValueAt(item.getTitle(), i, 0);
			model.setValueAt(item.getAuthor(), i, 1);
			model.setValueAt(item.getGenre(), i, 2);
			model.setValueAt(item.getLength(), i, 3);
			model.setValueAt(item.getRating(), i, 4);
		}
		jlSearchResult.setModel(model);
	}
	
	/**
	 * Listener class for selected row in JTable
	 * Opens a new InfoDialog on click.
	 */
	class RowListener implements ListSelectionListener {

		@Override
		public void valueChanged(ListSelectionEvent arg0) {
			if (arg0.getValueIsAdjusting()) {
				int index = jlSearchResult.getSelectedRow();
				if (index != -1) {
					Item item = Archive.library.getItemAt(index);
					new InfoDialog(MainFrame.frame, item, index);
				}
			} 
		}
		
	}

}
