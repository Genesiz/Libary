package library;

import items.Items;

import java.util.ArrayList;

public class Archieve {
	
	private ArrayList<Items> archieve;
	
	public static Archieve library = new Archieve();
	
	private Archieve() {	
		this.archieve = new ArrayList<Items>();
	}
	
	public void addItem(Items item) {
		this.archieve.add(item);
	}
	
	private ArrayList<Items> getLibrary() {
		return this.archieve;
	}
	
	public void printLibrary() {
		for (Items item : this.getLibrary() ) {
			System.out.println(
					String.format("Title: %s, Author: %s, Genre: %s, " +
							"Length: %f, Rating: %d, Type: %s",
							item.GetTitle(), item.GetAuthor(), item.GetGenre(),
							item.GetLength(), item.GetRating(), item.GetType() ));
		}
	}

}
