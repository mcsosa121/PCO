package edu.mccc.cos210.pco;

import java.awt.image.BufferedImage;
import java.util.HashMap;

@SuppressWarnings("unused")
public class Finder {
	
	/**
	 * The image. What we need to find the coins in. Not sure if properly set up
	 */
	private BufferedImage bi;
	
	/**
	 * used to store the size of the key circle
	 */
	private int diameterOfKeyCircle;
	
	/**
	 * a counter to keep track of the value of the coins
	 */
	private Counter counter;
	
	private Calculator calc;
	
	private Previewer previewer;
	
	private Result result;
	
	/**
	 * Keeps the value of the coins. 
	 */
	private int value;
	private int w;
    private int h;
    private HashMap<String, Integer> foundCoins = new HashMap<String, Integer>();
	/**
	 * Constructor. Uses the image and starts finding everything in it
	 * 
	 * @param bi. The image that the coins in need to be counted
	 */
	public Finder(BufferedImage bi) {
		this.counter = new Counter();
		this.previewer = new Previewer(bi);
		this.bi = bi;
		w = bi.getWidth();
		h = bi.getHeight();
		diameterOfKeyCircle = findKeyCircle();
		findCoin(); //do not use this method. It isn't finished.
		calc = new Calculator(counter);
		value = calc.calculate();
		result = new Result(value, bi, previewer);
		
	}
	
	/**
	 * Gets size of the identifier. That is later used to then be able to find and identify the coins
	 * 
	 * @return the size of the key circle used to calculate the size of the other coins
	 */
	public int findKeyCircle(){
		boolean upperYFound = false;
		boolean lowerYFound = false;
		boolean leftXFound = false;
	    int y = 0;
	    int x = 0;
	    int upperY = 0;
	    int leftX = 0;
	    int lowestY = 0;
	    int middleY = 0;
	    int middleX = 0;
	    int diameter = 0;
	    for (y = 0; y < h; y++) {
	    	for (x = 0; x < w; x++) {
	    		int ColorValue = bi.getRGB(x, y);
	    		int red = (ColorValue >> 16) & 0xff;
	    		int green = (ColorValue >> 8) & 0xff;
	    		int blue = (ColorValue) & 0xff;
	    		if (green >= 80 && red <= 75 && blue <= 75) {
	    		  upperY = y;
	    		  middleX = x;
	    		  upperYFound = true;
	    		  y = h;
	    		  x = w;
	    	  }
	    	}
	    }
	    if (upperYFound == false) {
	    	System.out.println("ERROR: No green coin was found");
	    } else {
	    	 y = upperY;
	 	    while (!lowerYFound) {
	 	    	y++;
	 	    	int ColorValue = bi.getRGB(middleX, y);
	 	    	int red = (ColorValue >> 16) & 0xff;
	 	    	int green = (ColorValue >> 8) & 0xff;
	 	    	int blue = (ColorValue) & 0xff;
	 	    	if (green < 75) {
	 	    		 lowestY = y;
	 	    		 diameter = (lowestY - upperY); 
	 	    		 lowerYFound = true;
	 	    		 middleY = (lowestY + upperY) / 2;
	 	    		 x = middleX;
	 	    	 }
	 	    }
	 	    while(!leftXFound) {
	 	    	x--;
	 	    	int ColorValue = bi.getRGB(x, middleY);
	 	    	int red = (ColorValue >> 16) & 0xff;
	 	    	int green = (ColorValue >> 8) & 0xff;
	 	    	int blue = (ColorValue) & 0xff;
	 	    	if (green < 75) {
	 	    		 leftX = x;
	 	    		 leftXFound = true;
	 	    	 }
	 	    }
	    }
	    previewer.DrawCircle(leftX, upperY, diameter);
	  //  System.out.println("x, y: " + leftX + ", " + upperY);
	   // System.out.println("the diameter of the green coin is " + diameter);
		return diameter;
	}
	
