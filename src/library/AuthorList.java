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
		int count = 0;
		for (String current : authorlist) {
			if (current.contains(author)) {
				count ++;
			}
		}
		String[] list = new String[count];
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
