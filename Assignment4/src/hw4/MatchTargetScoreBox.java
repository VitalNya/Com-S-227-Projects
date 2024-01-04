package hw4;

/**
 * Score box that is based on counting dice that match a particular target value
 * (as specified in the constructor). This category is satisfied by any
 * Combination. The score is the sum of the dice that match the target.
 * 
 * @author VITAL NYABASHI
 */
//TODO: this class must implement ScoreBox or extend another class that does
public class MatchTargetScoreBox extends applicationClass {

	private int targetValue;
	private int score; 

	/**
     * Constructs a MatchTargetScoreBox with the given display name and target
     * value.
     * 
     * @param displayName name for this score box
     * @param whichValue  target value that must be matched for the dice to count
     *                    toward the score
     */
	
	public MatchTargetScoreBox(String displayName, int whichValue) {
		super(displayName);
		targetValue = whichValue;
	}

	
	  /**
     * Calculates the potential score based on the occurrence of the target value
     * in the given array of dice values.
     * 
     * @param arr array of dice values
     * @return the potential score for this score box
     */
	@Override
	public int getPotentialScore(int[] arr) {
		for (int die : arr) {
			if (die == targetValue) {
				score += die;
			}
		}
		return score;
	}
	
	 /**
     * Gets the current score for this score box.
     * 
     * @return the current score for this score box
     */
	@Override
	public int getScore() {
		return score;
	}
}
