package lab6;

import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import plotter.Polyline; // Import the Polyline class from the plotter package
import plotter.Plotter;

public class Polyline {
	public static Polyline parseOneLine(String line) {
		line = line.trim(); // Remove leading and trailing whitespace

		// Skip blank lines and comments
		if (line.isEmpty() || line.startsWith("#")) {
			return null;
		}

		Scanner scanner = new Scanner(line);

		int lineWidth = 1; // Default line width if not specified
		if (scanner.hasNextInt()) {
			lineWidth = scanner.nextInt();
		}

		Color color = Color.BLACK; // Default color if not specified
		if (scanner.hasNext()) {
			String colorName = scanner.next();
			color = getColorFromString(colorName);
		}

		ArrayList<Point> points = new ArrayList<>();
		while (scanner.hasNextInt()) {
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			points.add(new Point(x, y));
		}

		return new Polyline(lineWidth, color, points);
	}

	private static Color getColorFromString(String colorName) {
		// You can implement a mapping of color names to Color objects here.
		// For simplicity, we'll assume the color name is in lowercase.
		switch (colorName) {
		case "red":
			return Color.RED;
		case "blue":
			return Color.BLUE;
		case "green":
			return Color.GREEN;
		default:
			return Color.BLACK; // Default to black for unknown colors
		}
	}


	private static ArrayList<Polyline> readFile(String filename) throws FileNotFoundException {
		ArrayList<Polyline> polylines = new ArrayList<>();
		File file = new File(filename);
		Scanner scanner = new Scanner(file);

		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			Polyline p = parseOneLine(line);
			if (p != null) {
				polylines.add(p);
			}
		}

		scanner.close();
		return polylines;
	}

	/**
	 * @test
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		ArrayList<Polyline> list = readFile("hello.txt");
		Plotter plotter = new Plotter();

		for (Polyline p : list) {
			plotter.plot(p);
		}
	}
	
	/**
	 * @test
	 * @param args
	 */
	 public static void main(String[] args)
	  {
	    Plotter plotter = new Plotter();
	    Polyline p = parseOneLine("red 100 100 200 100 200 200 100 200 100 100");
	    plotter.plot(p);
	    
	    p = parseOneLine("2 blue 250 100 400 350 100 350 250 100");
	    plotter.plot(p);
	  }

}