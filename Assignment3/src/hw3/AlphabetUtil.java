package hw3;

/**
 * @ Vital Nyabashi
 * Com Sci 227
 */


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import api.Direction;
import api.ShiftDescriptor;
import api.TileInfo;

/**
 * Utility class containing some elements of the basic logic for performing
 * shifts in the game AlphabetSoup.
 */
public class AlphabetUtil {

	/**
	 * Constructor does nothing, since this object is stateless.
	 */
	public AlphabetUtil() {
		// do nothing
	}

	/**
	 * Returns the result of merging the two given tile values, or zero if they
	 * can't be merged. The rules are: two values can be merged if they are the
	 * same, and are not zero. The resulting value of a merge is always the current
	 * value plus 1.
	 * 
	 * @param a given tile value
	 * @param b given tile value
	 * @return result of merging the two values, or zero if no merge is possible
	 */
	public int findMergedValue(int a, int b)
	{
	  // Return the result of merging two tile values or zero if they can't be merged
	  if (a == b && a != 0) {
	    return a + 1;
	  }
	  return 0;
	}

	public int getScoreForOneTile(int value)
	{
	  // Return the score for a single tile value
	  if (value > 0) {
	    return (int) Math.pow(3, value - 1);
	  }
	  return 0;
	}

	public int randomNewTileValue(Random rand)
	{
	  // Generate and return a random new tile value (1 or 2 with equal probability)
	  return rand.nextInt(2) + 1;
	}

	public ArrayList<ShiftDescriptor> doShift(int[] arr)
	{
	  // Implement the shift logic on the given array
	  ArrayList<ShiftDescriptor> descriptors = new ArrayList<>();
	  boolean[] merged = new boolean[arr.length];

	  // Iterate from left to right to find mergeable pairs
	  for (int i = 0; i < arr.length - 1; i++) {
	    if (arr[i] != 0 && arr[i] == arr[i + 1] && !merged[i] && !merged[i + 1]) {
	    	int j = i+1;
	      // Merge the pair and mark as merged
	      arr[i] = findMergedValue(arr[i], arr[i + 1]);
	      arr[i + 1] = 0;
	      merged[i] = true;
	      descriptors.add(new ShiftDescriptor(i, j));
	    }
	  }

	  // Shift non-zero values to the left
	  int[] shiftedArr = new int[arr.length];
	  int index = 0;
	  for (int i = 0; i < arr.length; i++) {
	    if (arr[i] != 0) {
	    	int j = i+1;
	      shiftedArr[index] = arr[i];
	      if (index != i) {
	        descriptors.add(new ShiftDescriptor(i, j));
	      }
	      index++;
	    }
	  }

	  // Copy the shifted array back to the original array
	  System.arraycopy(shiftedArr, 0, arr, 0, shiftedArr.length);

	  return descriptors;
	}
}