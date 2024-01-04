package lab3;



public class Basketball {
	private double diameter;
	private boolean isInflated;
	//private boolean isDribbleable;
	
	public Basketball(double givenDiameter) {
		isInflated = false;
		//isDribbleable = false;
		diameter = givenDiameter;
		
		
	}

	public boolean isDribbleable() {
		return isInflated;
	}

	public double getDiameter() {
		return diameter;
	}

	public double getCircumference() {
		return 0;
	}

	public void inflate() {
		isInflated = true;
	}
}