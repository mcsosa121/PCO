package edu.mccc.cos210.pco;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Previewer extends JFrame{ 
	
	private static final long serialVersionUID = 1L;
	BufferedImage bi;
	private List<Shape> circleList = new LinkedList<>();
	private JPanel mjp = new MyJPanel();
	public Previewer(BufferedImage bi) {
		super("Found Coins");
		this.bi = bi;
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.add(mjp);
		this.pack();
		this.setSize(1024, 768);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
    } 
	class MyJPanel extends JPanel {
		private static final long serialVersionUID = 1L;
		public MyJPanel() {
			setBackground(Color.RED);
			setLayout(null);
		}
		@Override
		protected void paintComponent(Graphics g) {
    		super.paintComponent(g);
    		final Graphics2D g2d = (Graphics2D) g.create();
        	g2d.drawImage(bi, 0, 0, null);
        	g2d.setColor(Color.BLUE);
        	g2d.setStroke(new BasicStroke(2.0f));
        	for (Shape s : circleList) {
        		g2d.draw(s);
        	}
		}
	}
    public void DrawCircle(int x, int y, double r){
    	Shape s = getCircle((double) x, (double) y, r);
		circleList.add(s);
		mjp.repaint();
    }
    public static Shape getCircle(final double x, final double y, final double r) {
        return new Ellipse2D.Double(x, y, r, r);
    }	
}




