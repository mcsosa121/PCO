package edu.mccc.cos210.pco;


public class Calculator {
	
	/**
	 * Keeps the count of the Pennies.
	 */
	private int countOfPennies;
	
	/**
	 * Keeps the count of the Nickels.
	 */
	private int countOfNickels;
	
	/**
	 * Keeps the count of the Dimes.
	 */
	private int countOfDimes;
	
	/**
	 * Keeps the count of the Quarters.
	 */
	private int countOfQuarters;
	
	/**
	 * Keeps the value of the coins. 
	 */
	private int value;
	
	/**
	 * a counter to keep track of the value of the coins
	 */
	@SuppressWarnings("unused")private Counter counter;
	
	/**
	 * Constructor. Creates the Calculator and gets the values
	 */
	public Calculator(Counter counter) {
		this.counter = counter;
		setCountOfPennies(counter.getCountOfPennies());
		setCountOfNickels(counter.getCountOfNickels());
		setCountOfDimes(counter.getCountOfDimes());
		setCountOfQuarters(counter.getCountOfQuarters());
		setValue(0);
	}
	
	/**
	 * The method you call to calculate the value of the coins.
	 */
	public int calculate() {
		value = (1 * countOfPennies) + (5 * countOfNickels) + (10 * countOfDimes) + (25 * countOfQuarters);
		return value;
	}
	
	/**
	 * Inspector in charge of the count of the pennies
	 * @return the count of the pennies
	 */
	public int getCountOfPennies() {
		return countOfPennies;
	}
	
	/**
	 * sets the count of the pennies
	 * @param countOfPennies
	 */
	public void setCountOfPennies(int countOfPennies) {
		this.countOfPennies = countOfPennies;
	}
	
	/**
	 * Inspector in charge of the count of the nickels
	 * @return the count of the nickels
	 */
	public int getCountOfNickels() {
		return countOfNickels;
	}
	
	/**
	 * sets the count of the nickels
	 * @param countOfNickels
	 */
	public void setCountOfNickels(int countOfNickels) {
		this.countOfNickels = countOfNickels;
	}
	
	/**
	 * Inspector in charge of the count of the dimes
	 * @return the count of the dimes
	 */
	public int getCountOfDimes() {
		return countOfDimes;
	}
	
	/**
	 * sets the count of the dimes
	 * @param countOfDimes
	 */
	public void setCountOfDimes(int countOfDimes) {
		this.countOfDimes = countOfDimes;
	}
	
	/**
	 * Inspector in charge of the count of the quarters
	 * @return the count of the quarters
	 */
	public int getCountOfQuarters() {
		return countOfQuarters;
	}
	
	/**
	 * Sets the count of the quarters
	 * @param countOfQuarters
	 */
	public void setCountOfQuarters(int countOfQuarters) {
		this.countOfQuarters = countOfQuarters;
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
	
}
