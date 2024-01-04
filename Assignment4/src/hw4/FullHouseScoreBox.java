package hw4;

/**
 * Score box that is satisfied by a Combination including at least three dice of
 * one value and two of a different value. The score is the sum of all die
 * values.
 * 
 * @author VITAL NYABASHI
 */
//TODO: this class must implement ScoreBox or extend another class that does
public class FullHouseScoreBox extends applicationClass {
	
	/**
	 * Constructs a FullHouseScoreBox with the given display name.
	 * 
	 * @param displayName name for this score box
	 */
	public FullHouseScoreBox(String displayName) {
		super(displayName);
	}

	/**
     * Checks if a given array of dice values satisfies the conditions for a full house.
     * 
     * @param arr array of dice values
     * @return true if the dice values form a full house, false otherwise
     */
	@Override
	public boolean isSatisfiedBy(int[] arr) {
		getPotentialScore(arr);
		return isSatRun;
	}
	
	
	 /**
     * Calculates the potential score based on the occurrence of a full house in the given array of dice values.
     * 
     * @param arr array of dice values
     * @return the potential score for this score box
     */
	@Override
	public int getPotentialScore(int[] arr) {
		return frequencyMap(arr, 3, 2);
	}

}
