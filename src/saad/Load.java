package saad;

import items.Books;
import items.Music;
import items.Items.ItemType;

import java.io.File;
import java.util.Scanner;

import library.Archive;

public class Load {
	
	private String filename;
	
	
	public  Load (String filename) {
		this.filename = filename;
	}

	public void LoadIt(){
		Scanner scanner = new Scanner(new File(filename));
		while (scanner.hasNextLine()) {
			
			String nextLine = scanner.nextLine();
			if (!nextLine.isEmpty()){
			
			
			String loadString = "";
			String[] words = nextLine.split(" ");
			String title;
			
			String type = scanner.next();  
			for (String word : words) 
				
			title = word[0];
		}
		}
			
				
//			{  
//				if (type == "MUSIC") 
//					Archive.library.addItem(new Music(MUSIC, ));
//				
//				else 
//					Archive.library.addItem(new Books(title, author, length,
//							genre, rating, ItemType.BOOK));
//				
//		CommandInterpreter.interpret(new Scanner(nextLine)).execute();
//		}
//		scanner.close();
	}
}


