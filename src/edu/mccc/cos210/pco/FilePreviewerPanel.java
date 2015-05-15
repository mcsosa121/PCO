package edu.mccc.cos210.pco;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class FilePreviewerPanel extends JPanel {
	private static final long serialVersionUID = 5310625922099447002L;
	private Image img;

	  public FilePreviewerPanel(Image img) {
	    this.img = img;
	  }
	
	  public void paintComponent(Graphics g) {
		//by default assume that image is in landscape mode
	    int newHeight = this.getHeight();
	    int newWidth = (img.getWidth(null) * this.getHeight()) / img.getHeight(null);
	    
	    //trying resize an image that is portrait
	    if(newWidth > this.getWidth()) {
	    	newHeight = (img.getHeight(null) * this.getWidth()) / img.getWidth(null);
	    	newWidth  = this.getWidth();
	    }
	    
	    g.drawImage(img, 0, 0, newWidth, newHeight, null);
	  }
}

	
	
