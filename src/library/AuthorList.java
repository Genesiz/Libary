package library;

import items.Items;

import java.util.ArrayList;


public class AuthorList {
	
	
	private ArrayList<String> authorlist;
	
	public AuthorList(){
		this.authorlist = new ArrayList<String>();
	}
	public void addAuthor(String author){
		this.authorlist.add(author);
	}
	public ArrayList<String> getauthors(){
		return this.authorlist;
	}
	
	public String[] find(String author){
		String[] list = new String[authorlist.size() - 1];
		int i = 0;
		for (String current : authorlist) {
			if (current.contains(author)) {
				list[i] = current;
				i++;
			}
		}
		return list;
	}
}
