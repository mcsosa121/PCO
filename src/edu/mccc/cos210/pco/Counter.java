package edu.mccc.cos210.pco;

public class Counter {
	
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
	 * Constructor. Makes sure the counts are 0 each time you create a Counter
	 */
	public Counter() {
		setCountOfQuarters(0);
		setCountOfDimes(0);
		setCountOfNickels(0);
		setCountOfPennies(0);
	}
	
	/**
	 * Inspector in charge of the count of the pennies
	 * @return the count of the pennies
	 */
	public int getCountOfPennies() {
		return countOfPennies;
	}
	
	/**
	 * Sets the count of the pennies
	 * @param countOfPennies. What the new count of Pennies is
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
	 * Sets the count of the nickels
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
	 * set the count of the quarters
	 * @param countOfQuarters
	 */
	public void setCountOfQuarters(int countOfQuarters) {
		this.countOfQuarters = countOfQuarters;
	}
}
