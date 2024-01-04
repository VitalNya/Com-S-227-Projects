package hw4;

import java.util.Arrays;

/**
 * Score box for a short straight. A Combination with N dice satisfies this
 * category only if it includes N - 1 distinct consecutive values. For a dice
 * group that satisfies this category, the score is a fixed value specified in
 * the constructor; otherwise, the score is zero.
 */
//TODO: this class must implement ScoreBox or extend another class that does
public class ShortStraightScoreBox extends applicationClass {
	
	private int numPoints;
	private boolean isSatRun = false;
	
	/**
	 * Constructs a SmallStraightScoreBox with the given display name and score.
	 * 
	 * @param displayName name of this score box
	 * @param points      points awarded for a dice group that satisfies this score
	 *                    box
	 */
	public ShortStraightScoreBox(String displayName, int points) {
		super(displayName);
		numPoints = points;
	}

	
	 /**
     * Checks if the provided dice values satisfy the conditions for a short straight.
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
     * Calculates the potential score for a short straight based on the provided dice values.
     *
     * @param arr array representing the values of the dice
     * @return the potential score for a short straight, or zero if not satisfied
     */
	@Override
	public int getPotentialScore(int[] arr) {
		// Sort the array to simplify consecutive value checking
		Arrays.sort(arr);

		// Check if the array is a short straight
		boolean isShortStraight = true;
		isSatRun = false; 
		int count = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] != arr[i + 1] - 1) {
				isShortStraight = false;
				}
			
			else {
				count++;
			}
			if(count == (arr.length -2)) {
				isShortStraight = true;
				isSatRun = true;
				break;
			}
		}

		// If it's a short straight, return the fixed points; otherwise, return zero
		return isShortStraight ? numPoints : 0;
	}

}
