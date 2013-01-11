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
import javax.swing.event.RowSorterEvent;
import javax.swing.event.RowSorterListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import library.Archive;

public class ListPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private static JTable table;
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
		table = new JTable(model);
		table.getColumnModel().getColumn(columns - 1).setPreferredWidth(10);
		table.getColumnModel().getColumn(columns - 2).setPreferredWidth(10);
		table.getColumnModel().getColumn(columns - 3).setPreferredWidth(10);
		table.getTableHeader().setReorderingAllowed(false);
		
		TableRowSorter<DefaultTableModel> sorter 
	    = new TableRowSorter<DefaultTableModel>(model);
		
        sorter.addRowSorterListener(
                new RowSorterListener() {

                    @Override
                    public void sorterChanged(RowSorterEvent e) {
                        if (e.getType() == RowSorterEvent.Type.SORTED) {
                        	System.out.println("Sort");
                        	Archive.library.sort(table.getSelectedColumn());
                        	updateList();
                        }
                    }
                });	
		table.setRowSorter(sorter);
		
		ListSelectionModel selectionModel = table.getSelectionModel();  
        selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  
        selectionModel.addListSelectionListener(new RowListener()); 

		scrollPane = new JScrollPane(table);
		this.add(jLabel);
		table.setToolTipText("Click to see more info");
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
		table.setModel(model);
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
		table.setModel(model);
		}
	}
	
	/**
	 * Listener class for selected row in JTable
	 * Opens a new InfoDialog on click.
	 */
	class RowListener implements ListSelectionListener {
		@Override
		public void valueChanged(ListSelectionEvent arg0) {
			int select = table.getSelectedRow();
			if (select != -1) {
				Item item = null;
				String title = (String) table.getValueAt(select, 0);
				String author = (String) table.getValueAt(select, 1);
				String genre = (String) table.getValueAt(select, 2);
				double length = (double) table.getValueAt(select, 3);
				int rating = (int) table.getValueAt(select, 4);
				ItemType type = (ItemType) table.getValueAt(select, 5);
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
				if (item != null) {
					new InfoDialog(MainFrame.frame, item);
				}
			}
		}
	}
}
