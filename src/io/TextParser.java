package io;

import items.Book;
import items.IllegalItemException;
import items.Item;
import items.Music;
import items.Item.ItemType;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.MatchResult;

public class TextParser {

	private Scanner scanner;
	private String types = "";
	private String word = "(\\w+\\s*)*";
	private String whitespace = ";\\s*";
	private String regularExp = types + whitespace + word + whitespace + word + whitespace +
			word +whitespace + "([.\\d]+)"+whitespace+ "(\\d+)";
	
	private String firstLine = ("TYPE;\\s*TITLE;\\s*AUTHOR;\\s*GENRE;\\s*LENGTH;\\s*RATING;");    
	private ArrayList<Item> list;
	
	public TextParser(Scanner scanner) {
		this.scanner = scanner;
		for (Item.ItemType type : Item.ItemType.values()) {
			types += "(" + type + ")|";
		}
		types = types.substring(0, types.length() - 1);
		System.out.println(types);
	}
	
	public ArrayList<Item> getItemList() {
		if (scanner.findInLine(firstLine) != null)		{
			scanner.nextLine();
		}
		list = new ArrayList<Item>();
		while (scanner.hasNextLine()) {
			String[] line  = scanner.nextLine().split("; ");
			
			if (line.length == 6) {
				String type = line[0];
				String title = line[1];
				String author = line[2];
				String genre = line[3];
				double length = Double.parseDouble(line[4].replace(',','.').replace(";",""));
				int rating = Integer.parseInt(line[5].replace(";", ""));
				try {	
					switch (type) {		
					case "MUSIC" : 
						list.add(new Music(title, author, length,
						genre, rating, ItemType.MUSIC));
						break;
					case "BOOK" : 
						list.add(new Book(title, author, length,
						genre, rating, ItemType.BOOK));
						break;
					default : 
						System.err.println("Wrong type!");
						break;
					}
				} catch (IllegalItemException e) {
					e.printStackTrace();
				}	
			}
		}
		return list;
	}
	
	/**
	 * Doesn't not support titles with whitespace.
	 * @return
	 */
	@Deprecated
	public ArrayList<Item> getItems() {
		if (scanner.findInLine(firstLine) != null) {
			scanner.nextLine();
		}
		list = new ArrayList<Item>();
		while (scanner.hasNextLine()) {
			if (scanner.findInLine(regularExp) != null) {
				MatchResult result = scanner.match();
				String type = result.group(1);
				String title = result.group(2);
				String author = result.group(3);
				String genre = result.group(4);
				double length = Double.parseDouble(result.group(5));
				int rating = Integer.parseInt(result.group(6));
				
				System.out.printf("Title: %s, Author: %s, Genre: %s",title, author ,genre);
				System.out.println("");
				try {
					switch (type) {		
					case "MUSIC" : 
						list.add(new Music(title, author, length,
						genre, rating, ItemType.MUSIC));
						break;
					case "BOOK" : 
						list.add(new Book(title, author, length,
						genre, rating, ItemType.BOOK));
						break;
					default : 
						System.err.println("Wrong type!");
						break;
					}
					
					} catch (IllegalItemException e) {
							e.printStackTrace();
					}	
			}
			if (scanner.hasNextLine())
				scanner.nextLine();
		}
		scanner.close();
		return list;
	}
}

		




