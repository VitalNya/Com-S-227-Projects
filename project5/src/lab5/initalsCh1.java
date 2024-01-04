package lab5;

import java.util.Scanner;



public class initalsCh1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter full name:");
        String fullName = scanner.nextLine();
        String initials = getInitials(fullName);
        System.out.println("Initials: " + initials);
    }

    public static String getInitials(String fullName) {
        // Make sure the input name has a length greater than 0
        if (fullName.length() > 0) {
            // Break up the full name into individual parts using space as a delimiter
            String[] split = fullName.split(" ");
            String initials = "";

            // Iterate through each part of the name and find the first letter of each part
            for (String part : split) {
                if (!part.isEmpty()) { // Check if the part is not empty
                    initials += Character.toUpperCase(part.charAt(0)); // Convert the initial to uppercase
                }
            }

            return initials;
        } else {
            return "No initials found for an empty name";
        }
    }
}






