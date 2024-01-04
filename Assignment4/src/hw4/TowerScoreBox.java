package hw4;

/**
 * Score box that is satisfied by a Combination including at least four dice of
 * one value and two of a different value The score is the sum of all die
 * values.
 */
//TODO: this class must implement ScoreBox or extend another class that does
public class TowerScoreBox extends applicationClass {
	/**
	 * Constructs a TowerScoreBox with the given display name.
	 * 
	 * @param displayName name for this score box
	 */
	public TowerScoreBox(String displayName) {
		super(displayName);
	}
	
	
	@Override
	public boolean isSatisfiedBy(int[] arr) {
		getPotentialScore(arr);
		return isSatRun;
	}
	
	/*
	 * Details in the applicationClass class
	 */
	@Override
	public int getPotentialScore(int[] dice) {
		return frequencyMap(dice, 4, 2);
	}

}
