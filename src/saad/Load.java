package saad;

import items.Books;
import items.IllegalItemException;
import items.Item;
import items.Music;
import items.Item.ItemType;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import library.Archive;

public class Load {
		
	public  Load (String filename) {
		try {
			
			Scanner scan = new Scanner(new File(filename));
			TextParser textParser = new TextParser(scan);
			for (Item item : textParser.getItems()) {
				Archive.library.addItem(item);
			}
			
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}	
	}
}
			
				





