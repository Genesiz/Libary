package gui;

import items.IllegalItemException;
import items.Item;
import items.Item.ItemType;
import items.Music;

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
		jlSearchResult.getColumnModel().getColumn(columns - 3).setPreferredWidth(10);

		
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
			model.setValueAt(item.getType(), i, 5);

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
		if (size != 0) {
		for (int i = 0; i < size; i++) {
			Item item = array[i];
			model.setValueAt(item.getTitle(), i, 0);
			model.setValueAt(item.getAuthor(), i, 1);
			model.setValueAt(item.getGenre(), i, 2);
			model.setValueAt(item.getLength(), i, 3);
			model.setValueAt(item.getRating(), i, 4);
			model.setValueAt(item.getType(), i, 5);
		}
		jlSearchResult.setModel(model);
		}
	}
	
	/**
	 * Listener class for selected row in JTable
	 * Opens a new InfoDialog on click.
	 */
	class RowListener implements ListSelectionListener {

		@Override
		public void valueChanged(ListSelectionEvent arg0) {
			int select = jlSearchResult.getSelectedRow();
			if (select != -1) {
				System.out.println("Row selected: " + select);
				Item item = null;
				String title = (String) jlSearchResult.getValueAt(select, 0);
				String author = (String) jlSearchResult.getValueAt(select, 1);
				String genre = (String) jlSearchResult.getValueAt(select, 2);
				double length = (double) jlSearchResult.getValueAt(select, 3);
				int rating = (int) jlSearchResult.getValueAt(select, 4);
				ItemType type = (ItemType) jlSearchResult.getValueAt(select, 5);
				try {
					switch (type) {
					case BOOK:
						item = new Music(title, author, length, 
								genre, rating, Item.ItemType.BOOK);
						break;
					case MUSIC:
						item = new Music(title, author, length, genre,
								rating, Item.ItemType.MUSIC);
						break;
					default:
						System.out.println("Missing type?");
						break;
					}	
				}
				catch (IllegalItemException e) {
						e.printStackTrace();
					}
				int index = Archive.library.getIndexOf(item);
				if (item != null && index != -1) {
					new InfoDialog(MainFrame.frame, item, index);
				}
		}
	}
	}
}
