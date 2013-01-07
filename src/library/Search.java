package library;

import items.Items;

import java.util.ArrayList;

public class Search {
	
	public Search() {	
	}
	
	public enum ItemInfo {
		TITLE, AUTHOR, GENRE, RATING
	}
	
	public Items[] find(String keyword,ItemInfo itemInfo) {
		ArrayList<Items> tempArchieve = Archive.library.getLibrary();
		int count = 0;
		int i = 0;

		switch (itemInfo) {
		case TITLE : 	for (Items current : tempArchieve) {
							String str = current.GetTitle().toLowerCase();
							if (str.contains(keyword.toLowerCase())) {
								count ++;
							}
						}
						Items[] list = new Items[count];
						i = 0;
							for (Items current : tempArchieve) {
								String str = current.GetTitle().toLowerCase();
								if (str.contains(keyword.toLowerCase())) {
									list[i] = current;
									i++;
								}
							}
							return list;
							
		case AUTHOR :  
					for (Items current : tempArchieve) {
						String str = current.GetAuthor().toLowerCase();
						if (str.contains(keyword.toLowerCase())) {
							count ++;
						}
					}
					Items[] list2 = new Items[count];
					i = 0;
						for (Items current : tempArchieve) {
							String str = current.GetAuthor().toLowerCase();
							if (str.contains(keyword.toLowerCase())) {
								list2[i] = current;
								i++;
							}
						}
						return list2;
			
			
		
			case GENRE:
						for (Items current : tempArchieve) {
						String str = current.GetGenre().toLowerCase();
						if (str.contains(keyword.toLowerCase())) {
							count ++;
						}
					}
					Items[] list3 = new Items[count];
					i = 0;
						for (Items current : tempArchieve) {
							String str = current.GetGenre().toLowerCase();
							if (str.contains(keyword.toLowerCase())) {
								list3[i] = current;
								i++;
							}
						}
					return list3;
		case RATING:
					for (Items current : tempArchieve) {
						int rating = current.GetRating();
						if (rating == Integer.valueOf(keyword)) {
							count ++;
						}
					}
					Items[] list4 = new Items[count];
					i = 0;
						for (Items current : tempArchieve) {
							int rating = current.GetRating();
							if (rating == Integer.valueOf(keyword)) {
								list4[i] = current;
								i++;
							}
						}
				return list4;
		default:
			System.out.println("non found?");
			break; 
						
		}
			
		
		return null;
		
	}
	
	public String[] toStringArray(Items[] itemArray, ItemInfo itemInfo) {
		
		String[] array = new String[itemArray.length];
		int i = 0;
		switch (itemInfo) {
		case AUTHOR:
			for (Items current : itemArray) {
				array[i] = current.GetAuthor();
				i++;
			}
			return array;
			
		case GENRE:
			for (Items current : itemArray) {
				array[i] = current.GetGenre();
				i++;
			}
			return array;
		case RATING:
			for (Items current : itemArray) {
				array[i] = String.valueOf(current.GetRating());
				i++;
			}
			return array;
		case TITLE:
			for (Items current : itemArray) {
				array[i] = current.GetTitle();
				i++;
			}
			return array;
		default:
			System.out.println("Something wrong!");
			break;
		
		}
		return null;
		
	}

}
