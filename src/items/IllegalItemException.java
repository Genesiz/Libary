package items;

/**
 * @author Hjalte S. Jorgensen
 * @version 1.00
 */
public class IllegalItemException extends Exception {
	
	public IllegalItemException(String throwing) {
		System.err.println("Wrong input at: " + throwing);
	}

}
