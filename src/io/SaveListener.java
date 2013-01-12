package io;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class SaveListener extends JFileChooser implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	JFileChooser fileSelection;

	
	public SaveListener() {
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		FileNameExtensionFilter filter = new FileNameExtensionFilter("LIB file", "lib");
		this.setFileFilter(filter);
		String path = null;
		int returnVal = fileSelection.showSaveDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			path = fileSelection.getName(getSelectedFile());
			new Save(path);
		}
		else System.out.println("Wrong filetype selected");
	}
}
