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
	 * @param filename
	 */
	public  Load (String filename) {
		try {
			
			Scanner scan = new Scanner(new File(filename));
			TextParser textParser = new TextParser(scan);
			for (Item item : textParser.getItems()) {
				Archive.library.addItem(item);
			}
			ListPanel.updateList();
			
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}	
	}
}
			
				




