package miscellaneous;

//Noah Cil

public class Cube {

	private double h;
	
	public Cube(double h) {
		this.h = h;
	}
	
	public double Volume() {
		return Math.pow(h, 3);
	}
	
	public double Surface() {
		return (Math.pow(h, 2)) * 6;
	}
	
	
}
