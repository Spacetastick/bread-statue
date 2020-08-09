//Lab 2: Triangle from the 2020 Poolesville HS summer enrichment program
package lab2;

public class Main {

	public static void main(String[] args) {
		Triangle equilateralTr = new EquilateralTriangle(12);
	    Triangle rightTr = new RightTriangle(12);
	    System.out.println("Equilateral " + equilateralTr.getRatio());
	    System.out.println("Right isosceles " + rightTr.getRatio());
	}
	
}