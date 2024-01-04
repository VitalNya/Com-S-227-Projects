package hw4;

import java.util.ArrayList;
import java.util.Random;

import api.GameConfiguration;
import api.ScoreBox;

/**
 * Game state for dice games such as MaxiYatzy. The game includes a
 * <code>GameConfiguration</code> object along with two lists of
 * <code>ScoreBox</code> objects, one for the upper section and one for the
 * lower section. (Note that the only actual distinction between the two
 * sections is that the upper section scores are added up and checked to see
 * whether they exceed the upper section bonus cutoff; if so, the upper section
 * bonus is added to the score.) This class is also responsible for maintaining
 * a current Combination (group of dice) and counting the number of rolls.
 * <p>
 * Most of the game state is stored in the associated <code>ScoreBox</code>
 * objects, each of which knows its contribution to the overall score, obtained
 * via its <code>getScore</code> method.
 * 
 * @author VITAL NYABASHI
 */
public class MaxiYatzy {
	private ScoreBox lowValue;
	private ScoreBox upperValue;
	private ArrayList<ScoreBox> lowValues = new ArrayList<>();
	private ArrayList<ScoreBox> upperValues = new ArrayList<>();
	private Combination com;
	private GameConfiguration configuration;
	private Random random;
	private int availableRolls;
	private int[] availableDice;
	private int upperSecBonus;
	private int lowerSecTotal = 0;
	private int upperSecTotal = 0;

	/**
     * Constructs a MaxiYatzy game state with the given configuration and random number generator.
     *
     * @param config the game configuration
     * @param rand   the random number generator
     */
	public MaxiYatzy(GameConfiguration config, Random rand) {
		configuration = config;
		random = rand;
		availableRolls = 0;
	}

	/**
     * Adds a ScoreBox to the lower section of the game.
     *
     * @param box the ScoreBox to be added to the lower section
     */
	public void addLowerSectionScoreBox(ScoreBox box) {
		lowValue = box;
		lowValues.add(lowValue);
	}

	 /**
     * Adds a ScoreBox to the upper section of the game.
     *
     * @param box the ScoreBox to be added to the upper section
     */
	public void addUpperSectionScoreBox(ScoreBox box) {
		upperValue = box;
		upperValues.add(box);
	}

	/**
     * Gets the list of ScoreBoxes in the upper section.
     *
     * @return the list of ScoreBoxes in the upper section
     */
	public ArrayList<ScoreBox> getUpperSection() {
		return upperValues;
	}

	/**
     * Gets the list of ScoreBoxes in the lower section.
     *
     * @return the list of ScoreBoxes in the lower section
     */
	public ArrayList<ScoreBox> getLowerSection() {
		return lowValues;
	}

	/**
     * Starts a new turn by initializing a new Combination and setting the available rolls.
     */
	public void startTurn() {
		com = new Combination(configuration.getNumDice());
		if (configuration.allowSavedRolls()) {
			availableRolls += configuration.getMaxRolls();
		} else {
			availableRolls = configuration.getMaxRolls();
		}
	}

	 /**
     * Gets the remaining rolls for the current turn.
     *
     * @return the remaining rolls for the current turn
     */
	public int getRemainingRolls() {
		return availableRolls;
	}

	/**
     * Rolls the available dice, reducing the available rolls and updating the Combination.
     */
	public void rollAvailableDice() {
		availableRolls--;
		availableDice = com.getAvailableDice();
		for (int i = 0; i < availableDice.length; i++) {
			availableDice[i] = random.nextInt(configuration.getMaxValue()) + 1;
		}
		com.updateAvailableDice(availableDice);
		if (availableRolls <= 0) {
			com.chooseAll();
		}
	}

	/**
     * Gets the current Combination of dice.
     *
     * @return the current Combination of dice
     */
	public Combination getCurrentDice() {
		return com;
	}

	/**
     * Checks if the current turn is over.
     *
     * @return true if the turn is over, false otherwise
     */
	public boolean isOver() {
		return availableRolls <= 0;
	}

	 /**
     * Gets the total score of the upper section.
     *
     * @return the total score of the upper section
     */
	public int getUpperSectionTotal() {
		upperSecTotal = 0;
		for (ScoreBox box : upperValues) {
			if (box.isFilled()) {
				upperSecTotal += box.getScore();
			}
		}
		return upperSecTotal;
	}

	/**
     * Gets the total score of the lower section.
     *
     * @return the total score of the lower section
     */
	public int getLowerSectionTotal() {
		lowerSecTotal = 0;
		for (ScoreBox box : lowValues) {
			if (box.isFilled()) {
				lowerSecTotal += box.getScore();
			}
		}
		return lowerSecTotal;
	}

	
	/**
     * Gets the overall total score of the game, including upper section bonus.
     *
     * @return the overall total score of the game
     */
	public int getTotalScore() {
		int overallTotal = getUpperSectionBonus() + getLowerSectionTotal() + getUpperSectionTotal();
		return overallTotal;
	}

	/**
     * Gets the upper section bonus.
     *
     * @return the upper section bonus
     */
	public int getUpperSectionBonus() {
		upperSecBonus = 0;
		if (configuration.getUpperSectionBonus() >= 1) {
			upperSecBonus = configuration.getUpperSectionBonus();
		} else {
			upperSecBonus = 0;
		}
		return upperSecBonus;
	}
}