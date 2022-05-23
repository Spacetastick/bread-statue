package chapter9;

public class Exercise09_09 {

	static class RegularPolygon {
		private int n = 3;
		private double side = 1;
		private double x = 0;
		private double y = 0;
		
		RegularPolygon() {
			
		}
		RegularPolygon(int numSides, double sideLength) {
			this.n = numSides;
			this.side = sideLength;
		}
		RegularPolygon(int numSides, double sideLength, double x, double y) {
			this.n = numSides;
			this.side = sideLength;
			this.x = x;
			this.y = y;
		}
		
		public int getN() {
			return this.n;
		}
		public double getSide() {
			return this.side;
		}
		public double getX() {
			return this.x;
		}
		public double getY() {
			return this.y;
		}
		
		public void setN(int num) {
			this.n = num;
		}
		public void setSide(double num) {
			this.side = num;
		}
		public void setX(double num) {
			this.x = num;
		}
		public void setY(double num) {
			this.y = num;
		}
		
		public double getPerimeter() {
			return this.side * this.n;
		}
		public double getArea() {
			return n * ((this.side * this.side)) / (4 * Math.tan(Math.PI / n));
		}
	}
	
	public static void main(String[] args) {
		RegularPolygon hehe = new RegularPolygon();
		RegularPolygon he = new RegularPolygon(6, 4);
		RegularPolygon ha = new RegularPolygon(10, 4, 5.6, 7.8);
		
		int count = 1;
		RegularPolygon[] leastInsaneClashRoyalePlayer = {hehe, he, ha};
		for (RegularPolygon heheheha : leastInsaneClashRoyalePlayer) {
			System.out.println("Polygon " + count + " perimeter: " + heheheha.getPerimeter());
			System.out.println("Polygon " + count + " area: " + heheheha.getArea());
			count++;
		}
	}
	
}