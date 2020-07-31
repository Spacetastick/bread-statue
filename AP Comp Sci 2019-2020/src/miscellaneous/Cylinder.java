package miscellaneous;

//Noah Cil

public class Cylinder {

	private double r, h;
	
	public Cylinder(double r, double h) {
		this.r = r;
		this.h = h;
	}
	
	public double Volume() {
		return Math.PI * Math.pow(r, 2) * h;
	}
	
	public double Surface() {
		return (2 * Math.PI * r * h) + (2 * Math.PI * Math.pow(r, 2));
	}
	
}
