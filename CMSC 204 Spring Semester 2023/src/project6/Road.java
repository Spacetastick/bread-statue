package project6;

/*
 * Create a class Road that can represent the edges of a Graph of Towns. The class stores references to the two vertices (Town endpoints),
 * the distance between vertices, and a name, and the traditional methods (constructors, getters/setters, toString, etc), and a compareTo,
 * which compares two Road objects. Since this is an undirected graph, an edge from A to B is equal to an edge from B to A.
 */
public class Road implements Comparable<Road> {

	private Town source;
	private Town destination;
	private int distance;
	private String name;
	
	public Road(Town source, Town destination, int distance, String name) {
		//constructor
		this.source = source;
		this.destination = destination;
		this.distance = distance;
		this.name = name;
	}
	
	public Road(Town source, Town destination, String name) {
		//constructor with weight preset at 1
		this.source = source;
		this.destination = destination;
		this.distance = 1;
		this.name = name;
	}
	
	public boolean contains(Town town) {
		//returns true only if the edge is connected to the given vertex
		if (source.equals(town) || destination.equals(town))
			return true;
		return false;
	}
	
	@Override
	public String toString() {
		//I assume this returns the name of the road, the javadoc didn't say
		//these tostring methods are also redundant which is kinda bruh
		return this.name;
	}
	
	public String getName() {
		//returns the road name
		return this.name;
	}
	
	//not provided by javadoc
	public void setName(String name) {
		//sets road name
		this.name = name;
	}
	
	public Town getDestination() {
		//returns the second town on the road
		return this.destination;
	}
	
	//not provided by javadoc
	public void setDestination(Town destination) {
		//sets second town on the road
		this.destination = destination;
	}
	
	public Town getSource() {
		//returns the first town on the road
		return this.source;
	}
	
	//not provided by javadoc
	public void setSource(Town source) {
		//sets first town on the road
		this.source = source;
	}
	
	public int getWeight() {
		//returns the distance of the road
		return this.distance;
	}
	
	//not provided by javadoc
	public void setWeight(int distance) {
		//sets the distance of the road
		this.distance = distance;
	}
	
	@Override
	public int compareTo(Road o) {
		//returns 0 if the road names are the same, a positive or negative number if the road names are not the same
		return this.name.compareTo(o.name);
	}
	
	@Override
	public boolean equals(Object r) {
		//returns true if each of the ends of the road r is the same as the ends of this road. 
		//Remember that a road that goes from point A to B is the same as a road that goes from point B to A
		if (this.getClass() != r.getClass())
			return false;
		
		Road input = (Road) r;
		if (this.source.equals(input.source) && this.destination.equals(input.destination))
			return true;
		if (this.source.equals(input.destination) && this.destination.equals(input.source))
			return true;
		return false;
		
	}
	
}
