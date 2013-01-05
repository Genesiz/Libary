import javax.swing.JFrame;

import gui.Mainframe;
import items.Books;
import items.IllegalItemException;
import library.Archieve;


public class Test {

	

	public static void main(String[] args) {
		Archieve local = Archieve.library;
		try {
			local.addItem(new Books("title3", "author", 
					300, "genre", 4, "BOOK"));
			local.addItem(new Books("Lorte Sang", "Bjarne", 
					2.42, "Classic", 1, "MUSIC"));
			local.addItem(new Books("God bog", "Mr. Awesome", 
					632, "Fantasy", 5, "BOOK"));
			local.addItem(new Books("Lorte bog", "Mr. Nitte", 
					30, "Political", 0, "BOOK"));
		} catch (IllegalItemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		local.printLibrary();
		String[] test = local.getTitles().find("bog");
		for (String test00 : test) {
			System.out.println(test00);
		}
		
		
		
		JFrame frame = new Mainframe();
		frame.pack();

		//frame.setDefaultCloseOperation(0);
		//frame.setSize(500,500);

		frame.setVisible(true);
		
		
	}
	

}
