package io;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import library.Archive;

public class SaveListener extends JFileChooser implements ActionListener {
	
	private static final long serialVersionUID = 1L;
		
	public SaveListener() {
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		FileNameExtensionFilter filter = new FileNameExtensionFilter("LIB file", "lib");
		this.setFileFilter(filter);
		String path = null;
		int returnVal = this.showSaveDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			path = this.getSelectedFile().getAbsolutePath();
			new Save(path);
			Archive.library.setSaved(true);
		}
		else System.out.println("Wrong filetype selected");
	}
}
