package edu.mccc.cos210.pco;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileBrowser extends JFileChooser {
	private static final long serialVersionUID = -1020555405089568377L;
	File selectedFile;
	private BufferedImage choosenImage;
	private JFileChooser  openDialog;
	public FileBrowser() {
		choosenImage = null;
		openDialog = new JFileChooser();
		
		openDialog.setFileFilter(new FileNameExtensionFilter("Image Files", "jpg", "jpeg", "bmp"));
		
	}
	
	public void BrowseFile() {
		int openChoice = openDialog.showOpenDialog(new JFrame());
		
		if (openChoice == JFileChooser.APPROVE_OPTION)
		{
		    selectedFile = openDialog.getSelectedFile();
		}

	}
	
	public BufferedImage OpenFile() throws Exception {
		choosenImage = ImageIO.read(selectedFile);
		return choosenImage;
	}
}