	/**
	 * Algorithm to locate the actual currency. Updates Counter's count of the currency if it finds one
	 */
	public void findCoin() {
		boolean upperYFound = false;
		boolean lowerYFound = false;
		boolean leftXFound = false;
		boolean rightXFound = false;
		boolean entireImageChecked = false;
		boolean skippedCoin = false;
	    int y = -1;
	    int x = 0;
	    int upperY = 0;
	    int lowestY = 0;
	    int leftX = 0;
	    int rightX = 0;
	    int middleY = 0;
	    int middleX = 0;
	    double diameter = 0;
	    double quarterDiameter = diameterOfKeyCircle * 0.71;
	    double dimeDiameter = diameterOfKeyCircle * 0.51;
	    double nickelDiameter = diameterOfKeyCircle * 0.62;
	    double pennyDiameter = diameterOfKeyCircle * 0.56;
	    while (!entireImageChecked) {
	    	while (!upperYFound) {
		    	y++;
		    	for (x = middleX; x < w; x++) {
		    		if (y < h && x <= w) {
		    			int ColorValue = bi.getRGB(x, y);
		    			int red = (ColorValue >> 16) & 0xff;
		    			int green = (ColorValue >> 8) & 0xff;
		    			int blue = (ColorValue) & 0xff;
		    			if (red > 100) {
		    				if (foundCoins.containsKey(coinString(x, y))) {
		    					x = foundCoins.get(coinString(x, y));
		    				} else {
		    					upperY = y;
		    					middleX = x;
		    					upperYFound = true;
		    					x = w;
		    				} 
		    			}
		    	  } else {
		    		  upperYFound = true;
		    		  lowerYFound = true;
		    		  leftXFound = true;
		    		  entireImageChecked = true;
		    	  }
		    	}
		    }
		    while (!lowerYFound) {
		    	y++;
		    	if  (y < h) {
		    		int ColorValue = bi.getRGB(middleX, y);
			    	int red = (ColorValue >> 16) & 0xff;
			    	int green = (ColorValue >> 8) & 0xff;
			    	int blue = (ColorValue) & 0xff;
			    	if (red < 80) {
			    		 lowestY = y;
			    		 diameter = (lowestY - upperY); 
			    		 lowerYFound = true;
			    		 middleY = (lowestY + upperY) / 2;
			    		 x = middleX;
			    	 }
		    	} else {
		    		lowerYFound = true;
		    	}
		    	
		    }
		    while(!leftXFound) {
		    	x--;
		    	if (middleY < h) {
		    		int ColorValue = bi.getRGB(x, middleY);
			    	int red = (ColorValue >> 16) & 0xff;
			    	int green = (ColorValue >> 8) & 0xff;
			    	int blue = (ColorValue) & 0xff;
			    	if (red < 80) {
			    		 leftX = x;
			    		 leftXFound = true;
			    	 }
		    	} else {
		    		leftXFound = true;
		    		diameter = 0;
		    	}
		    	
		    }
		    if (diameter == quarterDiameter || (diameter <= (quarterDiameter + (quarterDiameter * 0.05)) && diameter >= (quarterDiameter - (quarterDiameter * 0.05)))) {
		    	counter.setCountOfQuarters(counter.getCountOfQuarters() + 1);
		    	addCoinToMap(leftX, upperY, lowestY, leftX + (int) diameter);
		    	previewer.DrawCircle(leftX, upperY, diameter);
		    	System.out.println("x, y: " + leftX + ", " + upperY);
				System.out.println("the diameter of a quarter is " + diameter);
		    }
			if (diameter == dimeDiameter || (diameter <= (dimeDiameter + (dimeDiameter * 0.05)) &&
					diameter >= (dimeDiameter - (dimeDiameter * 0.05)))) //&& diameter <= (pennyDiameter + (pennyDiameter * 0.05)))
			{
				/*int ColorValue = bi.getRGB(middleX, middleY);
				int red = (ColorValue >> 16) & 0xff;
		    	int green = (ColorValue >> 8) & 0xff;
		    	int blue = (ColorValue) & 0xff;
		    	if (red < 130) {*/
		    		counter.setCountOfDimes(counter.getCountOfDimes() + 1);
		    		//System.out.println("x, y: " + leftX + ", " + upperY);
				   // System.out.println("the diameter of a dime is " + diameter);
		    	/*} else {
		    		counter.setCountOfPennies(counter.getCountOfPennies() + 1);
		    		System.out.println("x, y: " + leftX + ", " + upperY);
				    System.out.println("the diameter of a penny is " + diameter);
		    	}*/
				previewer.DrawCircle(leftX, upperY, diameter);
			   	addCoinToMap(leftX, upperY, lowestY, leftX + (int) diameter);
			}
			if (diameter == nickelDiameter || (diameter <= (nickelDiameter + (nickelDiameter * 0.05)) && diameter >= (nickelDiameter - (nickelDiameter * 0.05)))) {
		    	counter.setCountOfNickels(counter.getCountOfNickels() + 1);
		    	addCoinToMap(leftX, upperY, lowestY, leftX + (int) diameter);
		    	previewer.DrawCircle(leftX, upperY, diameter);
		    	// System.out.println("x, y: " + leftX + ", " + upperY);
				   // System.out.println("the diameter of a nickel is " + diameter);
		    }
			if (diameter == pennyDiameter || (diameter <= (pennyDiameter + (pennyDiameter * 0.05)) && diameter >= (pennyDiameter - (pennyDiameter * 0.05)))) {
		    	counter.setCountOfPennies(counter.getCountOfPennies() + 1);
		    	addCoinToMap(leftX, upperY, lowestY, leftX + (int) diameter);
		    	previewer.DrawCircle(leftX, upperY, diameter);
		    	// System.out.println("x, y: " + leftX + ", " + upperY);
				// System.out.println("the diameter of a penny is " + diameter);
		    }
		    lowerYFound = false;
			upperYFound = false;
			leftXFound = false;
			rightXFound = false;
		    y = upperY;
		    x = rightX;
		    upperY = 0;
		    leftX = 0;
		    rightX = 0;
		    lowestY = 0;
		    middleY = 0;
		    middleX = 0;
		    diameter = 0;
	    }
	}
	private String coinString(int X, int Y) {
		String s = Integer.toString(X) + ", " + Integer.toString(Y);
		return s;
	}
	private void addCoinToMap(int d, int j, int k, int l) {
		for (int x = d; x <= l; x++) {
			for (int y = j; y <= k; y++) {
				String s = coinString(x, y);
				foundCoins.put(s, l);
			}
			
		}
	}
}
