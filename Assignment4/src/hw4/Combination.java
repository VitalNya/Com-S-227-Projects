package hw4;

import java.util.Arrays;

/**
 * Group of dice for a dice game such as MaxiYatzy in which multiple rolls per
 * turn are allowed. The dice are partitioned into "available" dice and
 * "complete" dice. The available dice can be re-rolled (that is, they can get
 * new values via the <code>update</code> method). The client can select which
 * dice to move from available to complete. Once all dice are complete, as
 * determined by the <code>isComplete()</code> method, the
 * <code>getAvailable()</code> method always returns an empty array, and the
 * state of the combination can no longer be modified.
 *
 * @author VITAL NYABASHI
 */
public class Combination {
    /**
     * Constructs a new Combination in which each die initially has the (invalid)
     * value zero and all dice are available. In normal usage, a client would
     * replace the available die values with randomly generated numbers in an
     * appropriate range, to simulate rolling the dice.
     *
     * @param numDice number of dice in this group
     */
    private int[] availableDice;
    private int[] completedDice;

    public Combination(int numDice) {
        availableDice = new int[numDice];
        completedDice = new int[0];
    }

    /**
     * Constructs a new Combination in which each die initially has the value given
     * by the <code>initialValues</code> array. All dice are initially available.
     * The number of dice is determined by the size of the given array.
     * <p>
     * This version of the constructor is primarily intended for testing.
     *
     * @param initialValues initial values for the dice
     */
    public Combination(int[] initialValues) {
        availableDice = Arrays.copyOf(initialValues, initialValues.length);
        completedDice = new int[0];
    }

    /**
     * Returns the number of dice in this group.
     *
     * @return number of dice in this group
     */
    public int getNumDice() {
        return availableDice.length;
    }

    /**
     * Selects a die value to be moved from the available dice to the completed
     * dice. Has no effect if the given value is not among the values in the
     * available dice.
     *
     * @param value die value to be moved
     */
    public void choose(int value) {
        for (int i = 0; i < availableDice.length; i++) {
            if (availableDice[i] == value) {
                // Move the chosen value from available to completed dice
                int[] newCompletedDice = Arrays.copyOf(completedDice, completedDice.length + 1);
                newCompletedDice[newCompletedDice.length - 1] = value;
                completedDice = newCompletedDice;

                // Update available dice array without the chosen value
                int[] newAvailableDice = new int[availableDice.length - 1];
                System.arraycopy(availableDice, 0, newAvailableDice, 0, i);
                System.arraycopy(availableDice, i + 1, newAvailableDice, i, availableDice.length - i - 1);
                availableDice = newAvailableDice;

                break;
            }
        }
    }

    /**
     * Causes all die values be moved from the available dice to the completed dice.
     * After this method is called, <code>getAvailable</code> always returns an
     * empty array, and <code>isComplete</code> returns true.
     */
    public void chooseAll() {
        int combinedLength = availableDice.length + completedDice.length;
        int[] allDice = new int[combinedLength];
        System.arraycopy(availableDice, 0, allDice, 0, availableDice.length);
        System.arraycopy(completedDice, 0, allDice, availableDice.length, completedDice.length);
        completedDice = allDice;
        availableDice = new int[0];
    }

    /**
     * Determines whether there are any dice available to be rolled in this
     * combination.
     *
     * @return true if there are no available dice, false otherwise
     */
    public boolean isComplete() {
        return availableDice.length == 0;
    }

    /**
     * Returns the values of the dice that are not available to be re-rolled, in
     * ascending order.
     *
     * @return values of the dice that are not available to be re-rolled
     */
    public int[] getCompletedDice() {
        Arrays.sort(completedDice);
        return completedDice;
    }

    /**
     * Returns the values of the dice that are available to be re-rolled, in
     * ascending order.
     *
     * @return dice that are available to be re-rolled
     */
    public int[] getAvailableDice() {
        Arrays.sort(availableDice);
        return availableDice;
    }

    /**
     * Returns all die values in this combination, in ascending order.
     *
     * @return all die values in this group
     */
    public int[] getAll() {
        int[] allDice = Arrays.copyOf(availableDice, availableDice.length + completedDice.length);
        System.arraycopy(completedDice, 0, allDice, availableDice.length, completedDice.length);
        Arrays.sort(allDice);
        return allDice;
    }

    /**
     * Replaces the available dice with the given values. Throws an
     * IllegalStateException if the length of the given array does not match the
     * number of available dice in this Combination.
     *
     * @param newValues array of new die values for available dice
     * @throws IllegalStateException if the given array has the wrong length
     */
    public void updateAvailableDice(int[] newValues) {
        if (newValues.length != availableDice.length) {
            throw new IllegalStateException("Length of the given array does not match the number of available dice.");
        }
        for (int i = 0; i < newValues.length; i++) {
            availableDice[i] = newValues[i];
        }
    }

    /**
     * Returns a string representation of the die values in this combination, in the
     * form <em>available</em>(<em>complete</em>). (For example, if there are two
     * completed dice with values 2 and 4, and there are 3 available dice with
     * values 1, 1, and 6, then the method returns the string
     * <p>
     * 1 1 6 (2 4)
     *
     * @return string representation of the available and completed dice, with the
     * completed values in parentheses
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int[] avail = getAvailableDice();
        int[] completed = getCompletedDice();
        if (avail.length > 0) {
            for (int value : avail) {
                sb.append(value + " ");
            }
        }
        sb.append("(");
        if (completed.length > 0) {
			sb.append(completed[0]);
			for (int i = 1; i < completed.length; ++i) {
				sb.append(" " + completed[i]);
			}
		}
		sb.append(")");
		return sb.toString();
	}

}