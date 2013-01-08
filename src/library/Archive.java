package library;

import items.Item;
import items.Item.ItemType;

import java.util.ArrayList;

public class Archive {
	
	private ArrayList<Item> archieve;
	private TitleList titleList;
	private GenreList genreList;
	private AuthorList authorList;
	private RatingList ratingList;
	
	public static Archive library = new Archive();
	
	public enum ItemInfo {
		TITLE, AUTHOR, GENRE, RATING
	}
	
	private Archive() {	
		this.archieve = new ArrayList<Item>();
		this.titleList = new TitleList();
		this.genreList = new GenreList();
		this.authorList = new AuthorList();
		this.ratingList = new RatingList();
	}
	
	public void addItem(Item item) {
		this.archieve.add(item);
		this.titleList.addTitle(item.getTitle());
		this.authorList.addAuthor(item.getAuthor());
		this.genreList.addGenre(item.getGenre());
		this.ratingList.addRating(item.getRating());
	}
	
	public ArrayList<Item> getLibrary() {
		return this.archieve;
	}
	
	public TitleList getTitles() {
		titleList = new TitleList();
		for (Item item : this.getLibrary()) {
			titleList.addTitle(item.getTitle());
		}
		return titleList;
	}
	
	public GenreList getGenre() {
		genreList = new GenreList();
		for (Item item : this.getLibrary()) {
			genreList.addGenre(item.getGenre());
		}
		return genreList;
	}
	
	public AuthorList getAuthors() {
		authorList = new AuthorList();
		for (Item item : this.getLibrary()) {
			authorList.addAuthor(item.getAuthor());
		}
		return authorList;
	}
	
	public RatingList getRatings() {
		ratingList = new RatingList();
		for (Item item : this.getLibrary()) {
			ratingList.addRating(item.getRating());
		}
		return ratingList;	}
	
	public Item getItemAt (int index) {
		return this.getLibrary().get(index);
	}
	
	/**
	 * Not the best way.
	 * @param find search String of what to find!
	 * @param itemInfo what info to search for : criteria
	 * @return
	 */
	public Item getItem(String find, ItemInfo itemInfo) {
		
		for (Item item : this.getLibrary()) {

		switch (itemInfo) {
		case AUTHOR:
			if (item.getAuthor().equals(find))
				return item;
			break;
		case GENRE:
			if (item.getGenre().equals(find))
				return item;
			break;
		case RATING:
			if (item.getRating() == Integer.valueOf(find))
				return item;
			break;
		case TITLE:
			if (item.getTitle().equals(find))
				return item;
			break;
		default:
			break;
		}			
			
		}
		return null;
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
