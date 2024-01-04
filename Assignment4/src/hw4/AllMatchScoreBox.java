package hw4;

/**
 * Score box for all dice the same. A Combination with N dice satisfies this
 * category only if all N values are the same. For a Combination that satisfies
 * this category, the score is a fixed value specified in the constructor;
 * otherwise, the score is zero.
 * 
 * @author VITAL NYABASHI
 */
// TODO: this class must implement ScoreBox or extend another class that does
public class AllMatchScoreBox extends applicationClass {
		private int numPoints;
	private boolean isSatRun;
	/**
	 * Constructs a AllMatchScoreBox with the given display name and score.
	 * 
	 * @param displayName name of this score box
	 * @param points      points awarded for a combination that satisfies this score
	 *                    box
	 */
	public AllMatchScoreBox(String displayName, int points) {
		super(displayName);
		numPoints = points;
	}

	/**
	 * Checks if the conditions for this score box are satisfied based on the given
	 * array of dice values.
	 * 
	 * @param arr array of dice values
	 * @return true if the conditions are satisfied, false otherwise
	 */
	@Override
	public boolean isSatisfiedBy(int[] arr) {
		getPotentialScore(arr);
		return isSatRun;
	}
	
	/**
	 * Calculates the potential score based on the condition that all dice have the
	 * same value in the given array of dice values.
	 * 
	 * @param arr array of dice values
	 * @return the potential score for this score box
	 */	
	@Override
	public int getPotentialScore(int[] arr) {
		//check if all dice have the same value
		
		boolean allMatch = true;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] != arr[0]) {
				isSatRun = false;
				break;
			}
			else if ((arr[i] == arr[0])) {
				isSatRun = true;
			}
		}
		// if all the dice have the same calue, return numPoints. Otherwise return 0
		return allMatch ? numPoints : 0;
	}

}
