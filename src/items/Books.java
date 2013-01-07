package items;

public class Books extends Items {
	
	private String title, author, genre;
	private ItemType type;
	private int rating;
	private double length;
	

	public Books(String title, String author, double length, 
			String genre, int rating, ItemType type) throws IllegalItemException {
		
		if (rating <= 5 && rating >= 0)
			this.rating = rating;
		else 
			throw new IllegalItemException("rating most be between 0 and 5.");

		this.author = author;
		this.genre = genre;
		this.length = length;
		this.title = title;
		this.type = type;
		
	}
	@Override
	public String GetTitle() {
		return this.title;
	}

	@Override
	public String GetAuthor() {
		return this.author;
	}

	@Override
	public double GetLength() {
		return this.length;
	}

	@Override
	public String GetGenre() {
		return this.genre;
	}

	@Override
	public int GetRating() {
		return this.rating;
	}

	@Override
	public ItemType GetType() {
		return this.type;
	}

}
