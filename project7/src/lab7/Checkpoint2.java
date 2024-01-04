package lab7;
import java.io.File;



public class Checkpoint2 {
    public static void main(String[] args) {
//    	Random file: "C:\\Users\\vital\\OneDrive\\Documents\\mydocument.txt"
        File rootDirectory = new File("C:\\Users\\vital\\OneDrive\\Attachments\\ignor");
        int totalFiles = countFiles(rootDirectory);
        System.out.println("Total number of files in the directory: " + totalFiles);
    }

    public static int countFiles(File f) {
        // Base case: If f is a file, return 1
        if (f.isFile()) {
            return 1;
        }

        // Initialize the count of files to 0
        int fileCount = 0;

        // Get the list of files and directories in the current directory
        File[] filesAndDirs = f.listFiles();

        // If the directory is empty or cannot be read, return 0
        if (filesAndDirs == null) {
            return 0;
        }

        // Iterate through the files and directories in the current directory
        for (File fileOrDir : filesAndDirs) {
            // Recursively count files in subdirectories
            fileCount += countFiles(fileOrDir);
        }

        return fileCount;
    }
    
    
    
    
    /*
     * part 2
     * A mason is using rectangular bricks to make a walkway. He has bricks that are 3 
     * feet long and bricks that are 1 foot long. If the walkway is a total of n feet long, 
     * how many different ways are there to lay out bricks for the walkway? For example, 
     * if n is 5, there are four possibilities:
     * 
     * 1 1 1 1 1 
     * 1 1   3
     * 1   3   1
     * 3     1 1
     */
	public static int countPatterns(int n) {
		if (n < 0) {
			return 0;
		} else if (n == 0) {
			return 1;
		}

		// Calculate the number of ways for a walkway of length n by recursively
		// considering adding a 1 foot brick or a 3 foot brick.
		int ways = 0;
		if (n >= 1) {
			ways += countPatterns(n - 1);
		}
		if (n >= 3) {
			ways += countPatterns(n - 3);
		}

		return ways;
	}
}