package hw3;

import java.util.ArrayList;
import java.util.Random;
import api.Direction;
import api.ShiftDescriptor;
import api.TileInfo;

import static api.Direction.*;

/**
 * This class contains the state and logic for an implementation of a video game
 * we call AlphabetSoup. The basic underlying state is an n by n grid of tiles,
 * represented by integer values. A zero in a cell is considered to be "empty".
 * To play the game, a client calls the method <code>shift()</code>, selecting
 * one of the four directions (LEFT, RIGHT, UP, DOWN). Each row or column is
 * then shifted according to the rules encapsulated in the associated
 * <code>AlphabetUtil</code> object. The move is completed by calling
 * <code>setNewTile</code>, which makes a new tile appear in the grid in
 * preparation for the next move.
 * <p>
 * The game uses an instance of java.util.Random to generate new tile values and
 * to select the location for a new tile to appear. The new values are generated
 * by the associated <code>AlphabetUtil</code>'s <code>randomNewTileValue</code>
 * method, and the new positions are generated in the <code>setNewTile</code>
 * method of this class.
 * <p>
 * The score in the game is the sum, over all cells, of the individual scores
 * returned by the <code>AlphabetUtil</code>'s <code>getScoreForOneTile()</code>
 * method.
 */
public class AlphabetSoup {
	private int[][] gameGrid;
	private int size;
	private AlphabetUtil config;
	private Random ran;
	private int score;
	private Direction direction;
	private Boolean shifted;

	/**
	 * Constructs a game with a grid of the given size, using a default random
	 * number generator. The initial grid is produced by the
	 * <code>createNewGrid</code> method of the given <code>AlphabetUtil</code>
	 * object.
	 * 
	 * @param givenSize   size of the grid for this game
	 * @param givenConfig given instance of GameUtil
	 */
	public AlphabetSoup(int givenSize, AlphabetUtil givenConfig) {
		size = givenSize;
		config = givenConfig;
		gameGrid = new int[size][size];
		ran = new Random();
		score = 0;
		shifted = false;
	}

	/**
	 * Constructs a game with a grid of the given size, using the given instance of
	 * <code>Random</code> for the random number generator. The initial grid is
	 * produced by the <code>createNewGrid</code> method of the given
	 * <code>AlphabetUtil</code> object.
	 * 
	 * @param givenSize   size of the grid for this game
	 * @param givenConfig given instance of AlphabetUtil
	 * @param givenRandom given instance of Random
	 */
	public AlphabetSoup(int givenSize, AlphabetUtil givenConfig, Random givenRandom) {
		size = givenSize;
		config = givenConfig;
		gameGrid = new int[size][size];
		ran = givenRandom;
		score = 0;
		shifted = false;		
	}

	/**
	 * Returns the value in the cell at the given row and column.
	 * 
	 * @param row given row
	 * @param col given column
	 * @return value in the cell at the given row and column
	 */
	public int getCell(int row, int col) {
		return gameGrid[row][col];
	}

	
	/**
	 * Sets the value of the cell at the given row and column. <em>NOTE: This method
	 * should not be used by clients outside of a testing environment.</em>
	 * 
	 * @param row   given row
	 * @param col   given col
	 * @param value value to be set
	 */
	public void setCell(int row, int col, int value) {
		gameGrid[row][col] = value;
	}

	/**
	 * Returns the size of this game's grid.
	 * 
	 * @return size of the grid
	 */
	public int getSize() {
		return size;

	}

	/**
	 * Returns the current score.
	 * 
	 * @return score for this game
	 */
	public int getScore() {
		return score;
	}

	/**
	 * Returns the direction from the most recent call to <code>shift()</code> when
	 * a corresponding call to <code>setNewTile()</code> has not yet been made.
	 * Otherwise, the method returns null.
	 * 
	 * @return direction of current pending shift
	 */
	public Direction getLastDirection() {
		return direction;
	}

	/**
	 * Copy a row or column from the grid into a new one-dimensional array. There
	 * are four possible actions depending on the given direction:
	 * <ul>
	 * <li>LEFT - the row indicated by the index <code>rowOrColumn</code> is copied
	 * into the new array from left to right
	 * <li>RIGHT - the row indicated by the index <code>rowOrColumn</code> is copied
	 * into the new array in reverse (from right to left)
	 * <li>UP - the column indicated by the index <code>rowOrColumn</code> is copied
	 * into the new array from top to bottom
	 * <li>DOWN - the row indicated by the index <code>rowOrColumn</code> is copied
	 * into the new array in reverse (from bottom to top)
	 * </ul>
	 * 
	 * @param rowOrColumn index of the row or column
	 * @param dir         direction from which to begin copying
	 * @return array containing the row or column
	 */
	public int[] getRowColumn(int rowOrColumn, Direction dir) {
		// TODO

		int[] portion = new int[gameGrid.length];

		if (dir == RIGHT) {
			int j = 0;
			for (int i = gameGrid.length - 1; i >= 0; i--) {

				portion[j] = gameGrid[rowOrColumn][i];
				j++;
			}
		} else if (dir == LEFT) {
			for (int i = 0; i < gameGrid.length; i++) {
				portion[i] = gameGrid[rowOrColumn][i];
			}
		} else if (dir == DOWN) {
			int j = 0;
			for (int i = gameGrid.length - 1; i >= 0; i--) {
				portion[j] = gameGrid[i][rowOrColumn];
				j++;
			}
		} else if (dir == UP) {
			for (int i = 0; i < gameGrid.length; i++) {
				portion[i] = gameGrid[i][rowOrColumn];
			}
		}

		return portion;
	}


