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
	 * Make it use JTable and rowfilter instead
	 */
	public ListPanel() {
		model = new DefaultTableModel(null, Archive.library.columnNames) {
			private static final long serialVersionUID = 1L;
			
			public boolean isCellEditable(int row,int cols) {
		    	   return false;
		    }
		};
		model.setColumnCount(Archive.library.columnNames.length);
		model.setRowCount(Archive.library.getLibrary().size());
		
		JLabel jLabel = new JLabel("Search result:");
		jlSearchResult = new JTable(model);

		ListSelectionModel selectionModel = jlSearchResult.getSelectionModel();  
        selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  
        selectionModel.addListSelectionListener(new RowListener()); 
		scrollPane = new JScrollPane(jlSearchResult);
		this.add(jLabel);
		jlSearchResult.setToolTipText("Click to see more info");
	    this.add(scrollPane);
	}
	
	public static void updateList() {
		model.setRowCount(Archive.library.getLibrary().size());
		
		for (int i = 0; i < Archive.library.getLibrary().size(); i++) {
			model.setValueAt(Archive.library.getItemAt(i).getTitle(), i, 0);
			model.setValueAt(Archive.library.getItemAt(i).getAuthor(), i, 1);
			model.setValueAt(Archive.library.getItemAt(i).getGenre(), i, 2);
			model.setValueAt(Archive.library.getItemAt(i).getLength(), i, 3);
			model.setValueAt(Archive.library.getItemAt(i).getRating(), i, 4);
		}	
		jlSearchResult.setModel(model);

	}
	
	public static void updateList(Item[] array) {
		model.setRowCount(array.length);

		for (int i = 0; i < array.length; i++) {
			model.setValueAt(array[i].getTitle(), i, 0);
			model.setValueAt(array[i].getAuthor(), i, 1);
			model.setValueAt(array[i].getGenre(), i, 2);
			model.setValueAt(array[i].getLength(), i, 3);
			model.setValueAt(array[i].getRating(), i, 4);
		}
		jlSearchResult.setModel(model);
	}
	
	class RowListener implements ListSelectionListener {

		@Override
		public void valueChanged(ListSelectionEvent arg0) {
			if (arg0.getValueIsAdjusting()) {
				int index = jlSearchResult.getSelectedRow();
				Item item = Archive.library.getItemAt(index);
				new InfoDialog(MainFrame.frame, item);
			}
		}
		
	}

}
