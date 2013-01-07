package library;

import items.Item;

import java.util.ArrayList;

import library.Archive.ItemInfo;

public class Search {
	
	public Search() {	
	}
	
	public Item[] find(String keyword,ItemInfo itemInfo) {
		ArrayList<Item> tempArchieve = Archive.library.getLibrary();
		int count = 0;
		int i = 0;

		switch (itemInfo) {
		case TITLE : 	for (Item current : tempArchieve) {
							String str = current.getTitle().toLowerCase();
							if (str.contains(keyword.toLowerCase())) {
								count ++;
							}
						}
						Item[] list = new Item[count];
						i = 0;
							for (Item current : tempArchieve) {
								String str = current.getTitle().toLowerCase();
								if (str.contains(keyword.toLowerCase())) {
									list[i] = current;
									i++;
								}
							}
							return list;
							
		case AUTHOR :  
					for (Item current : tempArchieve) {
						String str = current.getAuthor().toLowerCase();
						if (str.contains(keyword.toLowerCase())) {
							count ++;
						}
					}
					Item[] list2 = new Item[count];
					i = 0;
						for (Item current : tempArchieve) {
							String str = current.getAuthor().toLowerCase();
							if (str.contains(keyword.toLowerCase())) {
								list2[i] = current;
								i++;
							}
						}
						return list2;
			
			
		
			case GENRE:
						for (Item current : tempArchieve) {
						String str = current.getGenre().toLowerCase();
						if (str.contains(keyword.toLowerCase())) {
							count ++;
						}
					}
					Item[] list3 = new Item[count];
					i = 0;
						for (Item current : tempArchieve) {
							String str = current.getGenre().toLowerCase();
							if (str.contains(keyword.toLowerCase())) {
								list3[i] = current;
								i++;
							}
						}
					return list3;
		case RATING:
					for (Item current : tempArchieve) {
						int rating = current.getRating();
						if (rating == Integer.valueOf(keyword)) {
							count ++;
						}
					}
					Item[] list4 = new Item[count];
					i = 0;
						for (Item current : tempArchieve) {
							int rating = current.getRating();
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
	
	public String[] toStringArray(Item[] itemArray, ItemInfo itemInfo) {
		
		String[] array = new String[itemArray.length];
		int i = 0;
		switch (itemInfo) {
		case AUTHOR:
			for (Item current : itemArray) {
				array[i] = current.getAuthor();
				i++;
			}
			return array;
			
		case GENRE:
			for (Item current : itemArray) {
				array[i] = current.getGenre();
				i++;
			}
			return array;
		case RATING:
			for (Item current : itemArray) {
				array[i] = String.valueOf(current.getRating());
				i++;
			}
			return array;
		case TITLE:
			for (Item current : itemArray) {
				array[i] = current.getTitle();
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
