import java.util.ArrayList;

import javax.swing.JFrame;

import saad.Load;
import saad.TextParser;

import gui.Mainframe;
import items.Books;
import items.IllegalItemException;
import items.Item;
import items.Item.ItemType;
import library.Archive;
import library.AuthorList;
import library.Search;


public class Test {
	public static void main(String[] args) {
		Archive local = Archive.library;
		try {
			local.addItem(new Books("50 shades of grey", "Joe", 
					300, "Porno", 4, ItemType.MUSIC));
			local.addItem(new Books("Lorte Sang", "Bjarne", 
					2.42, "Classic", 1, ItemType.MUSIC));
			local.addItem(new Books("God bog", "Mr. Awesome", 
					632, "Fantasy", 5, ItemType.BOOK));
			local.addItem(new Books("Lorte bog", "Mr. Nitte", 
					30, "Political", 0, ItemType.BOOK));
		} catch (IllegalItemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		local.printLibrary();
		
		new Load("test.txt");

		JFrame frame = new Mainframe();
		frame.setVisible(true);
	
	}
	

}
