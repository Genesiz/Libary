package items;

public class Music extends Item {
	
	private String title, author, genre;
	private double length;
	private int rating;
	private ItemType type;
	
	public Music(String title, String author, double length, String genre,
			int rating, ItemType type) throws IllegalItemException {
		
		if  (rating  <= 5 && rating >= 0)
		this.rating = rating;
		else throw new IllegalItemException("Rating must be between 0 and 5");
		
		this.title = title;
		this.author = author;
		this.length = length;
		this.genre = genre;
		this.type = type;	
	}

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public String getAuthor() {
		return author;
	}

	@Override
	public double getLength() {
		return length;
	}

	@Override
	public String getGenre() {
		return genre;
	}

	@Override
	public int getRating() {
		return rating;
	}

	@Override
	public ItemType getType() {
		return type;
	}

	@Override
	public void printItem() {
		System.out.printf("Title: %s, Author: %s, Genre: %s, " +
				"Length: %.2f, Rating: %d, Type: %s %n",
				this.getTitle(), this.getAuthor(), this.getGenre(),
				this.getLength(), this.getRating(), this.getType()); 		
	}

	
}
