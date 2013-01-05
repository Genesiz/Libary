package library;

import items.Items;

import java.util.ArrayList;
import java.util.Observable;

public class Archieve {
	
	private ArrayList<Items> archieve;
	private TitleList titleList;
	private GenreList genreList;
	private AuthorList authorList;
	private RatingList ratingList;
	
	public static Archieve library = new Archieve();
	
	private Archieve() {	
		this.archieve = new ArrayList<Items>();
		this.titleList = new TitleList();
		this.genreList = new GenreList();
		this.authorList = new AuthorList();
		this.ratingList = new RatingList();
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
	
	public GenreList getGenre() {
		return this.genreList;
	}
	
	public AuthorList getAuthors() {
		return this.authorList;
	}
	
	public RatingList getRatings() {
		return this.ratingList;
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
