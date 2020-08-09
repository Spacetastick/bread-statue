package lab2;

abstract class Triangle {
	
	private double side;
	
	public Triangle(double a) {
		side = a;
	}
	
	public double getSide() {
		return side;
	}
	
	abstract double getPerimeter();
	
	abstract double getArea();
	
	public double getRatio() {
		return getArea() / getPerimeter();
	}
	
}