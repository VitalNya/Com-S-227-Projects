package hw1;

public class AirportVanTest {
	public static void main(String[] args) {
	AirportVan v = new AirportVan(0, 0, 0, 0);
	v.drive(20, 0);
	System.out.println(v.getTotalMiles());
	System.out.println("Expected 20");
	
	
	v = new AirportVan(0, 0, 0, 0);
	v.drive(20, 60);
	v.drive(10, 15);
	System.out.println(v.getTotalMiles());
	System.out.println("Expected 30");
	System.out.println(v.getTotalTime());
	System.out.println("Expected 75 ");
	
	// constructs a van with max of 3 riders
	v = new AirportVan(0, 0, 0, 3);
	v.pickUp();
	v.pickUp();
	System.out.println(v.getRiderCount());
	System.out.println("Expected 2");
	v.pickUp();
	System.out.println(v.getRiderCount());
	System.out.println("Expected 3");
	
	v.pickUp(); // does nothing, can't go over max riders
	System.out.println(v.getRiderCount());
	System.out.println("Expected 3");
	
	v.dropOff(0);
	System.out.println(v.getRiderCount());
	System.out.println("Expected 2");
	v.dropOff(0);
	System.out.println(v.getRiderCount());
	System.out.println("Expected 1");
	v.dropOff(0);
	System.out.println(v.getRiderCount());
	System.out.println("Expected 0");
	v.dropOff(0); // does nothing, can't go below 0
	System.out.println(v.getRiderCount());
	System.out.println("Expected 0 q");
	
	// bonus points for miles with one rider,
	// using 10 bonus points per mile
	v = new AirportVan(0, 10, 5, 3);    //SOMETHING WRONG IS HAPPENING HERE
	v.pickUp();
	v.drive(2, 0);
	System.out.println(v.getTotalPoints());
	System.out.println("Expected 20"); // 2 * 10
	v.drive(5, 0);
	System.out.println(v.getTotalPoints());
	System.out.println("Expected 70"); // above plus 5 * 10
	
	
	// bonus points for miles with three riders
	v = new AirportVan(0, 10, 5, 3);
	v.pickUp();
	v.pickUp();
	v.pickUp();
	v.drive(2, 0);
	System.out.println(v.getTotalPoints());
	System.out.println("Expected 60"); // 3 * 2 * 10
	v.drive(5, 0);
	System.out.println(v.getTotalPoints());
	System.out.println("Expected 210"); // above + 3 * 5 * 10
	// bonus points for miles with no riders
	v = new AirportVan(0, 10, 5, 3);
	v.drive(2, 0);
	System.out.println(v.getTotalPoints());
	System.out.println("Expected 20"); // same is for one rider
	v.drive(5, 0);
	System.out.println(v.getTotalPoints());
	System.out.println("Expected 70");
	
	// bonus points for miles with one rider,
	// using 10 bonus points per mile
	v = new AirportVan(0, 10, 5, 3);
	v.pickUp();
	v.drive(2, 0);
	System.out.println(v.getTotalPoints());
	System.out.println("Expected 20 "); // 2 * 10
	v.drive(5, 0);
	System.out.println(v.getTotalPoints());
	System.out.println("Expected 70"); // above plus 5 * 10
	// bonus points for miles with three riders
	v = new AirportVan(0, 10, 5, 3);
	v.pickUp();
	v.pickUp();
	v.pickUp();
	v.drive(2, 0);
	System.out.println(v.getTotalPoints());
	System.out.println("Expected 60"); // 3 * 2 * 10
	v.drive(5, 0);
	System.out.println(v.getTotalPoints());
	System.out.println("Expected 210"); // above + 3 * 5 * 10
	// bonus points for miles with no riders
	v = new AirportVan(0, 10, 5, 3);
	v.drive(2, 0);
	System.out.println(v.getTotalPoints());
	System.out.println("Expected 20"); // same is for one rider
	v.drive(5, 0);
	System.out.println(v.getTotalPoints());
	System.out.println("Expected 70");
	
	// tips
	v = new AirportVan(0, 10, 5, 3);
	v.pickUp();
	v.pickUp();
	v.dropOff(5);
	System.out.println(v.getTotalTips());
	System.out.println("Expected 5");
	v.dropOff(2);
	System.out.println(v.getTotalTips());
	System.out.println("Expected 7");
	
	// tricky bit - there isn't a rider, so dropOff should do nothing
	v.dropOff(10);
	System.out.println(v.getTotalTips());
	System.out.println("Expected 7");
	
	v = new AirportVan(0,10, 5,3);
	v.drive(8, 10);
	v.waitAround(5);
	v.pickUp();
	v.drive(25, 30);
	v.pickUp();
	v.pickUp();
	v.waitAround(15);
	v.drive(20, 60);
	v.dropOff(2);
	}
}

