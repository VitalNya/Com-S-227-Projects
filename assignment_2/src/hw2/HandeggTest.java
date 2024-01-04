package hw2;

public class HandeggTest {
	public static void main(String[] args) {
		Handegg game = new Handegg();
		System.out.println(game.getLocation());
		System.out.println("Expected 30");
		System.out.println(game.whoIsOffense());
		System.out.println("Expected 0");
		System.out.println(game.whichDown());
		System.out.println("Expected 1");
		System.out.println(game.getScore(0));
		System.out.println("Expected 0");
		game.punt(50);
		System.out.println(game.whoIsOffense());
		System.out.println("Expected 1");
		System.out.println(game.getLocation());
		System.out.println("Expected 20");
		game = new Handegg();
		game.run(25); // advance the ball 25 yards
		System.out.println(game.getLocation());
		System.out.println("Expected 55");
		game.fieldGoal(false);
		System.out.println(game.getScore(0));
		System.out.println("Expected 0");
		System.out.println(game.whoIsOffense());
		System.out.println("Expected 1");
		System.out.println(game.getLocation());
		System.out.println("Expected 45");
		game = new Handegg();
		game.run(100); // advance the ball 100 yards
		System.out.println(game.getLocation());
		System.out.println("Expected 130");
		System.out.println(game.getScore(0));
		System.out.println("Expected 6");
		
		game = new Handegg();
		System.out.println(game.whichDown());
		System.out.println("Expected 1");
		System.out.println(game.getYardsToFirstDown());
		System.out.println("Expected 10");
		game.run(-4);
		System.out.println(game.whichDown());
		System.out.println("Expected 2");
		System.out.println(game.getYardsToFirstDown());
		System.out.println("Expected 14");
		game.run(9);
		System.out.println(game.whichDown());
		System.out.println("Expected 3");
		System.out.println(game.getYardsToFirstDown());
		System.out.println("Expected 5");
		game.run(20);
		System.out.println(game.whichDown());
		System.out.println("Expected 1");
		System.out.println(game.getYardsToFirstDown());
		System.out.println("Expected 10");
			
		game = new Handegg();
		System.out.println(game.whichDown());
		System.out.println("Expected 1");
		System.out.println(game.getYardsToFirstDown());
		System.out.println("Expected 10");
		game.run(1);
		game.run(1);
		game.run(1);
		game.run(1);
		System.out.println(game.whoIsOffense());
		System.out.println("Expected 1");
		System.out.println(game.whichDown());
		System.out.println("Expected 1");
		System.out.println(game.getLocation());
		System.out.println("Expected 66");
		
		game = new Handegg();
		game.pass(4, false);
		System.out.println(game.whichDown());
		System.out.println("Expected 2");
		System.out.println(game.getYardsToFirstDown());
		System.out.println("Expected 6");
		game.pass(21, true);
		System.out.println(game.whoIsOffense());
		System.out.println("Expected 1");
		System.out.println(game.getLocation());
		System.out.println("Expected 45");
		
		
		game = new Handegg();
		game.run(4);
		game.run(4);
		game.run(4);
		game.run(4);
		game.run(4);
		game.run(4);
		game.run(4);
		game.run(4);
		game.run(4);
		game.run(4);
		game.run(4);
		game.run(4);
		game.run(4);
		game.run(4);
		game.run(4);
		game.run(4);
		game.run(4);
		game.run(4);
		game.extraPoint(true);
		game.run(4);
		game.run(4);
		game.run(4);
		game.run(4);
		game.run(4);
		game.run(4);
		game.run(4);
		game.run(4);
		game.run(4);
		game.run(4);
		game.run(4);
		game.run(4);
		game.run(4);
		game.run(4);
		game.run(4);
		game.run(4);
		game.run(4);
		game.run(4);
		game.extraPoint(true);
		
	}
}
