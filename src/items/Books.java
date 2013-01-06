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

	/* (non-Javadoc)
	 * @see items.Items#GetAuthor()
	 */
	@Override
	public String GetAuthor() {
		// TODO Auto-generated method stub
		return this.author;
	}

	/* (non-Javadoc)
	 * @see items.Items#GetLength()
	 */
	@Override
	public double GetLength() {
		// TODO Auto-generated method stub
		return this.length;
	}

	/* (non-Javadoc)
	 * @see items.Items#GetGenre()
	 */
	@Override
	public String GetGenre() {
		// TODO Auto-generated method stub
		return this.genre;
	}

	/* (non-Javadoc)
	 * @see items.Items#GetRating()
	 */
	@Override
	public int GetRating() {
		// TODO Auto-generated method stub
		return this.rating;
	}

	/* (non-Javadoc)
	 * @see items.Items#GetType()
	 */
	@Override
	public ItemType GetType() {
		// TODO Auto-generated method stub
		return this.type;
	}

}
