package hw4;

import java.util.HashMap;
import java.util.Map;

/**
 * Score box for a given number N of matching dice, where N is specified in the
 * constructor. A Combination satisfies this category only if it has (at least)
 * N dice that are the same. For a Combination that satisfies this category, the
 * score is the sum of the N dice that have the same value. If there are
 * multiple groups of N with the same value, the group with highest value is
 * used for the score. For example, if N is 3 and the combination is (2, 2, 2,
 * 5, 5, 5, 5, 6), the score is 15.
 */
//TODO: this class must implement ScoreBox or extend another class that does
public class NOfAKindScoreBox extends applicationClass {
    private int N;

    
	/**
	 * Constructs a NOfAKindScoreBox with the given display name and score.
	 * 
	 * @param displayName name of this score box
	 * @param howMany     how many dice must match to satisfy this score box
	 */  
	public NOfAKindScoreBox(String displayName, int howMany) {
		super(displayName);
		N = howMany;
	}
    
	 /**
     * Checks if the provided dice values satisfy the conditions for N of a kind.
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
     * Calculates the potential score for N of a kind based on the provided dice values.
     * The score is the sum of the N dice that have the same value, and it considers
     * the highest-valued group of N dice if there are multiple groups with the same value.
     *
     * @param arr array representing the values of the dice
     * @return the potential score for N of a kind or zero if not satisfied
     */
	@Override
	public int getPotentialScore(int[] arr) {
		isSatRun = false;
	    // Use a HashMap to store the frequency of each dice value
	    Map<Integer, Integer> frequencyMap = new HashMap<>();
	    for (int num : arr) {
	        frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1); // Fix: increment the count
	    }

	    int maxScore = 0;

	    // Iterate through the frequency map to find the highest-scoring group of N dice
	    for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
	        int currentValue = entry.getKey();
	        int currentFrequency = entry.getValue();

	        if (currentFrequency >= N) {
	            // Calculate the score for the current group of N dice
	            int currentScore = N * currentValue;

	            // Update maxScore if the currentScore is higher
	            maxScore = Math.max(maxScore, currentScore);
	            isSatRun = true;
	        }
	    }
	    return maxScore;
	}
}
