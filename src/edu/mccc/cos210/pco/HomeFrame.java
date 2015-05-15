package edu.mccc.cos210.pco;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class HomeFrame extends JFrame {

	private static final long serialVersionUID = -1878965245154663369L;
	private JPanel contentPane;
	private JButton webCamBtn;
	private JButton browseFileBtn;
	private HomePageControl control;
	private JFrame self;
	public HomeFrame() {
		control = new HomePageControl();
		
		self = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("PrestoChangeO");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setLayout(null);
		webCamBtn = new JButton("Take a Pic");
		webCamBtn.setBounds(10, 10, 100, 100);
		webCamBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				self.dispose();
				control.openWebCam();
			}
		});
		contentPane.add(webCamBtn);
		
		browseFileBtn = new JButton("Open a File");
		browseFileBtn.setBounds(120, 10, 100, 100);
		browseFileBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					self.dispose();
					control.openFileBrowser();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			
		});
		contentPane.add(browseFileBtn);

		setContentPane(contentPane);
		
	}


}
