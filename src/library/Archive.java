package library;

import items.Item;
import java.util.ArrayList;

public class Archive {
	
	private ArrayList<Item> archieve;
	
	public static Archive library = new Archive();
	

	/**
	 * Constructor for Archive.
	 * Creates an ArrayList<Item>
	 */
	private Archive() {	
		this.archieve = new ArrayList<Item>();
	}
	
	/**
	 * Adds a new item to Archive
	 * @param item non null Item
	 */
	public void addItem(Item item) {
		this.archieve.add(item);
	}
	
	/**
	 * Return the archive of Items
	 * @return ArrayList<Item>
	 */
	public ArrayList<Item> getLibrary() {
		return this.archieve;
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
	
	public String[] getInfoNames() {
		return Item.columnNames;
		
	}
}
