package lab6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LineNumberer2 {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("C:\\Users\\vital\\eclipse-workspace\\project5\\src\\lab5\\SimpleLoops.java");
		Scanner scanner = new Scanner(file);
		int lineCount = 1;

		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			System.out.print(lineCount + " ");
			System.out.println(line);
			lineCount += 1;
		}
		scanner.close();
	}
	
	public static void wordCounter(String txt) throws FileNotFoundException {
		File file = new File(txt);
		Scanner scanner = new Scanner(file);
		int lineNumber = 1;
		
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			// Make an array and slipt the words using spaces as delimiter in each line
			String[] words = line.split(" ");
			// Count the number of words in the line
			int wordCount = words.length;
			// What if the line has no words and just space??
			if(wordCount == 1) {
				wordCount = 0;
			}
			
			//print the word count for each line
			System.out.println("In line " +lineNumber+ ": " + wordCount + " words");
			lineNumber++;
		}
		// Close the scanner
		scanner.close();
		
	}
		
}




