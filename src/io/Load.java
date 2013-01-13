package io;

import gui.ListPanel;
import items.Item;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import library.Archive;

public class Load {
		
	/**
	 * Loads a file uses text parse to make it to items.
	 * @param filename file name of file to load.
	 * @param dublications - true if you want duplications, false otherwise
	 */
	public  Load (String filename, boolean duplications) {
		try {
			Scanner scan = new Scanner(new File(filename));
			TextParser textParser = new TextParser(scan);
			for (Item item : textParser.getItemList()) {
				if (!duplications) {
					if (!Archive.instance.getLibrary().contains(item))
						Archive.instance.addItem(item);
				}
				else
					Archive.instance.addItem(item);
			}
			ListPanel.updateList();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}	
	}
}
			
				





