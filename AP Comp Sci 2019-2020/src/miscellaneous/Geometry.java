package miscellaneous;

//Noah Cil

import java.util.Scanner;

public class Geometry {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("What is the value of height (h)?");
		double h = input.nextDouble();
		System.out.println("What is the value of radius (r)?");
		double r = input.nextDouble();
		input.close();
		
		Cube cube = new Cube(h);
		Sphere sphere = new Sphere(r);
		Cylinder cylinder = new Cylinder(r, h);
		Cone cone = new Cone(r, h);
		
		System.out.println("The volume of a cube with height " + h + " is: " + cube.Volume());
		System.out.println("The surface area of a cube with height " + h + " is: " + cube.Surface());
		System.out.println("The volume of a sphere with radius " + r + " is: " + sphere.Volume());
		System.out.println("The surface area of a sphere with radius " + r + " is: " + sphere.Surface());
		System.out.println("The volume of a cylinder with height " + h + " and radius " + r + " is: " + cylinder.Volume());
		System.out.println("The surface area of a cylinder with height " + h + " and radius " + r + " is: " + cylinder.Surface());
		System.out.println("The volume of a cone with height " + h + " and radius " + r + " is: " + cone.Volume());
		System.out.println("The surface area of a cone with height " + h + " and radius " + r + " is: " + cone.Surface());
	}
}