	/**
	 * Updates the grid by copying the given one-dimensional array into a row or
	 * column of the grid. There are four possible actions depending on the given
	 * direction:
	 * <ul>
	 * <li>LEFT - the given array is copied into the the row indicated by the index
	 * <code>rowOrColumn</code> from left to right
	 * <li>RIGHT - the given array is copied into the the row indicated by the index
	 * <code>rowOrColumn</code> in reverse (from right to left)
	 * <li>UP - the given array is copied into the column indicated by the index
	 * <code>rowOrColumn</code> from top to bottom
	 * <li>DOWN - the given array is copied into the column indicated by the index
	 * <code>rowOrColumn</code> in reverse (from bottom to top)
	 * </ul>
	 * 
	 * @param arr         the array from which to copy
	 * @param rowOrColumn index of the row or column
	 * @param dir         direction from which to begin copying
	 */
	public void setRowColumn(int[] arr, int rowOrColumn, Direction dir) {
	    if (dir == RIGHT || dir == DOWN) {
	        for (int i = arr.length - 1; i >= 0; i--) {
	            int index = arr.length - 1 - i;
	            if (dir == RIGHT) {
	                gameGrid[rowOrColumn][i] = arr[index];
	            } else {
	                gameGrid[i][rowOrColumn] = arr[index];
	            }
	        }
	    } else if (dir == LEFT || dir == UP) {
	        for (int i = 0; i < arr.length; i++) {
	            if (dir == LEFT) {
	                gameGrid[rowOrColumn][i] = arr[i];
	            } else {
	                gameGrid[i][rowOrColumn] = arr[i];
	            }
	        }
	    }
	}
	
	/**
	 * Plays one step of the game by shifting the grid in the given direction.
	 * Returns a list of <code>ShiftDescriptor</code> objects describing all moves
	 * performed. All <code>ShiftDescriptor</code> objects must include a valid
	 * value for <code>getRowOrColumn()</code> and <code>getDirection()</code>. If
	 * no cells are actually moved, the method returns an empty list.
	 * <p>
	 * The shift of an individual row or column is performed by the method
	 * <code>shift()</code> of the associated <code>AlphabetUtil</code> instance.
	 * <p>
	 * This method does not update the score (that occurs in
	 * <code>setNewTile()</code>).
	 * 
	 * @param dir direction in which to shift the grid
	 * @return list of moved or merged tiles
	 */
	public ArrayList<ShiftDescriptor> shift(Direction dir) {
		// TODO
		ArrayList<ShiftDescriptor> suffix = new ArrayList<>();

		int[] temp = new int[gameGrid.length];
		direction = dir;
		int i = 0;
		for (i = 0; i < gameGrid.length; i++) {
			temp = getRowColumn(i, dir);
			ArrayList<ShiftDescriptor> k = config.doShift(temp);
			setRowColumn(temp, i, dir);
			for (int j = 0; j < k.size(); j++) {
				ShiftDescriptor temp1 = (k.get(j));
				temp1.setDirection(i, dir);
				suffix.add(temp1);
			}
			for (int j = 1; j < gameGrid.length; j++) {
				suffix.add(new ShiftDescriptor(i, temp[j]));
			}

		}

		return suffix;
	}
	/**
	 * Generates a new tile and places its value in the grid, provided that there
	 * was a previous call to <code>shift()</code> without a corresponding call to
	 * <code>setNewTile</code> (in other words, when <code>getLastDirection()</code>
	 * returns a non-null value). In all other cases, this method does nothing and
	 * returns null.
	 * <p>
	 * The tile's value is determined by the associated <code>AlphabetUtil</code>'s
	 * <code>randomNewTileValue()</code> method. The tile's position is randomly
	 * selected from the empty cells on the side of the grid opposite the previous
	 * move's direction.
	 * <p>
	 * This method updates the total score, and the score includes the newly
	 * generated tile.
	 * 
	 * @return TileInfo object containing the new tile's position and value, or null
	 *         if no new tile is added to the grid
	 */
	public TileInfo setNewTile() {
		if (shifted) {
			// Generate a random value for the new tile
			int value = config.randomNewTileValue(ran);

			int row = 0;
			int column = 0;

			if (direction != null) { // How to check if getLastDirection() returns no-null value
				if (direction == RIGHT) {
					// Place the new tile on the left side of the grid
					row = ran.nextInt(size);
					column = 0;
				} else if (direction == LEFT) {
					row = ran.nextInt(size);
					column = size - 1;
				} else if (direction == UP) {
					row = size - 1;
					column = ran.nextInt(size);
				} else if (direction == DOWN) {
					row = 0;
					column = ran.nextInt(size);
				} else {
					row = -1;
					column = -1;
				}
			}

			if (row >= 0 && column >= 0 && gameGrid[row][column] == 0) {
				// Place the new tile if the cell is empty
				gameGrid[row][column] = value;
				shifted = false; // Reset the shifted flag
				// Update the total score (you need to implement the scoring mechanism)
				score = (int) Math.pow(3, value - 1);
				// Create a TileInfo object and return it
				return new TileInfo(row, column, score);
			}
		}

		// Return null if no new tile is added to the grid
		return null;
	}

}
