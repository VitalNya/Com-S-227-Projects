package mini2;

import java.util.Arrays;

public class test {
	public static void main(String[] args) {
		int[] arr = {5, 3, 3, 0, 2};
	    System.out.println(OneThousandOneArraybianNights.findIt(arr));
	    System.out.println("Expected: 1");
	    String[] baa = {"apple", "banana", "apple", "pear"};
	    System.out.println(Arrays.toString(OneThousandOneArraybianNights.removeMultiples(baa)));
	    System.out.println("expect: Eel, Aardvark , Dog , Helicopter");
	    int[] x = {5, 4, 6, 4, 7, 4};
	    int[] y = {3, 0, -3, 1};
	    OneThousandOneArraybianNights.swizzle(x,y);
	    System.out.println(OneThousandOneArraybianNights.findSwizzlerThatSorts(x));
	    
	    int[] arr2 = {1, 2, 3, 4, 5, 6, 7};
	    int k = 3;
	    System.out.println(OneThousandOneArraybianNights.condense(arr2, k));
	    
	    int[] arr3 = {65, 42, 137, 12, 42, 42, 17, 8, 99};
	    int[] t = {137, 42, 12};
	    System.out.println(Arrays.toString(OneThousandOneArraybianNights.findSubsequence(arr3, t)));
	    System.out.println("expected [2, 4, 7]");
	    
	}
}
