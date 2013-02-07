import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import gui.MainFrame;
import gui.SimpleSplash;
import io.Load;

public class Executable {

	public static void main(String[] args) {
		try {
	            // Set cross-platform Java L&F (also called "Metal")
	        UIManager.setLookAndFeel(
	            UIManager.getCrossPlatformLookAndFeelClassName());
	    } 
	    catch (UnsupportedLookAndFeelException | ClassNotFoundException 
	    		| InstantiationException | IllegalAccessException e) {
	    	System.err.println("Could set look and feel!");
	    }
		SimpleSplash.instance.setVisible(true);
		MainFrame.instance.setVisible(true);
		SimpleSplash.instance.dispose();
		new Load("lib.lib", false);
	}	

}
