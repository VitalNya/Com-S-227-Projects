package lab2;

import java.util.Random;
/**
 * A RabbitModel is used to simulate the growth of a population of rabbits.
 */
public class RabbitModel5 {
	// TODO - add population variables as needed
	private  int population;  
	//private  int lastYear;  
	//private  int yearBefore;
	

	/**
	 * Constructs a new RabbitModel.
	 */
	public RabbitModel5() {  //Starting number of rabbits
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
		//yearBefore =lastYear;
		//lastYear= population;
		Random r = new Random();
		int rand = r.nextInt(10);
		population = population + rand ;
		
		
		
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

