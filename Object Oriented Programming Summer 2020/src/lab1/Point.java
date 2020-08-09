package lab1;

/**
 * The Point class represents a location in 2D Euclidean space. This class 
 * definition is a stub designed to be completed by the students of 
 * Poolesville High School and then submitted. 
 * 
 * TODO Students should update this class definition.
 * 
 * @author TODO Another name should be here
 * @author Ishan Khetarpal
 * @author Marty Stepp
 * @author Will Beebe
 * @version %I%, %G%
 *
 */
public class Point {
	
	private int x;
	private int y;
	
	/**
	 * Constructs a new <code>Point</code> object with the given coordinates. 
	 * 
	 * @param x The x-coordinate.
	 * @param y The y-coordinate.
	 */
	public Point(int x, int y) {
		this.x = x;
		this.y = y;	
	}
	
	/**
	 * Returns which quadrant of the xy-plane this <code>Point</code> object
	 * falls in. Quadrant 1 contains all points whose x and y values are both
	 * positive. Quadrant 2 contains all points with negative x but positive y.
	 * Quadrant 3 contains all points with negative x and y values. Quadrant
	 * 4 contains all points with positive x but negative y. If the point lies
	 * directly on the x- and/or y- axis, return 0.
	 * @return The quadrant that the point is in.
	 */
	public int quadrantPoint() {
	  if (this.x > 0 && this.y > 0)
	    return 1;
    else if (this.x < 0 && this.y > 0)
      return 2;
    else if (this.x < 0 && this.y < 0)
      return 3;
    else if (this.x > 0 && this.y < 0)
      return 4;
    return 0;
	}
	
	/**
	 * Negates and swaps the xy-coordinates of the <code>Point</code> object.
	 * For example, if the object initially represents the point (5, -3),.
	 * after a call to <code>flip</code>, the object should represent (3, -5).
	 * If the object initially represents the point (4, 17), after a call to
	 * <code>flip</code>, the object should represent (-17, -4). 
	 */
	public void flip() {
	  int temp = this.x*-1;
	  this.x = this.y*-1;
	  this.y = temp;
	}
	
	/**
	 * Returns the "Manhattan distance" between the current <code>Point<code>
	 * object and the given other <code>Point</code> object. The Manhattan
	 * distance refers to how far apart two places are if the person can only
	 * travel straight horizontally or vertically, as though driving on the
	 * streets of Manhattan. In our case, the Manhattan distance is the sum of
	 * the absolute values of the differences in their coordinates; in other
	 * words, the difference in x plus the difference in y between the points. 
	 * @param other The other point.
	 * @return The Manhattan distance between the points.
	 */
	public int manhattanDistance(Point other) {
	  return Math.abs(this.x - other.x) + Math.abs(this.y - other.y);
	}
	
	/**
	 * Returns <code>true</code> f the given <code>Point</code> lines up
	 * vertically with this <code>Point</code>; that is, if their x-coordinates
	 * are the same.
	 * @param other The other point.
	 * @return Whether or not the two points are vertical.
	 */
	public boolean isVertical(Point other) {
	  if (this.x == other.x)
	    return true;
    return false;
	}
	
	/**
	 * Returns the slope of the line drawn between this <code>Point</code>
	 * and the given other <code>Point</code>. Use the formula (y2-y1)/(x2-x1)
	 * to determine the slope between two points (x1, y1) and (x2, y2). Note
	 * that this formula fails for points with identical x-coordinates, so
	 * throw an <code>IllegalArgumentException</code> in this case.
	 * @param other The other point
	 * @return The slope between the point
	 * @throws IllegalArgumentException
	 */
	public double slope(Point other) {
		if(other.x == this.x) {
			throw new IllegalArgumentException("Infinite Slope");
		}
		return (double)(other.y - this.y) / (other.x - this.x);
	}
}