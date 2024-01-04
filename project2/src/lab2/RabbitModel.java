package lab2;

/**
 * A RabbitModel is used to simulate the growth of a population of rabbits.
 */
public class RabbitModel {
	// TODO - add population variables as needed
	private  int population;  
	private  int lastYear;  
	private  int yearBefore;
	

	/**
	 * Constructs a new RabbitModel.
	 */
	public RabbitModel() {  //Starting number of rabbits
		// TODO
		population = 0;
		yearBefore = 0;
		lastYear = 1;
		
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
		//yearBefore =lastYear;
		//lastYear= population;
		lastYear = population + 1;
		yearBefore = population;
		population = lastYear + yearBefore;
		
		
		
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
		yearBefore = 0;
		lastYear = 1;
		/**
		 * initializes any population variables to their values at the start of the
		 * simulation
		 */
		
/**
 * instq
 */
	}

}

