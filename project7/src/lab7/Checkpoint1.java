package lab7;

public class Checkpoint1 {
	/**
	 * 
	 * @param array
	 * @param left
	 * @param right
	 * @return
	 */
	public static int findMax(int[] array, int left, int right) {
	    if (left == right) {
	        return array[left]; // Base case: Array has only one element
	    }

	    int mid = (left + right) / 2;

	    // Recursively find the maximum in the left and right halves of the array
	    int maxLeft = findMax(array, left, mid);
	    int maxRight = findMax(array, mid + 1, right);

	    // Return the larger of the two maximums
	    return Math.max(maxLeft, maxRight);
	}

	// A helper method to find the maximum in the entire array
	public static int findMax(int[] array) {
	    if (array == null || array.length == 0) {
	        throw new IllegalArgumentException("Array is empty or null");
	    }

	    return findMax(array, 0, array.length - 1);
	}
	
	
	/**
	 * Based on the given number of rows in a pyramid of stacked balls, 
	 * determine how many balls there is total 
	 * 
	 * @param levels
	 * @return
	 */
	public static int getPyramidCount(int levels) {
	    if (levels == 1) {
	        return 1; // Base case: There's one ball in a pyramid of height 1
	    } else {
	        int ballsInCurrentLevel = levels * levels;
	        int ballsInLowerPyramid = getPyramidCount(levels - 1);
	        return ballsInCurrentLevel + ballsInLowerPyramid;
	    }
	}
}
