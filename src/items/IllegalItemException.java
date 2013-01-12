package items;

public class IllegalItemException extends Exception {

	private static final long serialVersionUID = 4442205984467652379L;

	public IllegalItemException(String throwing) {
		System.err.println("Wrong input at: " + throwing);
	}
}
