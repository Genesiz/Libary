package library;

import items.Item;
import java.util.ArrayList;

public class Archive {
	
	private ArrayList<Item> archieve;
	
	public static Archive library = new Archive();
	
	public enum ItemInfo {
		TITLE, AUTHOR, GENRE, RATING
	}
	public String[] columnNames = {"Title", "Author", "Genre",
			"Length", "Rating"};
	
	private Archive() {	
		this.archieve = new ArrayList<Item>();
	}
	
	public void addItem(Item item) {
		this.archieve.add(item);
	}
	
	public ArrayList<Item> getLibrary() {
		return this.archieve;
	}
	
	/**
	 * Return the Item at an given index.
	 * @param index
	 * @return
	 */
	public Item getItemAt (int index) {
		return this.getLibrary().get(index);
	}
	
	/**
	 * Prints out all items in the Archive. 
	 * Used for testing only.
	 */
	public void printLibrary() {
		for (Item item : this.getLibrary() ) {
			item.printItem();
		}
	}
}
