package lab7;

public class Checkpoint1Test {
	public static void main(String[] args) {
		Checkpoint1 m = new Checkpoint1();
		int[] array = { 3, 7, 1, 9, 99, 2, 6, 12 };
		System.out.println("The maximum value in the array is: " + m.findMax(array));
		System.out.println("Expected: 12");
		
	    int levels = 7;
		System.out.println("The number of balls in a pyramid with " +levels+ "levels is " + m.getPyramidCount(levels));
		System.out.print("expected: 140");
			//10= 385
			//9= 285
			//8= 204
			//7= 140
			//6= 91
			//5= 55
	}

}
