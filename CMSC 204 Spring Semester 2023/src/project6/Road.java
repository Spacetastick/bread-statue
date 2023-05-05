package project6;

/*
 * Create a class Road that can represent the edges of a Graph of Towns. The class stores references to the two vertices (Town endpoints),
 * the distance between vertices, and a name, and the traditional methods (constructors, getters/setters, toString, etc), and a compareTo,
 * which compares two Road objects. Since this is an undirected graph, an edge from A to B is equal to an edge from B to A.
 */
public class Road implements Comparable<Road> {

	public Road(Town source, Town destination, int degrees, String name) {
		//constructor
	}
	
	public Road(Town source, Town destination, String name) {
		//constructor with weight preset at 1
	}
	
	public boolean contains(Town town) {
		//returns true only if the edge is connected to the given vertex
	}
	
	@Override
	public String toString() {
		
	}
	
	public String getName() {
		//returns the road name
	}
	
	public Town getDestination() {
		//returns the second town on the road
	}
	
	public Town getSource() {
		//returns the first town on the road
	}
	
	@Override
	public int compareTo(Road o) {
		//returns 0 if the road names are the same, a positive or negative number if the road names are not the same
	}
	
	public int getWeight() {
		//returns the distance of the road
	}
	
	@Override
	public boolean equals(Object r) {
		//returns true if each of the ends of the road r is the same as the ends of this road. 
		//Remember that a road that goes from point A to B is the same as a road that goes from point B to A
	}
	
}
