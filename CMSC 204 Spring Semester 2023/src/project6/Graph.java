package project6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/*
 * Create a Graph class that implements the GraphInterface given to you. For Graph<V,E>, V is the vertex type (a Town), E is the edge type (a Road).
 * You will need to decide how to store the graph: use an adjacent matrix or an adjacency list.
 */
public class Graph implements GraphInterface<Town, Road> {

	/*
	 * Within the Graph interface is a method shortestPath, which finds the shortest path from a given source Town toa destination Town.
	 * Since there is a unique shorterst path from every vertex to the source, there is a back-pointer to the previous vertex. The method
	 * shortestPath calls dijkstraShortestPath which finds the shortest path form the source to every other vertex in the graph.
	 * You will be coding the Dijkstra's Shortest Path algorithm. You will then be able to find the connections between two towns through the roads that connect them.
	 * 
	 * You may use the adjacency matrix approach found in the text book, or you may use a set of Towns and a set of Roads. The ShortestPath algorithm typiclaly
	 * uses a weighted graph which means that the edges have a weight, and this is used to determine the shortest path. For this implementation, each weight wwill
	 * be the distance of the road in miles.
	 */
	
	private ArrayList<Town> towns; //may not need this
	private HashMap<Town, ArrayList<Road>> adjList;
	
	public Graph() {
		towns = new ArrayList<>(); //may not need this
		adjList = new HashMap<>();
	}
	
	public Road getEdge(Town source, Town destination) {
		//check if both vertices exist in graph
		if (!this.adjList.containsKey(source) || !this.adjList.containsKey(destination))
			return null;
		
		//check if they share a road
		ArrayList<Road> sourceRoads = this.adjList.get(source);
		ArrayList<Road> destinationRoads = this.adjList.get(destination);
		if (sourceRoads == null || destinationRoads == null)
			return null;
		
		for (Road road : sourceRoads) {
			if (destinationRoads.contains(road))
				return road;
		}
		return null;
	}
	
	public Road addEdge(Town source, Town destination, int weight, String roadName) throws IllegalArgumentException {
		
	}
	
	public boolean addVertex(Town town) {
		
	}
	
	public boolean containsEdge(Town source, Town destination) {
		
	}
	
	public boolean containsVertex(Town town) {
		
	}
	
	//may be a hash set, which I might want to import instead, although I don't know if the implementation will still work if I change to hash set
	public Set<Road> edgeSet() {
		
	}
	
	public Set<Road> edgesOf(Town town) {
		
	}
	
	public Road removeEdge(Town source, Town destination, int weight, String roadName) {
		
	}
	
	public boolean removeVertex(Town town) {
		
	}
	
	public Set<Town> vertexSet() {
		
	}
	
	public ArrayList<String> shortestPath(Town source, Town destination) {
		
	}
	
	//should this be public?
	public void dijkstraShortestPath(Town source) {
		
	}
	
}
