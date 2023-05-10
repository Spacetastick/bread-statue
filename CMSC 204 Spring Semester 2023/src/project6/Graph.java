package project6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

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
	
	private HashSet<Town> townSet;
	private HashSet<Road> roadSet;
	private HashMap<Town, ArrayList<Road>> adjList;
	
	public Graph() {
		townSet = new HashSet<>();
		roadSet = new HashSet<>();
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
	
	public Road addEdge(Town source, Town destination, int weight, String roadName) throws IllegalArgumentException, NullPointerException {
		//the javadoc entry for this method implies that there are one or more sets of circumstances where it would return null,
		//but since any type of edge connection is acceptable in this graph implementation I don't see how that would ever happen 🤷‍♂️
		
		//checking if vertices are null
		if (source == null || destination == null)
			throw new NullPointerException();
		
		//checking if both vertices exist in graph
		if (!this.adjList.containsKey(source) || !this.adjList.containsKey(destination))
			throw new IllegalArgumentException();
		
		//making new edge and adding it to the lists of both keys
		Road edge = new Road(source, destination, weight, roadName);
		
		//either adds the new edge to an already existing value (arraylist) for both vertices, or creates
		//a new arraylist and adds the edge to it.
		this.adjList.computeIfAbsent(source, key -> new ArrayList<Road>()).add(edge);
		this.adjList.computeIfAbsent(destination, key -> new ArrayList<Road>()).add(edge);
		
		//adding edge to roadSet for the live view requirement
		this.roadSet.add(edge);
		
		return edge;
	}
	
	public boolean addVertex(Town town) throws NullPointerException {
		//checks if input is null
		if (town == null)
			throw new NullPointerException();
		
		//checks if input is already in graph
		if (this.adjList.containsKey(town))
			return false;
		
		//adds input to graph
		this.adjList.put(town, null); //this might create problems, idk
		
		//adds input to townSet for live view requirement
		this.townSet.add(town);
		
		return true;
	}
	
	public boolean containsEdge(Town source, Town destination) {
		//basically the same thing as the getEdge method, but boolean instead of road
		Road temp = this.getEdge(source, destination);
		if (temp == null)
			return false;
		return true;
	}
	
	public boolean containsVertex(Town town) {
		//this is just the containsKey method since I am using a map implementation
		return this.adjList.containsKey(town);
	}
	
	public HashSet<Road> edgeSet() {
		return this.roadSet;
	}
	
	//the instructions for this method do not say the set must be backed by the graph, so I will not implement it that way.
	//putting this comment here in case the instructions are wrong and this causes problems
	public HashSet<Road> edgesOf(Town town) throws IllegalArgumentException, NullPointerException {
		//checking if input is null
		if (town == null)
			throw new NullPointerException();
		
		//checking if input exists in graph
		if (!this.adjList.containsKey(town))
			throw new IllegalArgumentException();
		
		//creating new hashset using the hashset constructor that accepts a collection type (namely the arraylist used for storing roads connceted
		//to the input vertex) and returning it
		return new HashSet<Road>(this.adjList.get(town));
	}
	
	public Road removeEdge(Town source, Town destination, int weight, String roadName) {
		//checking if weight is valid (>= 1)
		if (weight < 1)
			return null;
		
		//checking if roadName is valid (not null)
		if (roadName == null)
			return null;
		
		//check if both vertices exist in graph
		if (!this.adjList.containsKey(source) || !this.adjList.containsKey(destination))
			return null;
		
		//check if the provided edge connects the provided vertices
		ArrayList<Road> sourceRoads = this.adjList.get(source);
		ArrayList<Road> destinationRoads = this.adjList.get(destination);
		if (sourceRoads == null || destinationRoads == null)
			return null;
		
		for (Road road : sourceRoads) {
			if (road.getName().equals(roadName) && road.getWeight() == weight) {
				if (destinationRoads.contains(road)) {
					sourceRoads.remove(road);
					destinationRoads.remove(road);
					
					//removing from roadSet for live view requirement
					this.roadSet.remove(road);
					
					return road;
				}
			}
		}
		return null;
	}
	
	//these methods may not be implemented correctly because the input object is not necessarily the same as what is contained in the graph I think
	//if the add and remove methods and others that have the formal u.equals(v) definition don't work, this is why
	public boolean removeVertex(Town town) {
		//check if graph contains input vertex
		if (!this.adjList.containsKey(town))
			return false;
		
		//removing all edges connected to vertex
		ArrayList<Road> townRoads = this.adjList.get(town);
		//following if may not be necessary
		if (townRoads != null) {
			for (Road road : townRoads) {
				//check road info to see if town is source or destination and handle accordingly
				if (road.getSource().equals(town))
					this.removeEdge(town, road.getDestination(), road.getWeight(), road.getName());
				else
					this.removeEdge(road.getSource(), town, road.getWeight(), road.getName());
			}
		}
		
		//removing vertex
		this.adjList.remove(town);
		
		return true;
	}
	
	public HashSet<Town> vertexSet() {
		return this.townSet;
	}
	
	public ArrayList<String> shortestPath(Town source, Town destination) {
		
	}
	
	//should this be public?
	public void dijkstraShortestPath(Town source) {
		
	}
	
}
