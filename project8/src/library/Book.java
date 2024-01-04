package library;

import java.util.Date;

/**
 * A Book is a library item that can be checked out for 21 days and renewed at
 * most twice. If overdue, the fine is .25 per day.
 */
public class Book extends superClass {
	
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
	 * Number of times the item has been renewed for the current patron.
	 */
	private int renewalCount = 0;
	


	/**
	 * Constructs a book with the given title.
	 * 
	 * @param givenTitle
	 */
	public Book(String givenTitle) {
		super(givenTitle);
		dueDate = null;
		checkedOutTo = null;
		renewalCount = 0;
	}

	@Override
	public void checkOut(Patron p, Date now) {
		super.takeOut(p, now, 21);
	}


	@Override
	public void renew(Date now) {
		if (isCheckedOut() && !isOverdue(now) && renewalCount < 2) {
			checkOut(checkedOutTo, dueDate);
			renewalCount += 1;
		}
	}

	@Override
	public double getFine(Date now) {
		if (isCheckedOut() && isOverdue(now)) {
			int daysLate = super.Fine(now);
			
			// compute the fine, 25 cents per day
			return daysLate * .25;
		} else {
			return 0;
		}
	}
}