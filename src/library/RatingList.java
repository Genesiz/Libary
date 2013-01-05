package library;

import items.Items;

import java.util.ArrayList;


public class RatingList {
	
	
	private ArrayList<String> ratinglist;
	
	public RatingList(){
		this.ratinglist = new ArrayList<String>();
	}
	public void addRating(String rating){
		this.ratinglist.add(rating);
	}
	public ArrayList<String> getRatings(){
		return this.ratinglist;
	}
	
	public String[] find(String rating){
		String[] list = new String[ratinglist.size() - 1];
		int i = 0;
		for (String current : ratinglist) {
			if (current.contains(rating)) {
				list[i] = current;
				i++;
			}
		}
		return list;
	}
}