package library;

import items.Items;

import java.util.ArrayList;


public class GenreList {
	
	
	private ArrayList<String> genrelist;
	
	public GenreList(){
		this.genrelist = new ArrayList<String>();
	}
	public void addGenre(String author){
		this.genrelist.add(author);
	}
	public ArrayList<String> getgenres(){
		return this.genrelist;
	}
	
	public String[] find(String genre){
		int count = 0;
		for (String current : genrelist) {
			if (current.contains(genre)) {
				count ++;
			}
		}
		String[] list = new String[count];
		int i = 0;
		for (String current : genrelist) {
			if (current.contains(genre)) {
				list[i] = current;
				i++;
			}
		}
		return list;
	}
}