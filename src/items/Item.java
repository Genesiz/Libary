package items;

public abstract class Item {
	
	public enum ItemType {
		BOOK, MUSIC
	}
	
	public enum ItemInfo {
		TITLE, AUTHOR, GENRE, RATING
	}
	
	public static String[] columnNames = {"Title", "Author", "Genre",
			"Length", "Rating"};

	public abstract String getTitle();
	public abstract String getAuthor();
	public abstract double getLength();
	public abstract String getGenre();
	public abstract int getRating();
	public abstract ItemType getType();
	public abstract void printItem();
	
}
