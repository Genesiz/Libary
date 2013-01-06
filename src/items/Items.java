package items;


public abstract class Items {
	
	public enum ItemType {
		BOOK, MUSIC
	}

	public abstract String GetTitle();
	public abstract String GetAuthor();
	public abstract double GetLength();
	public abstract String GetGenre();
	public abstract int GetRating();
	public abstract ItemType GetType();
	
}
