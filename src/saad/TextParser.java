package saad;

import items.Books;
import items.IllegalItemException;
import items.Item;
import items.Music;
import items.Item.ItemType;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

import library.Archive;

public class TextParser {
	
	private Scanner scanner;
	String types = "(BOOK|MUSIC)";
	String regularExp = types + "\\s*(\\w+)\\s*(\\w+)\\s*" +
			"(\\w+)\\s*([.\\d]+)\\s*(\\d+)";
	ArrayList<Item> list;
	
	public TextParser(Scanner scanner) {
		this.scanner = scanner;
	}
	
	public ArrayList<Item> getItems() {
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
				
				try {
					switch (type) {		
					case "MUSIC" : 
						list.add(new Music(title, author, length,
						genre, rating, ItemType.MUSIC));
						break;
					case "BOOK" : 
						list.add(new Books(title, author, length,
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

		




