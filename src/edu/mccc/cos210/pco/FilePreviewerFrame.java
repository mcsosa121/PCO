package edu.mccc.cos210.pco;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class FilePreviewerFrame extends JFrame {

	private static final long serialVersionUID = -7290464987798534347L;
	private JPanel contentPane;
	private JFrame self;
	private BufferedImage img;
	public FilePreviewerFrame(BufferedImage image) {
		self = this;
		this.img = image;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		contentPane.setSize(400, 400);
		setContentPane(contentPane);
		JPanel panel = new FilePreviewerPanel(image);
		contentPane.add(panel, BorderLayout.CENTER);
		
		JButton chooseImageBtn = new JButton("Choose Image");
		chooseImageBtn.setBounds(274, 201, 117, 29);
		contentPane.add(chooseImageBtn);
		chooseImageBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				self.dispose();
				@SuppressWarnings("unused")Finder finder = new Finder(img);
				
			}
		});		
		JButton browseAgainBtn = new JButton("Browse Again");
		browseAgainBtn.setBounds(107, 201, 117, 29);
		contentPane.add(browseAgainBtn);
		browseAgainBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				self.dispose();
				FileBrowser fb = new FileBrowser();
				fb.BrowseFile();
			}
		});
		
		JButton cancelBtn = new JButton("Cancel");
		cancelBtn.setBounds(191, 231, 117, 29);
		contentPane.add(cancelBtn);
		
		cancelBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				self.dispose();
				PrestoChangeO.openHomePage();
				
			}
		});
		
		panel.setSize(200, 200);
		panel.setLayout(null);
	}
}