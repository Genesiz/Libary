package io;

import items.Item;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import library.Archive;

public class Save {
	
	private FileWriter writer;
	
	/**
	 * Simple save
	 * @param filename
	 */
	public Save(String filename) {
		try {
			writer = new FileWriter(new File(filename));
			
			// first line for info in the file.
			writer.write("TYPE; TITLE; AUTHOR; GENRE; LENGTH; RATING;\n");
			
			for (Item item : Archive.library.getLibrary()) {
				writer.write(item.formatToFile() + "\n");
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
