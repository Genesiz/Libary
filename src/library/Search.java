package library;

import items.Item;

import java.util.ArrayList;
import java.util.HashMap;

import library.Archive.ItemInfo;

public class Search {
	
	public Search() {	
	}
	
	public Item[] find(String keyword,ItemInfo itemInfo) {
		ArrayList<Item> arch = Archive.library.getLibrary();
		int count = 0;
		int i = 0;

		switch (itemInfo) {
		case TITLE : 	for (Item current : arch) {
							String str = current.getTitle().toLowerCase();
							if (str.contains(keyword.toLowerCase())) {
								count ++;
							}
						}
						Item[] list = new Item[count];
						i = 0;
							for (Item current : arch) {
								String str = current.getTitle().toLowerCase();
								if (str.contains(keyword.toLowerCase())) {
									list[i] = current;
									i++;
								}
							}
							return list;
							
		case AUTHOR :  
					for (Item current : arch) {
						String str = current.getAuthor().toLowerCase();
						if (str.contains(keyword.toLowerCase())) {
							count ++;
						}
					}
					Item[] list2 = new Item[count];
					i = 0;
						for (Item current : arch) {
							String str = current.getAuthor().toLowerCase();
							if (str.contains(keyword.toLowerCase())) {
								list2[i] = current;
								i++;
							}
						}
						return list2;
			
			
		
			case GENRE:
						for (Item current : arch) {
						String str = current.getGenre().toLowerCase();
						if (str.contains(keyword.toLowerCase())) {
							count ++;
						}
					}
					Item[] list3 = new Item[count];
					i = 0;
						for (Item current : arch) {
							String str = current.getGenre().toLowerCase();
							if (str.contains(keyword.toLowerCase())) {
								list3[i] = current;
								i++;
							}
						}
					return list3;
		case RATING:
					i = 0;
					// prints out all if rating is kept empty.
					if (keyword.isEmpty()) {
						Item[] list5 = new Item[arch.size()];
						for (Item current : arch) {
								list5[i] = current;
								i++;
							}
						return list5;
					}
					for (Item current : arch) {
						int rating = current.getRating();
						if (rating == Integer.valueOf(keyword)) {
							count ++;
						}
					}
					Item[] list4 = new Item[count];
						for (Item current : arch) {
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
	
	public HashMap<Item, Integer> findHash(String keyword,ItemInfo itemInfo) {
		
		ArrayList<Item> arch = Archive.library.getLibrary();
		HashMap<Item, Integer> list = new HashMap<Item, Integer>();
		
		switch (itemInfo) {
		case TITLE : for (int i = 0; i < arch.size(); i++) {
						String str = arch.get(i).getTitle().toLowerCase();
						if (str.contains(keyword.toLowerCase())) {
							list.put(arch.get(i), i);
						}
					}
					return list;
							
		case AUTHOR : for (int i = 0; i < arch.size(); i++) {
						String str = arch.get(i).getAuthor().toLowerCase();
						if (str.contains(keyword.toLowerCase())) {
							list.put(arch.get(i), i);
						}
						}
						return list;
		case GENRE: for (int i = 0; i < arch.size(); i++) {
						String str = arch.get(i).getGenre().toLowerCase();
						if (str.contains(keyword.toLowerCase())) {
							list.put(arch.get(i), i);
						}
					}
						return list;
		case RATING: for (int i = 0; i < arch.size(); i++) {
						int str = arch.get(i).getRating();
						if (str == Integer.valueOf(keyword)) {
							list.put(arch.get(i), i);
						}
					}
					return list;
		default:
			System.out.println("non found?");
			break; 
						
		}
		return list;
		
	}

}
