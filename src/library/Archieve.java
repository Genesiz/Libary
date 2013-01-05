package library;

import items.Items;

import java.util.ArrayList;

public class Archieve {
	
	private ArrayList<Items> archieve;
	private TitleList titleList;
	
	public static Archieve library = new Archieve();
	
	private Archieve() {	
		this.archieve = new ArrayList<Items>();
		this.titleList = new TitleList();
	}
	
	public void addItem(Items item) {
		this.archieve.add(item);
		this.titleList.addTitle(item.GetTitle());
	}
	
	public ArrayList<Items> getLibrary() {
		return this.archieve;
	}
	
	public TitleList getTitles() {
		return this.titleList;
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
