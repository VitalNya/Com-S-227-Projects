package library;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * A Movie is a library item that can be checked out for 7 days and cannot be
 * renewed. If overdue, the fine is 3.00 plus .50 per day, up to a maximum equal
 * to the item's replacement cost.
 */

public class Movie extends superClass {

	/**
	 * Due date for this item. This value is null when not checked out.
	 */
	private Date dueDate;

	/**
	 * Patron to whom this item is checked out. This value is null when not checked
	 * out.
	 */
	private Patron checkedOutTo;

	/**
	 * Replacement cost for this DVD.
	 */
	private double replacementCost;

	/**
	 * Duration of this DVD, in minutes.
	 */
	private int duration;

	/**
	 * Constructs a Movie with the given title, replacement cost, and duration.
	 * 
	 * @param givenTitle    title for this item
	 * @param givenCost     replacement cost for this item, in dollars
	 * @param givenDuration duration of this item, in minutes
	 */
	public Movie(String givenTitle, double givenCost, int givenDuration) {
		super(givenTitle);
		dueDate = null;
		checkedOutTo = null;
		replacementCost = givenCost;
		duration = givenDuration;
	}

	/**
	 * Returns the duration of this Movie.
	 * 
	 * @return duration of this Movie
	 */
	public int getDuration() {
		return duration;
	}

	@Override
	public void checkOut(Patron p, Date now) {
		super.takeOut(p, now, 7);
	}	

	
	@Override
	public double getFine(Date now) {
		if (isCheckedOut() && isOverdue(now)) {
			int daysLate = super.Fine(now);
			
			// compute the fine
			double fine = 3 + daysLate * .50;
			return Math.min(fine, replacementCost);
		} else {
			return 0;
		}
	}

}