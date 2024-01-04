package hw4;

/**
 * Score box for a large straight. A Combination with N dice satisfies this
 * category only if it consists of N distinct consecutive values. For a dice
 * group that satisfies this category, the score is a fixed value specified in
 * the constructor; otherwise, the score is zero.
 * 
 * @author VITAL NYABASHI
 */
//TODO: this class must implement ScoreBox or extend another class that does
public class LargeStraightScoreBox extends applicationClass {
	private int numPoints;
	private boolean isSatRun;
	
	/**
	 * Constructs a LargeStraightScoreBox with the given display name and score.
	 * 
	 * @param displayName name of this score box
	 * @param points      points awarded for a dice group that satisfies this score
	 *                    box
	 */
	public LargeStraightScoreBox(String displayName, int points) {
		super(displayName);
		numPoints = points;
	}
	/**
     * Checks if a given array of dice values satisfies the conditions for a large straight.
     * 
     * @param arr array of dice values
     * @return true if the dice values form a large straight, false otherwise
     */

	@Override
	public boolean isSatisfiedBy(int[] arr) {
		getPotentialScore(arr);
		return isSatRun;
	}
	
	/**
     * Calculates the potential score based on the occurrence of a large straight in the given array of dice values.
     * 
     * @param arr array of dice values
     * @return the potential score for this score box
     */
	@Override
	public int getPotentialScore(int[] arr) {
		isSatRun = false;
		boolean isLargeStraight = true;

		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] == arr[i + 1] - 1) {
				isLargeStraight = true;
				isSatRun = true;
			}
			else {
				isLargeStraight = false;
				isSatRun = false;
				break;
			}
		}
		return isLargeStraight ? numPoints : 0;
	}
}