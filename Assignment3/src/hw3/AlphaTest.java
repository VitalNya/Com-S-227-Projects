package hw3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import api.Direction;
import api.ShiftDescriptor;
import api.TileInfo;
import ui.ConsoleUI;

public class AlphaTest {
	public static void main(String[] args) {
//		AlphabetSoup g = new AlphabetSoup(2, null);
		
		
		AlphabetSoup g = new AlphabetSoup(5, new AlphabetUtil(), new Random(42));
		int[] arr = {1, 2, 3, 4, 5};
		System.out.println("Before:");
		ConsoleUI.printGrid(g);
		g.setRowColumn(arr, 2, Direction.DOWN);
		System.out.println("After:");
		ConsoleUI.printGrid(g);		
		
		
		
		AlphabetUtil util = new AlphabetUtil();
//        int[] test7 = {1, 3, 3, 2};
//        ArrayList<ShiftDescriptor> descriptors = util.doShift(test7);
//
//        // Print the generated descriptors
//        for (ShiftDescriptor descriptor : descriptors) {
//            System.out.println(descriptor);
//        }
//
//        System.out.println("Expected:");
//        System.out.println("[Merge c 2 to 1, Move b 3 to 2]");
        
        
//        
//        TileInfo info = g.setNewTile();
//        ConsoleUI.printGrid(g);
//        System.out.println();

        
        int[] test7 = {1, 3, 3, 2};
        ArrayList<ShiftDescriptor> descriptors = util.doShift(test7);
        System.out.println(descriptors);
        System.out.println("Expected:");
        System.out.println("[Merge c 2 to 1, Move b 3 to 2]");
        System.out.println();
        
        int[] test8 = {1, 2, 1, 0};
        descriptors = util.doShift(test8);
        System.out.println(descriptors);
        System.out.println("Expected:");
        System.out.println("[]"); // No Moves
        System.out.println();
        
        int[] test9 = {7, 0, 3, 0, 2};
        descriptors = util.doShift(test9);
        System.out.println(descriptors);
        System.out.println("Expected:");
        System.out.println("[Move c 2 to 1, Move b 4 to 3]");
        System.out.println();
        
        int[] test10 = {2, 2, 2, 2};
        descriptors = util.doShift(test10);
        System.out.println(descriptors);
        System.out.println("Expected:");
        System.out.println("[Merge b 1 to 0, Move b 2 to 1, Move b 3 to 2]");
        System.out.println();
        
        int[] test11 = {3, 0, 2, 2};
        descriptors = util.doShift(test11);
        System.out.println(descriptors);
        System.out.println("Expected:");
        System.out.println("[Move b 2 to 1, Move b 3 to 2]");
        System.out.println();
        
        int[] test12 = {0, 0, 5, 0, 7, 7};
        descriptors = util.doShift(test12);
        System.out.println(descriptors);
        System.out.println("Expected:");
        System.out.println("[Move e 2 to 1, Move g 4 to 3, Move g 5 to 4]");
        System.out.println();
        
        int[] test4 = {1, 3, 3, 2};
        descriptors = util.doShift(test4);
        System.out.println(descriptors);
        System.out.println("Expected:");
        System.out.println("[Merge c 2 to 1, Move b 3 to 2]");
        System.out.println();
        System.out.println();

        
        int[] test3 = {7, 0, 3, 0, 2};
        ArrayList<ShiftDescriptor> descriptors1 = util.doShift(test3);
        System.out.println(descriptors1);
        System.out.println("Expected:");
        System.out.println("[Move c 2 to 1, Move b 4 to 3]");
        
        
        
//        System.out.println("Before: ");
//        ConsoleUI.printGrid(g);
//        ArrayList<ShiftDescriptor> moves = g.shift(Direction.DOWN);
//        System.out.println("After: ");
//        ConsoleUI.printGrid(g);
//        System.out.println(moves);
        
        TileInfo info = g.setNewTile();
        ConsoleUI.printGrid(g);
        System.out.println();
        System.out.println("TileInfo: " + info);
        
        g = new AlphabetSoup(4, new AlphabetUtil(), new Random(42));
        int[][] testGrid2 =
        {
        { 0, 2, 3, 1 },
        { 0, 1, 3, 2 },
        { 0, 2, 3, 0 },
        { 0, 1, 2, 0 }
        };
        
        
        for (int row = 0; row < testGrid2.length; row += 1)
        {
        for (int col = 0; col < testGrid2[0].length; col += 1)
        {
        g.setCell(row, col, testGrid2[row][col]);
        }
        }
        
        System.out.println("Before: ");
        ConsoleUI.printGrid(g);
        ArrayList<ShiftDescriptor> moves = g.shift(Direction.DOWN);
        System.out.println("After: ");
        ConsoleUI.printGrid(g);
        System.out.println(moves);
        
        System.out.println(g.getLastDirection());
        System.out.println("Expected DOWN");

	}

}
