package io;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import library.Archive;

public class SaveListener implements ActionListener {
	
	public SaveListener() {
			}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		saveState();
	}
	
	public static void saveState(){
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("LIB file", "lib");
		chooser.setFileFilter(filter);
		String path = null;
		int returnVal = chooser.showSaveDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			path = chooser.getSelectedFile().getAbsolutePath();
			new Save(path);
			Archive.instance.setSaved(true);
		}
	}
}
