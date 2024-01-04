
package hw2;

/**
 * This class encapsulates the logic and state for a highly simplified game of
 * American football.
 *
 * @author VITAL NYABASHI
 */
public class Handegg {
	/**
	 * Number of points awarded for a touchdown.
	 */
	public static final int TOUCHDOWN_POINTS = 6;
	/**
	 * Number of points awarded for a successful extra point attempt after a
	 * touchdown.
	 */
	public static final int EXTRA_POINTS = 1;
	/**
	 * Number of points awarded for a field goal.
	 */
	public static final int FIELD_GOAL_POINTS = 3;
	/**
	 * Total length of the field from goal line to goal line, in yards.
	 */
	public static final int FIELD_LENGTH = 100;
	/**
	 * Initial position of the offensive team after a touchdown and extra point
	 * attempt.
	 */
	public static final int STARTING_POSITION = 30;
	/**
	 * Yards required to get a first down.
	 */
	public static final int YARDS_FOR_FIRST_DOWN = 10;
	
	private int location;
	
	private int offense;
	
	private int down;
	
	private int teamA;
	
	private int teamB;
	
	private int yardsToFirstDown;
	
	private int firstDownMarker;
		
	/**
	 * When Handegg is called, location will be the starting position. offense will be teamA
	 * downs will equal 1. teamA and teamB will have zero points. 
	 */
	public Handegg() {
		location = STARTING_POSITION;
		offense = 0;
		resetDown();
		teamA = 0;
		teamB = 0;
	}
	
	/**
	 * This method will return the location of the ball
	 * @return
	 */
	public int getLocation() {
		return location;
	}
	
	
	/**
	 * getScore will take in the paramiter whichTeam. if it is equual to 0
	 * then that team will be called teamA, else the team will be called
	 * teamB.
	 * @param whichTeam
	 * @return
	 */
	public int getScore(int whichTeam){
		if (whichTeam == 0) {
			return teamA;
		}
		else {
			return teamB;
		}
	}
	
	/**
	 * This method will return the number of downs the offensive have
	 * @return
	 */
	public int whichDown(){
		return down;
	}
	
	/**
	 * This method will return who is the offense. or the team with the ball
	 * @return
	 */
	public int whoIsOffense(){
		return offense;
	}
	
	/**
	 *punt will take in yards as a paramiter wich is used to calculate the
	 *location. if the location is less than 0, which means the ball was
	 *at the endzones, the location will be set to 0. The offenes will be changed
	 *and resetDown will be called(resets the down 
	 * @param yards
	 */
	public void punt(int yards) {
		location = FIELD_LENGTH - yards - location;
		if (location < 0) {
			location = 0;
		}
		offense = 1 - offense;
		resetDown();
	}
	
	/**
	 * fieldGoal will take in success paramiter. The boolean will add
	 * the feild goal points to the appropriate team.
	 * @param success
	 */
	public void fieldGoal(boolean success) {
		if (offense == 0 && success == true) {
			teamA += FIELD_GOAL_POINTS;
			location = STARTING_POSITION;
		}
		
		else if (offense == 1 && success == true) {
			teamB += FIELD_GOAL_POINTS;
			location = STARTING_POSITION;
		}
		
		else {
			location = FIELD_LENGTH - location;
		}
		
		offense = 1 - offense;
		resetDown();		

	}
	
	/**
	 * In extraPoint, if attempt was successful, add extra points. 
	 * Whether it was successful, the defense gets the ball and starts 
	 * with a first down, starting postion yards from the goal line
	 * @param success
	 */
	public void extraPoint(boolean success) {
		if (offense == 0 && success == true) {
			teamA += 1;

		}
		
		else if (offense == 1 && success == true){
			teamB += 1;
		}


		offense = 1- offense;
		location = STARTING_POSITION;
		resetDown();		
	}
	
	/**
	 * Run takes the paramiter yards ran and updates the location. if the location 
	 * is greater than the feild length then the team offensive team will 
	 * get touchdown points.
	 * @param yards
	 */
	public void run(int yards) {
		location = location + yards;
		if (location > FIELD_LENGTH ) {
			if (offense == 0) {
				teamA += TOUCHDOWN_POINTS;
			}
			else if (offense == 1) {
				teamB += TOUCHDOWN_POINTS;
			}
		
		}
		else if (getYardsToFirstDown() <= 0) {
			resetDown();	

		}
		else if (down >= 4 ) {
			offense = 1 - offense;
			location = Math.abs(location - 100);
			resetDown();	
			
		}
		else {
			down += 1;
		}
		if (location < 0) {
			location = 0;
		}
	}
	
	/**
	 * getYardsToFirstDown returns the number of yards the offense must
	 * advance the ball to get a first ball
	 * @return
	 */
	public int getYardsToFirstDown() {
		yardsToFirstDown = firstDownMarker - location;
		
		return yardsToFirstDown;
	}
	

	/**
	 * This method will rest down to 1 and set the firstDownMarker
	 * to the location plusyards for first down.
	 */
	private void resetDown() {
		down = 1;
		firstDownMarker = location + YARDS_FOR_FIRST_DOWN;		

	}
	
	
	/**
	 * Pass will take in 2 paramiters, yards and intercepted. When the intercept
	 * boolean is true, the ball is given to the other team and the location is 
	 * where the ball was intercepted. The down will return to 1.
	 * @param yards
	 * @param intercepted
	 */
	public void pass(int yards, boolean intercepted) {
		if (intercepted == true) {
			offense = 1-offense;
			location = FIELD_LENGTH - yards - location;

			
			if (location > 100) {
				location = 100;
			}
			else if(location < 0){
				location = 0;
			}
			resetDown();
		}
		else {
			run(yards);
		}
	}
}
