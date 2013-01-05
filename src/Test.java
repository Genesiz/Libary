import items.Books;
import items.IllegalItemException;
import library.Archieve;


/**
 * @author Hjalte S. Jorgensen
 * @version 1.00
 */
public class Test {

	
	public static void main(String[] args) {
		Archieve local = Archieve.library;
		try {
			local.addItem(new Books("title", "author", 
					300, "genre", 4, "BOOK"));
			local.addItem(new Books("title2", "author", 
					300, "genre", 4, "BOOK"));
			local.addItem(new Books("title3", "author", 
					300, "genre", 4, "BOOK"));
		} catch (IllegalItemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		local.printLibrary();
		
		
		
	}
	

}
