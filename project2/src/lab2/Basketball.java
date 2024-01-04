package lab2;

/**
 * Model of a basketball for use in quality control simulations.
 */
public class Basketball {
	/**
	 * Inflation status of this Basketball.
	 */
	
	private boolean isInflated;

	/**
	 * Diameter of this Basketball.
	 */
	private double diameter;

	/**
	 * Constructs an uninflated Basketball with the given diameter.
	 * 
	 * 
	 */
	
	private boolean isDribbleable;
	/**
	 * Construts an uninflated basketball with the given diameter 
	 * 
	 * @param givenDiameter
	 */
	
	public Basketball(double givenDiameter) {
		isInflated = false;
		isDribbleable = false;
		diameter = givenDiameter;
		
	}

	/**
	 * Returns the diameter of this Basketball.
	 * 
	 * @return diameter of this Basketball
	 */
	public double getDiameter() {
		return diameter;
	}

	/**
	 * Determines whether this Basketball can be dribbled.
	 * 
	 * @return true if the basketball is inflated, false otherwise
	 */
	public boolean isDribbleable() {
		// can be dribbled only if it is inflated
		return isInflated;
	}

	/**
	 * Returns the circumference of this Basketball.
	 * 
	 * @return circumference of this Basketball
	 */
	public double getCircumference() {
		// PI times the diameter
		double result = Math.PI * diameter;
		return result;
	}

	/**
	 * Inflates this Basketball.
	 */
	public void inflate() {
		isInflated = true;
	}
	/**
	 * Deflates the Basketball.
	 */
	public void deflate() {
		isDribbleable = false;
		
	}

}
/**
 * 4.0
false
true
false
 * 
 */
