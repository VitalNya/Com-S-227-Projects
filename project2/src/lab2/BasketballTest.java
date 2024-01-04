package lab2;
/**
 * This is a basketball test
 * 
 */
public class BasketballTest {
	public static void main(String[] args) {
		Basketball b;
		b = new Basketball(4.0);
		System.out.println(b.getDiameter());
		/**
		 * 
		 */
		
		System.out.println(b.isDribbleable());

		// SECOND BASKETBALL
		Basketball b2 = new Basketball(6.0);
		b.inflate(); // CHANGES BALL b TO TRUE WHEN ASKED IF INFLATED
		
		System.out.println(b.isDribbleable());  // should be true now
		System.out.println(b2.isDribbleable()); // should still be false
		
		// THIRD BASKETBALL for Basketballs R Us management!
		Basketball b3 = new Basketball(6.0);
		b.deflate();
		
		System.out.print(b3.isDribbleable());

	}
}
