package mini1;


public class Test {

	public static void main(String[] args) {
		System.out.println(AcrossTheLooperverse.countMatches("awedda", "vital"));
		System.out.println("Expected: 1");
		System.out.println(AcrossTheLooperverse.countSteps(10, 200));
		System.out.println("expect 0");
		System.out.println(AcrossTheLooperverse.starMaker("(())((("));
		System.out.println(AcrossTheLooperverse.makeSmallestPalindrome("abb"));
		System.out.println(AcrossTheLooperverse.findNextToLargest("-42 -137 -7 -42 -66 -55"));
		AcrossTheLooperverse.makePattern(3);
		System.out.println(AcrossTheLooperverse.wordGameChecker("guess", "geese"));
	}

}
