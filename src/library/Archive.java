package library;

import items.Item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Archive {
	
	private ArrayList<Item> archive;
	public static Archive library = new Archive();
	private boolean saved = true;
	
	/**
	 * Constructor for Archive.
	 * Creates an ArrayList<Item>
	 */
	private Archive() {	
		this.archive = new ArrayList<Item>();
	}
	
	/**
	 * Adds a new item to Archive
	 * @param item non null Item
	 */
	public void addItem(Item item) {
		this.archive.add(item);
	}
	
	/**
	 * Return the archive of Items
	 * @return ArrayList<Item>
	 */
	public ArrayList<Item> getLibrary() {
		return this.archive;
	}
	
	/**
	 * Return the Item at an given index.
	 * @param index
	 * @return Item at index, or null if not valid index
	 */
	public Item getItemAt (int index) {
		if (this.getLibrary().size() > index)
			return this.getLibrary().get(index);
		return null;
	}
	
	public int getIndexOf (Item item) {
		return this.getLibrary().indexOf(item);
	}
	
	
	/**
	 * Used for JTable
	 * @return a String[] of column names
	 */
	public String[] getInfoNames() {
		return Item.columnNames;
	}
	
	public void setItem(Item item, int index) {
		this.getLibrary().set(index, item);
	}
	
	/**
	 * 
	 * @param i column index to sort after
	 */
	public void sort(final int i) {
		Collections.sort(this.getLibrary(), new Comparator<Item>() {

			@Override
			public int compare(Item arg0, Item arg1) {
				
				switch (i) {
				case 0:
					return arg0.getTitle().compareTo(arg1.getTitle());
				case 1:
					return arg0.getAuthor().compareTo(arg1.getAuthor());
				case 2:
					return arg0.getGenre().compareTo(arg1.getGenre());
				case 3: 
					if (arg0.getLength() == arg1.getLength())
						return 0;
					else if (arg0.getLength() < arg1.getLength())
						return (int) arg0.getLength();
					else 
						return (int) arg1.getLength();
				case 4:
					if (arg0.getRating() == arg1.getRating())
						return 0;
					else if (arg0.getRating() < arg1.getRating())
						return arg0.getRating();
					else 
						return arg1.getRating();
				case 5:
					return arg0.getType().compareTo(arg1.getType());
				default:
					return 0;	
				}
			}
		});
	}
	
	public boolean isSaved() {
		return saved;
	}
	
	public void setSaved(boolean bool) {
		saved = bool;
	}
}
