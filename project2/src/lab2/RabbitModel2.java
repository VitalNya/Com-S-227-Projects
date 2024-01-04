package lab2;

/**
 * A RabbitModel is used to simulate the growth of a population of rabbits.
 */
public class RabbitModel2 {
	// TODO - add instance variables as needed
	private  int instance;
	
	/**
	 * Constructs a new RabbitModel.
	 */
	public RabbitModel2() {
		// TODO
		instance = 2;
		
		
	}

	/**
	 * Returns the current number of rabbits.
	 * 
	 * @return current rabbit population
	 */
	public int getPopulation() {
		// TODO - returns a dummy value so code will compile
		return instance; // change the return to the starting population

	}

	/**
	 * Updates the population to simulate the passing of one year.
	 */
	public void simulateYear() {

		// TODO
		instance = instance + 1 ;
		/**
		 * that simulates the passage of a year
		 */
	}

	/**
	 * Sets or resets the state of the model to the initial conditions.
	 */
	public void reset() {
		// TODO
		instance = 2; // change the value to what the intical value

		/**
		 * initializes any instance variables to their values at the start of the
		 * simulation
		 */
		
	}

}
