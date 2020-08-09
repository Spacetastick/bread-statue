package lab2;

public class RightTriangle extends Triangle{
	
	public RightTriangle(double side) {
		super(side);
	}
	
	public double getPerimeter() {
		return (2 + Math.sqrt(2.0)) * super.getSide();
	}
	
	public double getArea() { 
		return super.getSide() * super.getSide() / 2;
	}
	
}