package edu.mccc.cos210.pco;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Result extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Keeps the value of the coins. 
	 */
	private int value;
	
	/**
	 * The image. What we need to find the coins in. Not sure if properly set up
	 */
	private BufferedImage bi;
	private Previewer previewer;
	
	/**
	 * Constructor. Gets the value from the calculator and uses it for the JFrame
	 */
	public Result(int d, BufferedImage bi, Previewer p) {
		this.bi = bi;
		this.value = d;
		this.previewer = p;
		showResult();
	}

	/**
	 * Inspector in charge of returning the value
	 * @return The value of the coins
	 */
	public int getValue() {
		return value;
	}
	
	/**
	 * In charge of setting the value of the calculator
	 * @param value
	 */
	public void setValue(int value) {
		this.value = value;
	}
	
	/**
	 * Shows the result on a JFrame.
	 */
	public void showResult() {
		String valueString= Integer.toString(value);
		if (valueString.length() == 1) {
			valueString = "0.0" + valueString;
		} else {
			if (valueString.length() == 2) {
				valueString = "0." + valueString;
			} else {
				valueString = valueString.substring(0, valueString.length() - 2) + "." + valueString.substring(valueString.length() - 2, valueString.length());
			}
		}
		JFrame jf = new JFrame("Result");
		JPanel jp = new JPanel();
		JLabel jl = new JLabel("the total value of the coins is $" + valueString);
		JButton returnHome = new JButton("Restart Program");
		JLabel imageLabel = new JLabel(new ImageIcon(bi));
		jl.setFont(new Font("Times New Roman",1,25));
		jp.setSize(1024, 768);
		jp.setLayout(new BorderLayout());
		jp.setBackground(Color.GRAY);
		jf.add(jl,BorderLayout.NORTH);
		jp.add(imageLabel,BorderLayout.CENTER);
		jf.add(returnHome,BorderLayout.SOUTH);
		jf.add(jp);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(1024, 768);
		jf.setResizable(true);
		jf.setLocationRelativeTo(null);
		jf.setVisible(true);
		returnHome.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jf.dispose();
				previewer.dispose();
				returnHome();				
			}
		});	
	}	
	
	/**
	 * Called when the restart button is pressed
	 */
	public void returnHome() {
		HomeFrame homePage = new HomeFrame();
		homePage.setVisible(true);
	}
}
