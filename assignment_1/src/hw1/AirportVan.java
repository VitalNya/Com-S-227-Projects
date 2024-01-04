
package hw1;



/**
 * @ Vital Nyabashi
 * 
 * The task for ssignment one is to creat a van simulation. 
 * The program will take in a given hourly rate, milage bonus
 * time bonus, and the number of riders the van can hold at once.
 * In the end we want to return the miles we drove, the tips given,
 * bonus points and finaly we add every thing up to determine how
 * much we have earned in the end 
 * 
 */

public class AirportVan {
	private int totalMiles;
	private int totalTime;
	private int maxRiders;
	private int minRiders= 0;
	private int riders = 0;
	private int timeBonus;
	private int bonusPoints;
	private int totalTips;
	private double hourRate; 
	private double milageBonus;
	
	
	
	public AirportVan(double givenHourlyRate, int givenMileageBonus, int givenTimeBonus, int givenMaxRiders) {
		hourRate = givenHourlyRate;
		milageBonus = givenMileageBonus ;
		timeBonus = givenTimeBonus;
		maxRiders= givenMaxRiders;
		
	}
	
	/**
	 *  Simulates driving the van for the given number of miles over the given number of minutes
	 * @param miles
	 * @param minutes
	 */
	public void drive(int miles, int minutes) {
		totalMiles += miles;
		totalTime += minutes;
		bonusPoints += timeBonus * Math.min(1, riders) * minutes;
		bonusPoints += miles * Math.max(1, riders) * milageBonus; 
	}
	
	
	
	// collects the given tip and reduce the number of riders by 1. CAN NOT GO BELOW ZERO
	public void dropOff(double tip) {
		int thereAreRiders = Math.min(riders , 1);
		riders = Math.max(riders - 1, minRiders);
		totalTips += tip * thereAreRiders;
		
	}
	
	
	/**
	 * 
	 * @param dollarsPerPoint
	 * @return
	 * Returns the average hourly pay for the driver(total pay / time) *includeds wages,tips and bonus points
	 * 
	 */
	public double getAverageHourlyPay(double dollarsPerPoint) {
		double wage = (getTotalPoints() * dollarsPerPoint) + totalTips + ((hourRate) * totalTime /60.0) ;
		return wage/ (totalTime /60.0) ; 
	}

	
	/**
	 * 
	 * @return
	 * returns the number of riders cerrently in this can
	 */
	public int getRiderCount() {
		return riders;
		
	}
	
	
	/**
	 * 
	 * @return
	 * returns the total miles driven since this can was constructed
	 */
	public int getTotalMiles() {
		return totalMiles;
		
		
	}
	
	/**
	 * @param dollarsPerPoint
	 * @return
	 * returns the toal pay eared. includes wages, tips, and bonus points usnig the given multiplier to convert bonus points to dollars
	 */
	public double getTotalPay(double dollarsPerPoint) {
		double wage = (getTotalPoints() * dollarsPerPoint) + totalTips + ((hourRate) * totalTime /60.0) ;
		return wage;	
		
	}
	
	/**
	 * @return
	 * returns the total bonus points earned by the driver since this van was constructed
	 */
	
	public int getTotalPoints() {
		return bonusPoints;
			
	}
	
	/**
	 * 
	 * @return
	 * returns the total timr spent by the drivesince the van was constructed in minutes
	 */
	public int getTotalTime() {
		return totalTime;
		
		
	}
	
	/**
	 * 
	 * @return
	 * Returns the total tips earned by the driver since this van was constructed, indollars.
	 */
	
	public double getTotalTips() {
		return totalTips;
		
		
	}
	
	
	
	/**
	 *  increase the number of riders by 1. If the van is at max capacity, the method does nothing
	 */
	public void pickUp() {
		riders = Math.min(riders + 1, maxRiders);
		
	}
	
	/**
	 * simulates the passage of time without the van moving
	 * @param minutes
	 */
	public void waitAround(int minutes) {
		drive(0, minutes);
		
	}
	
}
