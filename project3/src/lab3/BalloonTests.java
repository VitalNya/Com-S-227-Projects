package lab3;
import org.junit.Test;
import org.junit.Before;
import balloon4.Balloon;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class BalloonTests {
    private static final double EPSILON = 10e-07;
    
    private Balloon b;
    
    @Before
    public void setup() {  // runs before every test case
    	b = new Balloon(10);
    }
	@Test
	public void testInitialRadius() {
		String msg = "A newly constructed Balloon should have radius zero.";
		assertEquals(msg, b.getRadius(), 0, EPSILON);
	}
	
	@Test
	public void Poped() {
		String msg = "A newly constructed Balloon should not be popped";
		assertFalse(msg, b.isPopped() );
	}
	
	
	@Test
	public void isPoped() {
		String msg = "After calling pop on a Balloon, it should returned true when asked if it is poped, and radius is zero ";
		b.blow(5);
		b.pop();
		assertTrue(msg, b.isPopped());
		assertEquals(msg, b.getRadius(), 0, EPSILON);

	}
	
	@Test
	public void testDiameterAfterInflation() {
		String msg = "After calling blow(5) on a Balloon with maximum radius 10, the radius should be 5.";
		b.blow(6);
		assertEquals(msg, b.getRadius(), 6.0, EPSILON );
	}
	
	@Test
	public void testMax() {
		String msg = "After calling blow(11) on a Balloon woth maximum radius 10, the radius should pop";
		b.blow(11);
		assertTrue(msg, b.isPopped());
		assertEquals(msg, b.getRadius(), 0, EPSILON);
	}
	
	
	@Test
	public void testDeflate() {
		String msg = "After calling deflate on a balloon this should dchange the radius to 0";
		b.blow(4);
		b.deflate();
		assertEquals(msg, b.getRadius(), 0, EPSILON );
	}
	
	@Test
	public void testBlow(){
		String msg = "If we call blow(-1), the radius should not change and stay at 0";
		b.blow(-1);
		assertEquals(msg, b.getRadius(), 0, EPSILON );
	}
	
	@Test
	public void testAfterPop() {
		String msg = "if the Balloon is poped and is tried to blow again, the radius stays zero";
		b.pop();
		b.blow(3);
		assertEquals(msg, b.getRadius(), 0, EPSILON );
	}
	
	@Test
	public void tooMuchBlow(){
		String msg= "if you the max is 10 and you blow two, first being blow(5) and the second being blow(6), radius should be zero";		
		b.blow(5);
		assertEquals(msg, b.getRadius(), 5 , EPSILON );
		b.blow(6);
		assertEquals(msg, 0, b.getRadius() , EPSILON );

	}
	
	@Test
	public void testDeflatePop() {
		String msg = "if deflated, it does not mean poped";
		b.deflate();
		assertFalse(msg, b.isPopped());
	}
	
	
}