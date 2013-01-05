import library.TitleList;


public class Test2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TitleList list = new TitleList();
list.addTitle("lort er godt");
list.addTitle("dejligt er lort");
list.addTitle("ha");
String[] test = list.find("lort");
for (String tester : test) {
	System.out.println(tester);
}

	}

}
