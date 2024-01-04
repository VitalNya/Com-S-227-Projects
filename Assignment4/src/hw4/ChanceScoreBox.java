package hw4;

/**
 * Score box that is satisfied by any Combination. The score is the sum of all
 * die values.
 * 
 * @author VITAL NYABASHI
 */
//TODO: this class must implement ScoreBox or extend another class that does
public class ChanceScoreBox extends applicationClass {
	/**
	 * Constructs a ChanceScoreBox with the given display name.
	 * 
	 * @param displayName name for this score box
	 */
	
	private int score; 

	public ChanceScoreBox(String displayName) {
		super(displayName);
	}
	
	
	@Override
	public int getPotentialScore(int[] arr) {
		score = 0;
		for (int die : arr) {
				score += die;
		}
		return score;
	}
	
	@Override
	public int getScore() {
		return getPotentialScore(com.getCompletedDice());
	}

}
