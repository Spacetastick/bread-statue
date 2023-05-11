package project6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

/*
 * Create a Graph class that implements the GraphInterface given to you. For Graph<V,E>, V is the vertex type (a Town), E is the edge type (a Road).
 * You will need to decide how to store the graph: use an adjacent matrix or an adjacency list.
 */
public class Graph implements GraphInterface<Town, Road> {
	
	private HashSet<Town> townSet;
	private HashSet<Road> roadSet;
	private HashMap<Town, ArrayList<Road>> adjList;
	private HashMap<Town, Object[]> shortestPathData;
	
	public Graph() {
		townSet = new HashSet<>();
		roadSet = new HashSet<>();
		adjList = new HashMap<>();
		shortestPathData = new HashMap<>();
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
		this.adjList.put(town, null);
		
		//adds input to townSet for live view requirement
		this.townSet.add(town);
		
		return true;
	}
	
	public boolean containsEdge(Town source, Town destination) {
		//basically the same thing as the getEdge method, but boolean instead of road
		Road temp = this.getEdge(source, destination);
		return temp == null ? false : true;
	}
	
	public boolean containsVertex(Town town) {
		//this is just the containsKey method since I am using a map implementation
		return this.adjList.containsKey(town);
	}
	
	public HashSet<Road> edgeSet() {
		return this.roadSet;
	}
	
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
		
		Road target = null; //to avoid concurrent modification exception
		for (Road road : sourceRoads) {
			if (road.getName().equals(roadName) && road.getWeight() == weight) {
				if (destinationRoads.contains(road)) {
					target = road;
				}
			}
		}
		
		//to avoid concurrent modification exception
		if (target != null) {
			sourceRoads.remove(target);
			destinationRoads.remove(target);
			
			//removing from roadSet for live view requirement
			this.roadSet.remove(target);
			
			return target;
		}
		
		return null;
	}
	
	//added overloaded method for removeEdge for the implementation of deleteRoadConnection in TGM
	public Road removeEdge(Town source, Town destination, String roadName) {
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
		
		Road target = null; //to avoid concurrent modification exception
		for (Road road : sourceRoads) {
			if (road.getName().equals(roadName)) {
				if (destinationRoads.contains(road)) {
					target = road;
				}
			}
		}
		
		//to avoid concurrent modification exception
		if (target != null) {
			sourceRoads.remove(target);
			destinationRoads.remove(target);
			
			//removing from roadSet for live view requirement
			this.roadSet.remove(target);
			
			return target;
		}
		
		return null;
	}
	
	public boolean removeVertex(Town town) {
		//check if graph contains input vertex
		if (!this.adjList.containsKey(town))
			return false;
		
		//removing all edges connected to vertex
		ArrayList<Road> townRoads = new ArrayList<>(this.adjList.get(town)); //to avoid concurrent modification
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
		
		//removing from townSet for live view requirement
		this.townSet.remove(town);
		
		return true;
	}
	
	public HashSet<Town> vertexSet() {
		return this.townSet;
	}
	
	//documentation says nothing about inputs being null or anything, so I assume there will not be any errors tested
	public ArrayList<String> shortestPath(Town source, Town destination) {
		ArrayList<String> path = new ArrayList<>();
		
		//populates shortestPathData with data for the current state of the graph
		this.dijkstraShortestPath(source);
		
		//edit to account for disjointed graph; if currentNeighbors is null it will have cleared shortestPathData
		//and ended the execution of the method, so we check to see if size of said hashmap is zero
		if (this.shortestPathData.size() == 0)
			return path;
		
		//adds strings to path in the provided format backwards, going from the destination to the source
		Town currentVertex = destination;
		while (currentVertex != source) {
			Object[] currentData = this.shortestPathData.get(currentVertex);
			path.add(currentData[1] + " via " + currentData[2] + " to " + currentVertex + " " + ((Road)currentData[2]).getWeight() + " mi");
			currentVertex = (Town)currentData[1]; //potential fix
		}
		
		//reverses the order of path so strings are in correct order
		Collections.reverse(path);
		
		return path;
	}
	
	public void dijkstraShortestPath(Town source) {
		//shortestPathData will be used to hold the three values needed per row of the data table for dijkstra.
		//The current vertex will be held as the key value. The int value for total road weight from the source will be held in index 0
		//of the size 3 object array, the previous vertex will be held in index 1 of the Object array, and the road between
		//the current and previous will be held in index 2.
		//basic overview of value storage for a key: {shortest distance from original source to key, previous vertex from key, road between key and previous vertex}
		
		//assumes that source does indeed exist in the graph
		ArrayList<Town> visited = new ArrayList<>();
		ArrayList<Town> unvisited = new ArrayList<>(this.adjList.keySet());
		
		//initial setup:
		//clears the hashmap so that correct data for the current state of the graph is reflected in it
		this.shortestPathData.clear();
		
		//adding all vertices to map with arbitrarily high weight value to be initially compared against
		for (Town town : unvisited) {
			Object[] data = {Integer.MAX_VALUE, null, null};
			this.shortestPathData.put(town, data);
		}
		
		//updating map entry for source vertex to contain 0 weight instead of MAX_VALUE
		Object[] sourceData = {0, null, null};
		this.shortestPathData.put(source, sourceData);
		
		//start of algorithm:
		Town currentVertex = source;
		while (unvisited.size() > 0) {
			
			//getting access to all neighbors of current vertex by accessing all connected edges
			ArrayList<Road> currentNeighbors = this.adjList.get(currentVertex);
			
			//edit to account for disjointed graph; the path cannot continue and should return empty arraylist
			//if currentNeighbors is null
			if (currentNeighbors == null) {
				this.shortestPathData.clear();
				return;
			}
			
			//looping like this to check all neighboring towns of current vertex
			for (Road road : currentNeighbors) {
				
				//here is where access to the neighboring towns is directly gained
				Town neighbor;
				if (road.getSource().equals(currentVertex))
					neighbor = road.getDestination();
				else
					neighbor = road.getSource();
				
				//only runs if the current neighbor is unvisited
				if (unvisited.contains(neighbor)) {
					//value is shortest distance from starting point stored in currentVertex + the weight of the current road to the neighbor
					int distanceFromSource = (int)this.shortestPathData.get(currentVertex)[0] + road.getWeight();
					
					//if this distance is less than the distance currently stored in the neighbor town as shortest distance from starting point,
					//then the neighbor's data will be updated to contain the new shortest distance and previous vertex
					if (distanceFromSource < (int)this.shortestPathData.get(neighbor)[0]) {
						Object[] newData = {distanceFromSource, currentVertex, road};
						this.shortestPathData.put(neighbor, newData);
					}
				}
					
			}
			
			//the visit of the current vertex has now been completed, so it will be added to visited and removed from unvisited
			visited.add(currentVertex);
			unvisited.remove(currentVertex);
			
			//makes current vertex the unvisited Town that is the shortest distance away from the original starting point
			//only runs when unvisited contains at least one vertex in order to avoid index out of bounds error
			if (unvisited.size() > 0) {
				Town nextCurrent = unvisited.get(0);
				for (Town town : unvisited) {
					if ((int)this.shortestPathData.get(town)[0] < (int)this.shortestPathData.get(nextCurrent)[0])
						nextCurrent = town;
				}
				currentVertex = nextCurrent;
			}

		}
		
	}
	
}