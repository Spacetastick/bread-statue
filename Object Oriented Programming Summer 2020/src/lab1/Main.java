//Lab 1: Point from the 2020 Poolesville HS summer enrichment program
package lab1;

public class Main {
	
	public static void main(String[] args) {
		Point a = new Point(-2, -2);
	    Point b = new Point(3, 3);
	    Point c = new Point(0, 1);
	    Point d = new Point(0, 5);
	    Point e = new Point(3, 2);
	    Point f = new Point(7, 6);
	    
	    System.out.println(a.manhattanDistance(b));
	    System.out.println(a.quadrantPoint());
	    System.out.println(c.quadrantPoint());
	    System.out.println(c.isVertical(d));
	    System.out.println(a.isVertical(b));
	    System.out.println(e.slope(f));
	}
	
}