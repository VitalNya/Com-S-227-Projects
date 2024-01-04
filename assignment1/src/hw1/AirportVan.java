package hw1;

/**
 * @ Vital Nyabashi
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
	
	public AirportVan(double givenHourlyRate, int givenMileageBonus, int givenTimeBonus, int givenMaxRiders) {
		hourRate = givenHourlyRate;
		givenMileageBonus = 0;
		timeBonus = givenTimeBonus;
		maxRiders= givenMaxRiders;
		//milage = givenMileageBonus; 
		
	}
	
	// Simulates driving the van for the given number of miles over the given number of minutes
	public void drive(int miles, int minutes) {
		totalMiles += miles;
		totalTime += minutes;
		//timeBonus += riders  ;
		riders = Math.min(1, riders);
		bonusPoints = timeBonus * riders * totalTime;
		//timeDriven  += minutes;
		
		
	}
	
	
	
	// collects the given tip and reduce the number of riders by 1. CAN NOT GO BELOW ZERO
	public void dropOff(double tip) {
		int thereAreRiders = Math.min(riders , 1);
		riders = Math.max(riders - 1, minRiders);
		totalTips += tip * thereAreRiders;
		
	}
	
	
	// Returns the average hourly pay for the driver(total pay / time) *includeds wages,tips and bonus points
	public double getAverageHourlyPay(double dollarsPerPoint) {
		return 0;
	}

	// returns the number of riders cerrently in this can
	public int getRiderCount() {
		return riders;
		
	}
	
	// returns the total miles driven since this can was constructed
	public int getTotalMiles() {
		return totalMiles;
		
		
	}
	
	//returns the toal pay eared. includes wages, tips, and bonus points usnig the given multiplier to convert bonus points to dollars
	public double getTotalPay(double dollarsPerPoint) {
		double wage = (getTotalPoints() * dollarsPerPoint) + totalTips + (hourRate * 60) ;
		return wage;	
		
	}
	
	// returns the total bonus points earned by the driver since this van was constructed
	public int getTotalPoints() {
		return bonusPoints;
			
	}
	
	
	// returns the total timr spent by the drivesince the van was constructed in minutes
	public int getTotalTime() {
		return totalTime;
		
		
	}
	
	
	//Returns the total tips earned by the driver since this van was constructed, indollars.
	public double getTotalTips() {
		return totalTips;
		
		
	}
	
	// increase the number of riders by 1. If the van is at max capacity, the method does nothing
	public void pickUp() {
		riders = Math.min(riders + 1, maxRiders);
		
	}
	
	// simulates the passage of time without the  van moving
	public void waitAround(int minutes) {
		drive(0, minutes);
		
	}
	
}
