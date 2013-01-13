
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import gui.MainFrame;
import io.Load;

public class Executable {
	public static void main(String[] args) {
		  try {
	            // Set cross-platform Java L&F (also called "Metal")

			  UIManager.setLookAndFeel(
					  UIManager.getCrossPlatformLookAndFeelClassName());
	    } 
	    catch (UnsupportedLookAndFeelException e) {
	       // handle exception
	    }
	    catch (ClassNotFoundException e) {
	       // handle exception
	    }
	    catch (InstantiationException e) {
	       // handle exception
	    }
	    catch (IllegalAccessException e) {
	       // handle exception
	    }		

		MainFrame.frame.setVisible(true);
		new Load("lib.lib", false);
	}	
}

