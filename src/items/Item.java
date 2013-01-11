package items;

import java.text.DecimalFormat;

public abstract class Item {
	
	public enum ItemType {
		BOOK, MUSIC;
		
		public String toString() {
			switch (this) {
			case BOOK:
				return "BOOK";
			case MUSIC:
				return "MUSIC";
			default:
				return "UNKNOWN";
			}			
		}
	}
	
	public enum ItemInfo {
		TITLE, AUTHOR, GENRE, RATING, TYPE, LENGTH
	}
	
	public static String[] columnNames = {"Title", "Author", "Genre",
			"Length", "Rating", "Type"};

	public abstract String getTitle();
	public abstract String getAuthor();
	public abstract double getLength();
	public abstract String getGenre();
	public abstract int getRating();
	public abstract ItemType getType();
	public abstract void printItem();
		
	public boolean equals(Object other) {
		Item o = (Item) other;
		return this.getAuthor().equals(o.getAuthor())
				&& this.getTitle().equals(o.getTitle()) 
						&& this.getGenre().equals(o.getGenre())
						&& this.getRating() == o.getRating()
						&& this.getLength() == o.getLength();
	}
	
	public String formatToFile() {
		String format = new DecimalFormat("#.##").format(this.getLength());
		return String.format("%s; %s; %s; %s; %s; %d;", this.getType().toString(), this.getTitle(), this.getAuthor(), this.getGenre(), format, this.getRating());
		
	}
}
