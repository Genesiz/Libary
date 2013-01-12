package io;

import gui.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class LoadListener extends JFileChooser implements ActionListener  {

	public LoadListener(){
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		FileNameExtensionFilter filter = new FileNameExtensionFilter("LIB file", "lib");
		this.setFileFilter(filter);
		int returnVal = this.showOpenDialog(MainFrame.frame);
		if (returnVal == JFileChooser.APPROVE_OPTION)
			new Load(this.getSelectedFile().getAbsolutePath(), false);
	}
}
