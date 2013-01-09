package library;

import java.util.ArrayList;
@Deprecated
public class TitleList {
	
	private ArrayList<String> titleList;
	
	public TitleList() {
		this.titleList = new ArrayList<String>();
	}
	
	public void addTitle(String title) {
			this.titleList.add(title);
	}
	
	public ArrayList<String> getTitles() {
		return this.titleList;
	}
	
	public String[] find(String title) {
		int count = 0;
		for (String current : this.getTitles()) {
			if (current.toLowerCase().contains(title.toLowerCase())) 
				count++;
		}
		
		String[] list = new String[count];
		int i = 0;
		for (String current : this.getTitles()) {
			if (current.toLowerCase().contains(title.toLowerCase())) {
				list[i] = current;
				i++;
			}
		}
		return list;
	}
}
