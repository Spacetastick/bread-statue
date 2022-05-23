package chapter9;

public class Exercise09_01 {

	static class Rectangle {
		private double width = 1;
		private double height = 1;
		
		Rectangle() {
			
		}
		
		Rectangle(double width, double height) {
			this.width = width;
			this.height = height;
		}
		
		public double getArea() {
			return this.width * this.height;
		}
		
		public double getPerimeter() {
			return (this.width * 2) + (this.height * 2);
		}
		
		
	}
	
	public static void main(String[] args) {
		Rectangle bruh = new Rectangle(4, 40);
		Rectangle moment = new Rectangle(3.5, 35.9);
		
		System.out.println("The area of a rectangle with width 4.0 and height 40.0 is " + bruh.getArea());
		System.out.println("The perimeter of this rectangle is " + bruh.getPerimeter());
		System.out.println("The area of a rectangle with width 3.5 and height 35.9 is " + moment.getArea());
		System.out.println("The perimeter of this rectangle is " + moment.getPerimeter());
	}
	
}