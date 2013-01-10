
import gui.MainFrame;
import io.Load;
import items.Book;
import items.IllegalItemException;
import items.Item;
import items.Item.ItemType;
import library.Archive;

public class Executable {
	public static void main(String[] args) {
		Archive local = Archive.library;
		Item testing = null;
		try {
			testing = new Book("50 shades of grey", "Joe", 
					300, "Porno", 4, ItemType.BOOK);
		} catch (IllegalItemException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			local.addItem(new Book("Lorte Sang", "Bjarne", 
					2.42, "Classic", 1, ItemType.MUSIC));
			local.addItem(new Book("God bog", "Mr. Awesome", 
					632, "Fantasy", 5, ItemType.BOOK));
			local.addItem(new Book("Lorte bog", "Mr. Nitte", 
					30, "Political", 0, ItemType.BOOK));
			local.addItem(testing);

		} catch (IllegalItemException e) {
			e.printStackTrace();
		}

		MainFrame.frame.setVisible(true);
		new Load("test.txt");
	}
	

}
