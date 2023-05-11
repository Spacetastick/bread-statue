package project6;

import java.util.ArrayList;
import java.util.Collections;

/*
 * Your TownGraphManager will hold an object of your Graph. There are methods to populate the graph (reading from a text file), add a town (vertices),
 * add a road (edge), list all towns and all roads, and list towns adjacent to a given town. 
 * 
 * Your solution wwill find the shortest path from a start town to a destination town. It will account for the possibility of a disjointed graph (i.e., not all
 * vertices can be reached from all other vertices). You may add any methods as needed for your design
 */

public class TownGraphManager implements TownGraphManagerInterface {
	
	private Graph graph;
	
	public TownGraphManager() {
		this.graph = new Graph();
	}
	
	@Override
	public boolean addRoad(String town1, String town2, int weight, String roadName) {
		graph.addEdge(new Town(town1), new Town(town2), weight, roadName);
		return true;
	}
	
	@Override
	public String getRoad(String town1, String town2) {
		 Road road = graph.getEdge(new Town(town1), new Town(town2));
		 return road != null ? road.getName() : null;
	}
	
	@Override
	public boolean addTown(String v) {
		return graph.addVertex(new Town(v));
	}
	
	@Override
	public Town getTown(String name) {
        for (Town town : graph.vertexSet()) {
            if (town.getName().equals(name)) {
                return town;
            }
        }
        return null;
	}
	
	@Override
	public boolean containsTown(String v) {
		return this.getTown(v) != null ? true : false;
	}
	
	@Override
	public boolean containsRoadConnection(String town1, String town2) {
        return graph.containsEdge(new Town(town1), new Town(town2));
	}
	
	@Override
	public ArrayList<String> allRoads() {
		ArrayList<String> roads = new ArrayList<>();
		
		for (Road road : graph.edgeSet())
			roads.add(road.getName());
		
		Collections.sort(roads);
		
		return roads;
	}
	
	@Override
	public boolean deleteRoadConnection(String town1, String town2, String road) {
        return graph.removeEdge(new Town(town1), new Town(town2), road) != null ? true : false;
	}
	
	@Override
	public boolean deleteTown(String v) {
        return graph.removeVertex(new Town(v));
	}
	
	@Override
	public ArrayList<String> allTowns() {
		ArrayList<String> towns = new ArrayList<>();
		
		for (Town town : graph.vertexSet())
			towns.add(town.getName());
		
		Collections.sort(towns);
		
		return towns;
	}
	
	//the documentation for this says "null if the towns have no path to connect them", but the previous
	//implementation of shortestPath did not have this concern so it's probably fine
	@Override
	public ArrayList<String> getPath(String town1, String town2) {
        return graph.shortestPath(new Town(town1), new Town(town2));
	}
	
}
