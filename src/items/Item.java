package items;

public abstract class Item {
	
	public enum ItemType {
		BOOK, MUSIC
	}

	public abstract String getTitle();
	public abstract String getAuthor();
	public abstract double getLength();
	public abstract String getGenre();
	public abstract int getRating();
	public abstract ItemType getType();
	public abstract void printItem();
	
}
