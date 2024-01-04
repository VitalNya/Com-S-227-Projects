package library;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class superClass implements Item {
	/**
	 * Title of this item.
	 */
	private String title;

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
	 * Duration of this DVD, in minutes.
	 */
	private int duration;

	/**
	 * Returns the duration of this Movie.
	 * 
	 * @return duration of this Movie
	 */
	public int getDuration() {
		return duration;
	}

	/**
	 * 
	 * @param givenTitle
	 */
	public superClass(String givenTitle) {
		title = givenTitle;
	}

	// This will be overrided. the checkOutDays was different for each class
	public void takeOut(Patron p, Date now, int checkOutDays) {
		if (!isCheckedOut()) {
			// use a GregorianCalendar to figure out the Date corresponding to
			// midnight, 14 days from now
			GregorianCalendar cal = new GregorianCalendar();
			cal.setTime(now);
			cal.add(Calendar.DAY_OF_YEAR, checkOutDays);

			// always set to 11:59:59 pm on the day it's due
			cal.set(Calendar.HOUR_OF_DAY, 23);
			cal.set(Calendar.MINUTE, 59);
			cal.set(Calendar.SECOND, 59);

			// convert back to Date object
			dueDate = cal.getTime();

			checkedOutTo = p;
		}
	}

	public void checkIn() {
		if (isCheckedOut()) {
			checkedOutTo = null;
			dueDate = null;
		}
	}

	public int Fine(Date now) {
		// how late is it, in milliseconds
		double elapsed = now.getTime() - dueDate.getTime();

		// how late is it, in days
		int millisPerDay = 24 * 60 * 60 * 1000;
		int daysLate = (int) Math.ceil(elapsed / millisPerDay);
		return daysLate;
	}

	public boolean isOverdue(Date now) {
		if (!isCheckedOut()) {
			return false;
		}
		return now.after(dueDate);
	}

	public int compareTo(Item other) {
		return title.compareTo(other.getTitle());
	}

	public String getTitle() {
		return title;
	}

	public boolean isCheckedOut() {
		return dueDate != null;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public Patron getPatron() {
		return checkedOutTo;
	}

	public void renew(Date now) {
		// cannot be renewed
	}

	@Override
	public void checkOut(Patron p, Date now) {
		// TODO Auto-generated method stub

	}

	@Override
	public double getFine(Date now) {
		// TODO Auto-generated method stub
		return 0;
	}

}
