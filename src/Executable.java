import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
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
