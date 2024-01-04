package hw4;

/**
 * Score box that is satisfied by a Combination including at least two dice of
 * one value and two of a different value. The score is the sum of all die
 * values.
 */
//TODO: this class must implement ScoreBox or extend another class that does
public class TwoPairsScoreBox extends applicationClass {
	/**
	 * Constructs a TwoPairsScoreBox with the given display name.
	 * 
	 * @param displayName name for this score box
	 */
	public TwoPairsScoreBox(String displayName) {
		super(displayName);
	}
	
	 /**
     * Checks if the provided dice values satisfy the conditions for two pairs.
     *
     * @param arr array representing the values of the dice
     * @return true if the dice values satisfy the conditions, false otherwise
     */
	@Override
	public boolean isSatisfiedBy(int[] arr) {
		getPotentialScore(arr);
		return isSatRun;
	}
	
	
	/**
     * Calculates the potential score for two pairs based on the provided dice values.
     * The score is the sum of all die values if the conditions are met; otherwise, it is zero.
     *
     * @param arr array representing the values of the dice
     * @return the potential score for two pairs or zero if not satisfied
     */
	@Override
	public int getPotentialScore(int[] arr) {
		return frequencyMap(arr, 2, 2);
	}
}
