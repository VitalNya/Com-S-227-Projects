package hw4;

/**
 * Score box that is satisfied by a Combination including at least three dice of
 * one value and three of a different value. The score is the sum of all die
 * values.
 * 
 * @author VITAL NYABASHI
 */
//TODO: this class must implement ScoreBox or extend another class that does
public class CastleScoreBox extends applicationClass {
	/**
	 * Constructs a CastleScoreBox with the given display name.
	 * 
	 * @param displayName name for this score box
	 */
	public CastleScoreBox(String displayName) {
		super(displayName);
	}

	 /**
     * Checks if a given array of dice values satisfies the conditions for a castle.
     * 
     * @param arr array of dice values
     * @return true if the dice values form a castle, false otherwise
     */
	@Override
	public boolean isSatisfiedBy(int[] arr) {
		getPotentialScore(arr);
		return isSatRun;
	}
	
	/**
     * Calculates the potential score based on the occurrence of a castle in the given array of dice values.
     * 
     * @param dice array of dice values
     * @return the potential score for this score box
     */
	public int getPotentialScore(int[] dice) {
		return frequencyMap(dice, 3, 1);
	}
}
