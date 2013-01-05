package items;

public class Music extends Items {
	
	private String title;
	private String author;
	private double length;
	private String genre;
	private int rating;
	private String type;
	
	public Music(String title, String author, double length, String genre,int rating, String type) throws IllegalItemException{
		
		if  (rating  < 5 && rating > 0)
		this.rating = rating;
		else throw new IllegalItemException("Rating must be between 0 and 5");
		
		this.title = title;
		
		this.author = author;
		
		this.length = length;
		
		this.genre = genre;
	
		this.type = type;
		
		
	}

	@Override
	public String GetTitle() {
		return title;
	}

	@Override
	public String GetAuthor() {
		return author;
	}

	@Override
	public double GetLength() {
		return length;
	}

	@Override
	public String GetGenre() {
		return genre;
	}

	@Override
	public int GetRating() {
		return rating;
	}

	@Override
	public String GetType() {
		return type;
	}

	
}
