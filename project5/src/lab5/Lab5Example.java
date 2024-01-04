package lab5;

public class Lab5Example {
	public static void main(String[] args) {
		System.out.println(longestRun("aabbbccd"));
		System.out.println("Expected 3");
		System.out.println(longestRun("aaa"));
		System.out.println("Expected 3");
		System.out.println(longestRun("aabbbb"));
		System.out.println("Expected 4");
	}

	public static int longestRun(String s) {
		int count = 1;
		int max = 1;

		// start with the first character, see how long a run there is
		char current = s.charAt(0);
		for (int i = 1; i < s.length(); i += 1) { // We want the loop to run as many times as it's length. remove the "-1" after s.length !!!
			char c = s.charAt(i);
			if (c == current) {
				// matches the 'current' character, add 1
				count += 1;
			} else {
				// that was the end of the run; if it was a longer run, make that the max
				if (count > max) {
					count = max;
				}

				// start counting a new run of a different character
				current = c;
				count = 1; //Rest count for the new run !!!!
			}
			if (count > max) { // Check if the last run was longest!!!! Shoukd be checked in both conditions
				max = count;
			}
		}

		// this should be the length of the longest run we found
		return max;
	}

}
