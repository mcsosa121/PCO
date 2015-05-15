package edu.mccc.cos210.pco;



public class HomePageControl {
	public void openWebCam() {
		
	}
	
	public void openFileBrowser() throws Exception {
		FileBrowser fb = new FileBrowser();
		fb.BrowseFile();
		FilePreviewerFrame fp = new FilePreviewerFrame(fb.OpenFile());
		fp.setVisible(true);
	}
}
