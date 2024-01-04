package lab2;

/**
 * A RabbitModel is used to simulate the growth of a population of rabbits.
 */
public class RabbitModel3 {
	// TODO - add population variables as needed
	private  int population;  
	private  int lastYear;  
	private  int yearBefore;

	/**
	 * Constructs a new RabbitModel.
	 */
	public RabbitModel3() {  //Starting number of rabbits
		// TODO
		population = 0;
		
		
	}

	/**
	 * Returns the current number of rabbits.
	 * 
	 * @return current rabbit population
	 */
	public int getPopulation() {
		// TODO - returns a dummy value so code will compile
		return population ;
		

	}

	/**
	 * Updates the population to simulate the passing of one year.
	 */
	public void simulateYear() {

		// TODO
		yearBefore =lastYear;
		lastYear=population;
		population = (population + 1 ) % 5;
		
		
		
		/**
		 * that simulates the passage of a year
		 */
	}

	/**
	 * Sets or resets the state of the model to the initial conditions.
	 */
	public void reset() {
		// TODO
		population = 0; // change the value back to the starting population value

		/**
		 * initializes any population variables to their values at the start of the
		 * simulation
		 */
		
/**
 * instq
 */
	}

}

