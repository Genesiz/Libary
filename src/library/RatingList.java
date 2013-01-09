package library;

import java.util.ArrayList;
@Deprecated
public class RatingList {
	
	private ArrayList<Integer> ratinglist;
	
	public RatingList() {
		this.ratinglist = new ArrayList<Integer>();
	}
	
	public void addRating(int i) {
		this.ratinglist.add(i);
	}
	
	public ArrayList<Integer> getRatings() {
		return this.ratinglist;
	}
	
	public Integer[] find(Integer rating) {
		int count = 0;
		for (Integer current : ratinglist) {
			if (current == rating) {
				count ++;
			}
		}
		Integer[] list = new Integer[count];
		int i = 0;
		for (Integer current : ratinglist) {
			if (current == rating) {
				list[i] = current;
				i++;
			}
		}
		return list;
	}
}