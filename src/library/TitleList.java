package library;

import items.Items;

import java.util.ArrayList;


public class TitleList {
	
	
	private ArrayList<String> titleList;
	
	public TitleList(){
		this.titleList = new ArrayList<String>();
	}
	public void addTitle(String title){
		this.titleList.add(title);
	}
	public ArrayList<String> getTitles(){
		return this.titleList;
	}
	
	public String[] find(String title){
		int count = 0;
		for (String current : titleList) {
			if (current.contains(title)) {
				count ++;
			}
		}
		String[] list = new String[count];
		int i = 0;
		for (String current : titleList) {
			if (current.contains(title)) {
				list[i] = current;
				i++;
			}
		}
		return list;
	}
}
