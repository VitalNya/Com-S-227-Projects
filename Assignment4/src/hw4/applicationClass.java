package hw4;

import java.util.HashMap;
import java.util.Map;

import api.ScoreBox;

public class applicationClass implements ScoreBox {
	
	private int targetValue;
	private int total;
	private boolean fillRun = false;
	protected boolean isSatRun = false;
	protected Combination com;
	private String name;

	
	/**
     * Constructs an applicationClass with the given display name and target value.
     * 
     * @param displayName name for this score box
     * @param whichValue  target value that must be matched for the dice to count
     *                    toward the score
     */
	public applicationClass(String displayName, int whichValue) {
		targetValue = whichValue;
		name = displayName;
		
	}
	
	 /**
     * Constructs an applicationClass with the given display name.
     * 
     * @param displayName name for this score box
     */
	public applicationClass(String displayName)	{
		name = displayName;
	}
	
	
	  /**
     * Checks if the score box has been filled.
     * 
     * @return true if the score box has been filled, false otherwise
     */
	public boolean isFilled() {
		if (fillRun) {
			return true;
		}
		return false;
	}

	/**
     * Gets the score for the score box based on the completed dice.
     * 
     * @return the score for the score box
     */
	public int getScore() {
		return getPotentialScore(com.getCompletedDice());
	}

	  /**
     * Gets the combination of dice associated with this score box.
     * 
     * @return the combination of dice
     */
	public Combination getDice() {
		return com;
	}

	/**
     * Gets the display name of this score box.
     * 
     * @return the display name of this score box
     */
	public String getDisplayName() {
		return name;
	}
	
	
	/**
	 * This method will be inherited by different classes. When called 
	 * they may have different arrs or num(s) for their coditions. 
	 * Overall it will use a map to store values then refer to the map to
	 * count the frequency of that specific number. 
	 * 
	 * @param arr
	 * @param num1
	 * @param num2
	 * @return
	 */
	public int frequencyMap(int[] arr, int num1, int num2) {
		total = 0;
		isSatRun = false;
				
		// Use a HashMap to store the frequency of each dice value
		Map<Integer, Integer> frequencyMap = new HashMap<>();
		for (int num : arr) {
			frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
		}

		boolean firstCodition = false;
		boolean secondCondition = false;
		

		// Iterate through the frequency map
		for (int frequency : frequencyMap.values()) {
			if (frequency >= num1 && firstCodition != true) {
				firstCodition = true;
			} else if (frequency == num2 && secondCondition != true) {
				secondCondition = true;
			}
		}

		// If the coditions are both met, then total up all the numbers in the arr
		if (firstCodition && secondCondition) {
			for (int numb : arr) {
				total += numb;
				isSatRun = true;
			}
		}
		
		// return the totaled 
		return total;
		
	}

	  /**
     * Fills the score box with the provided combination of dice.
     * 
     * @param dice the combination of dice to fill the score box
     */
	public void fill(Combination dice) {
		com = dice;
		fillRun = true;
		
	}

	  /**
     * Checks if the score box conditions are satisfied based on the given array of dice values.
     * 
     * @param arr array of dice values
     * @return true if the conditions are satisfied, false otherwise
     */
	public boolean isSatisfiedBy(int[] arr) {
		return isSatRun = true;
	}
	
	/**
     * Calculates the potential score based on the occurrence of a specific target value
     * in the given array of dice values.
     * 
     * @param arr array of dice values
     * @return the potential score for this score box
     */
	public int getPotentialScore(int[] arr) { 
		total = 0;
		if (isSatisfiedBy(arr) != true) {
			return 0;
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == targetValue) {
				total += targetValue;
			}
		}
		return total ;
	}
		

}
