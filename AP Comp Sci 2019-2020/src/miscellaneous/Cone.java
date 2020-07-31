package miscellaneous;

//Noah Cil

public class Cone {

	private double r, h;
	
	public Cone(double r, double h) {
		this.r = r;
		this.h = h;
	}
	
	public double Volume() {
		return Math.PI * Math.pow(r, 2) * (h/3);
	}
	
	public double Surface() {
		return (Math.PI * r) * (r + Math.sqrt(Math.pow(h, 2) + Math.pow(r, 2)));
	}
	
}
