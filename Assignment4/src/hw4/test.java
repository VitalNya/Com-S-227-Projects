package hw4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import api.GameConfiguration;
import api.ScoreBox;

public class test {
	public static void main(String[] args) {
		Combination c = new Combination(new int[] {1, 3, 2, 5, 2});
		System.out.println(Arrays.toString(c.getAvailableDice()));
		System.out.println("Expected [1, 2, 2, 3, 5]");
		System.out.println(Arrays.toString(c.getCompletedDice()));
		System.out.println("Expected []");
		System.out.println();
		
		c.choose(3);
		c.choose(2);
		System.out.println(Arrays.toString(c.getAvailableDice()));
		System.out.println("Expected [1, 2, 5]");
		System.out.println(Arrays.toString(c.getCompletedDice()));
		System.out.println("Expected [2, 3]");
		System.out.println(Arrays.toString(c.getAll()));
		System.out.println("Expected [1, 2, 2, 3, 5]");
		System.out.println();
		
		System.out.println(c.isComplete());
		System.out.println("Expected false");
		System.out.println();
		
		c.updateAvailableDice(new int[] {6, 4, 2});
		System.out.println(Arrays.toString(c.getAvailableDice()));
		System.out.println("Expected [2, 4, 6]");
		System.out.println(Arrays.toString(c.getCompletedDice()));
		System.out.println("Expected [2, 3]");
		System.out.println(Arrays.toString(c.getAll()));
		System.out.println("Expected [2, 2, 3, 4, 6]");
		System.out.println();
		
		c.chooseAll();
		System.out.println(Arrays.toString(c.getAvailableDice()));
		System.out.println("Expected []");
		System.out.println(Arrays.toString(c.getCompletedDice()));
		System.out.println("Expected [2, 2, 3, 4, 6]");
		System.out.println(Arrays.toString(c.getAll()));
		System.out.println("Expected [2, 2, 3, 4, 6]");
		System.out.println();
		
		// should be complete now
		System.out.println(c.isComplete());
		System.out.println("Expected true");
		System.out.println();
		
		//ScoreBox sb = new MatchTargetScoreBox("Threes", 3);
		api.ScoreBox  sb = new MatchTargetScoreBox("Threes", 3);
		int[] test = {1, 3, 3, 3, 3, 5, 6};
		System.out.println(sb.isSatisfiedBy(test));
		System.out.println("Expected true");
		System.out.println(sb.getPotentialScore(test));
		System.out.println("Expected 12");
		
		// try filling the score box with a completed Combination
		c = new Combination(test);
		c.chooseAll();
		sb.fill(c);
		System.out.println(sb.isFilled());
		System.out.println("Expected true");
		System.out.println(sb.getScore());
		System.out.println("Expected 12");
		Combination saved = sb.getDice();
		System.out.println(c == saved);
		System.out.println("Expected true");
		
		GameConfiguration config = new GameConfiguration(
				4, // four dice
				5, // max value 5
				4, // 4 rolls per turn
				0, // upper section bonus
				0, // upper section bonus cutoff
				true); // extra rolls are saved for future turns
		MaxiYatzy game = new MaxiYatzy(config, new Random(42));
		game.addLowerSectionScoreBox(new MatchTargetScoreBox("Threes", 3));
		game.addLowerSectionScoreBox(new ChanceScoreBox("Chance"));
		ArrayList<ScoreBox> lower = game.getLowerSection();
		for (ScoreBox b : lower){
		System.out.println(b.getDisplayName());
		}
		System.out.println("Expected 'Threes', 'Chance' ");
		
		game.startTurn();
		System.out.println(game.getRemainingRolls());
		System.out.println("Expected 4");
		Combination comb = game.getCurrentDice();
		System.out.println(Arrays.toString(comb.getAvailableDice()));
		System.out.println("Expected [0, 0, 0, 0]");
		game.rollAvailableDice();
		System.out.println(Arrays.toString(comb.getAvailableDice()));
		System.out.println("(Expected four random nonzero values in range 1-5)");
		System.out.println(game.getRemainingRolls());
		System.out.println("Expected 3");
		
		comb.chooseAll();
		lower.get(1).fill(comb);
		System.out.println(game.getLowerSectionTotal());
		System.out.println(game.getTotalScore());
		System.out.println("(Expected: sum of dice above used to fill Chance box)");
		// start new turn
		game.startTurn();
		System.out.println(game.getRemainingRolls());
		System.out.println("Expected 7");
		
		sb = new FullHouseScoreBox("Full House");
		System.out.println(sb.getPotentialScore(new int[] {1, 2, 3, 4, 5, 5}));
		System.out.println("Expected 0");
		System.out.println(sb.getPotentialScore(new int[] {2, 2, 3, 4, 5, 5}));
		System.out.println("Expected 0");
		System.out.println(sb.getPotentialScore(new int[] {2, 2, 3, 3, 3, 5}));
		System.out.println("Expected 18");
		sb = new NOfAKindScoreBox("3 of a kind", 3);
		System.out.println(sb.getPotentialScore(new int[] {2, 2, 2, 3, 3, 3, 3, 4}));
		System.out.println("Expected 9");
		
		sb = new CastleScoreBox("CastleScoreBox");
		System.out.println(sb.getPotentialScore(new int[] {2, 2, 2, 5, 5, 5, 5, 6}));
		System.out.println("Expected 32");
		
		System.out.print("//////////////PIAZZA TESTS///////////////////////////");
		
		sb = new AllMatchScoreBox("all match", 10);
		System.out.println();
		System.out.println(" All Match");
		System.out.println(sb.isSatisfiedBy(new int[] {3, 3, 3, 3, 3}));
		System.out.println("Expected true");
		System.out.println(sb.isSatisfiedBy(new int[] {2, 2, 2, 3, 3, 3, 3, 4}));
		System.out.println("Expected false");
		
		sb = new CastleScoreBox("CastleScoreBox");
		System.out.println();
		System.out.println(" Castle");
		System.out.println(sb.isSatisfiedBy(new int[] {2, 2, 2, 3, 3, 3, 4}));
		System.out.println("Expected true");
		System.out.println(sb.isSatisfiedBy(new int[] {2, 2, 2, 3, 3, 3, 3, 4}));
		System.out.println("Expected true");
		
		sb = new ChanceScoreBox("ChanceScoreBox");
//		
		sb = new FullHouseScoreBox("Full House");
		System.out.println();
		System.out.println(" Full House");
		System.out.println(sb.isSatisfiedBy(new int[] {1, 2, 3, 4, 5, 5}));
		System.out.println("Expected false");
		System.out.println(sb.isSatisfiedBy(new int[] {2, 2, 3, 4, 5, 5}));
		System.out.println("Expected false");
		System.out.println(sb.isSatisfiedBy(new int[] {2, 2, 3, 4, 5, 5, 5}));
		System.out.println("Expected true");
		System.out.println(sb.isSatisfiedBy(new int[] {2, 2, 3, 3, 5, 5}));
		System.out.println("Expected false");
		System.out.println(sb.isSatisfiedBy(new int[] {2, 2, 2, 3, 3, 5}));
		System.out.println("Expected true");
		System.out.println(sb.isSatisfiedBy(new int[] {2, 2, 3, 3, 3, 5}));
		System.out.println("Expected true");
		System.out.println(sb.isSatisfiedBy(new int[] {2, 3, 3, 3, 5, 5, 5}));
		System.out.println("Expected false");
		
		sb = new LargeStraightScoreBox("Large Straight", 10);
		System.out.println();
		System.out.println(" Large Straight");
		System.out.println(sb.isSatisfiedBy(new int[] {1, 2, 3, 4, 5, 5}));
		System.out.println("Expected false");
		System.out.println(sb.isSatisfiedBy(new int[] {1, 2, 3, 4, 5, 6}));
		System.out.println("Expected true");
		System.out.println(sb.isSatisfiedBy(new int[] {5, 6, 7, 8, 9, 10, 11, 12}));
		System.out.println("Expected true");
//		
		sb = new NOfAKindScoreBox("3 of a kind", 3);
		System.out.println();
		System.out.println(" 3 of a kind");
		System.out.println(sb.isSatisfiedBy(new int[] {2, 2, 2, 3, 3, 3, 3, 4}));
		System.out.println("Expected true");
		System.out.println(sb.isSatisfiedBy(new int[] {2, 2, 1, 3, 3, 4, 6, 4, 5}));
		System.out.println("Expected false");
//		
//		
		sb = new ShortStraightScoreBox("Short Straight Score Box", 20);
		System.out.println();
		System.out.println(" Short Straight");
		System.out.println(sb.isSatisfiedBy(new int[] {1, 2, 3, 3, 4, 5, 6, 7}));
		System.out.println("Expected true");
		System.out.println(sb.isSatisfiedBy(new int[] {1, 2, 3, 3, 4, 5, 5, 6, 7}));
		System.out.println("Expected false");
		
		// This does not work
		sb = new TowerScoreBox("Tower Score Box");
		System.out.println();
		System.out.println(" Tower Score Box");
		System.out.println(sb.isSatisfiedBy(new int[] {2, 2, 2, 2, 3, 3, 4}));
		System.out.println("Expected true");
		System.out.println(sb.isSatisfiedBy(new int[] {2, 2, 2, 2, 3, 3, 3, 4}));
		System.out.println("Expected false");
		System.out.println(sb.isSatisfiedBy(new int[] {2, 2, 2, 3, 3, 3, 4}));
		System.out.println("Expected false");
		System.out.println(sb.isSatisfiedBy(new int[] {2, 2, 3, 3, 3, 3, 4, 4}));
		System.out.println("Expected true");
		
		sb = new TwoPairsScoreBox("Two Pairs Score Box");
		System.out.println();
		System.out.println(" Two Pairs Score Box");
		System.out.println(sb.isSatisfiedBy(new int[] {2, 2, 2, 2, 3, 3, 4}));
		System.out.println("Expected true");
		System.out.println(sb.isSatisfiedBy(new int[] {2, 2, 2, 3, 3, 4}));
		System.out.println("Expected true");
	}
}
