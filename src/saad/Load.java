package saad;

import items.Books;
import items.IllegalItemException;
import items.Music;
import items.Item.ItemType;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import library.Archive;

public class Load {
	
	private String filename;
	
	public  Load (String filename) {
		this.filename = filename;
	}

	public void LoadIt(){
		try {
			Scanner scanner = new Scanner(new File(filename));
		
		while (scanner.hasNextLine()) {
			
			String nextLine = scanner.nextLine();
			String[] words = nextLine.split(" ");
			
			String type = words[0];
			String title = words[1];
			String author = words[2];
			String genre = words[3];
			double length = Double.valueOf(words[4]);
			int rating = Integer.valueOf(words[5]);
			try {
				if (type == "MUSIC") 
					Archive.library.addItem(new Music(title, author, length,
							genre, rating, ItemType.MUSIC));
				else
					
						Archive.library.addItem(new Books(title, author, length,
								genre, rating, ItemType.BOOK));
				} catch (IllegalItemException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
				}
			
		
				
		}
		
		scanner.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		}
}
			
				





