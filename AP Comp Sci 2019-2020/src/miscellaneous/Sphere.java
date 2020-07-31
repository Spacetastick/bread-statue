package miscellaneous;

//Noah Cil

public class Sphere {
	
	private double r;
	
	public Sphere(double r) {
		this.r = r;
	}

	public double Volume() { 
		return (4 * Math.PI * Math.pow(r, 3)) / 3;
	}
	
	public double Surface() {
		return 4 * Math.PI * Math.pow(r, 2);
	}
	
}
