package io;

import gui.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class SaveListener extends JFileChooser implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	public SaveListener() {
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		FileNameExtensionFilter filter = new FileNameExtensionFilter("LIB file", "lib");
		this.setFileFilter(filter);
		String path = null;
		int returnVal = this.showSaveDialog(MainFrame.frame);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			path = this.getSelectedFile().getAbsolutePath();
			if (path.endsWith(".lib"))
				new Save(path);
			else
				new Save(path + ".lib");
			
		}
		else System.out.println("Wrong filetype selected");
	}
}
