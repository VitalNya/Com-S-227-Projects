package lab5;


public class firstVowel {
	public static void main(String[] srgs) {
		System.out.println(findFirstVowel("Big Ben"));
		System.out.println(findInitals("Big Ben"));
	}
		

	public static String VowelPos(String word) {
		int firstVowelPosition = findFirstVowel(word);
		String Initals = findInitals(word);

		if (firstVowelPosition != -1) {
			System.out.println("The first vowel is at position: " + firstVowelPosition);
		} else {
			System.out.println("No vowels found in the word.");
		}

		return Initals;
	}
	
	public static int findFirstVowel(String word) {
		for (int i = 0; i <= word.length(); i++ )
			if("aeiouAEIOU".indexOf(word.charAt(i)) >= 0) {
				return i;
			}
			return -1;
			}
	

	public static String findInitals (String word) {
	
		// make sure word is entered has a length is greater than 0
		if (word.length() > 0) {
            // Break up the full name into individual parts using space as a delimiter
            String[] split = word.split(" ");
            String initials = "";

            // Iterate through each part of the name and find the first letter of each part
            for (String part : split) {
                if (!part.isEmpty()) { // Check if the part is not empty
                    initials += Character.toUpperCase(part.charAt(0)); // Convert the initial to uppercase
                }
            }
        return initials;
		}
		return word;
	}
}



