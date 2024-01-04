package lab7;

public class Checkpoint2Test {
	public static void main(String[] args) {
		Checkpoint2 g = new Checkpoint2();
		int patterns = 5;
		System.out.println("The number of ways to lay out the walkway is: "  +g.countPatterns(patterns));
		System.out.print("Expected: 4");
		
		g.countPatterns(5);
		}

}
