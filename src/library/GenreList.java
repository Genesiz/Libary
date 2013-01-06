package library;

import java.util.ArrayList;

public class GenreList {
	
	private ArrayList<String> genrelist;
	
	public GenreList() {
		this.genrelist = new ArrayList<String>();
	}
	
	public void addGenre(String author) {
		this.genrelist.add(author);
	}
	
	public ArrayList<String> getgenres() {
		return this.genrelist;
	}
	
	public String[] find(String genre) {
		int count = 0;
		for (String current : genrelist) {
			if (current.toLowerCase().contains(genre.toLowerCase())) {
				count ++;
			}
		}
		String[] list = new String[count];
		int i = 0;
		for (String current : genrelist) {
			if (current.toLowerCase().contains(genre.toLowerCase())) {
				list[i] = current;
				i++;
			}
		}
		return list;
	}
}