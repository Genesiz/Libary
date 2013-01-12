package items;

public class Book extends Item {
	
	private String title, author, genre;
	private ItemType type;
	private int rating;
	private double length;
	
	public Book(String title, String author, double length, 
			String genre, int rating, ItemType type) 
					throws IllegalItemException {
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
	public String getTitle() {
		return this.title;
	}

	@Override
	public String getAuthor() {
		return this.author;
	}

	@Override
	public double getLength() {
		return this.length;
	}

	@Override
	public String getGenre() {
		return this.genre;
	}

	@Override
	public int getRating() {
		return this.rating;
	}

	@Override
	public ItemType getType() {
		return this.type;
	}
	@Override
	public void printItem() {
		System.out.printf("Title: %s, Author: %s, Genre: %s, " +
				"Length: %.2f, Rating: %d, Type: %s %n",
				this.getTitle(), this.getAuthor(), this.getGenre(),
				this.getLength(), this.getRating(), this.getType());	
	}

}
