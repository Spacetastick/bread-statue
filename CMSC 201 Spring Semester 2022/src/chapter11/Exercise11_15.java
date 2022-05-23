package chapter11;

import java.util.Scanner;

public class Exercise11_15 {

	private static int numPoints;
	private static double[] points;
	
	public static double convexPolygonArea() {
		double firstPart = points[points.length - 2] * points[1];
		double secondPart = points[0] * points[points.length-1];
		
		for (int n = 0; n < points.length-2; n += 2) {
			firstPart += points[n] * points[n+3];
		}
		
		for (int n = 1; n < points.length-1; n += 2) {
			secondPart += points[n] * points[n+1];
		}
		
		return Math.abs((firstPart - secondPart) / 2);
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the number of points: ");
		numPoints = input.nextInt();
		//*2 because each point will have 2 entries (an x and y coordinate)
		points = new double[numPoints*2];
		System.out.print("Enter the coordinates of the points: ");
		for (int i = 0; i < points.length; i++)
			points[i] = input.nextDouble();
		
		System.out.print("The total area is " + convexPolygonArea());
		
	}
	
}
