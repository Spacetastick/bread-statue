package project6;

/*
 * Your TownGraphManager will hold an object of your Graph. There are methods to populate the graph (reading from a text file), add a town (vertices),
 * add a road (edge), list all towns and all roads, and list towns adjacent to a given town. 
 * 
 * Your solution wwill find the shortest path from a start town to a destination town. It will account for the possibility of a disjointed graph (i.e., not all
 * vertices can be reached from all other vertices). You may add any methods as needed for your design
 */

public class TownGraphManager implements TownGraphManagerInterface {

	//ACCOUNT FOR THE POSSIBILITY OF A DISJOINTED GRAPH (see notes)
	
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
		
	}
	
	@Override
	public Town getTown(String name) {
		
	}
	
	@Override
	public boolean containsTown(String v) {
		
	}
	
	@Override
	public boolean containsRoadConnection(String town1, String town2) {
		
	}
	
	@Override
	public ArrayList<String> allRoads() {
		
	}
	
	@Override
	public boolean deleteRoadConnection(String town1, String town2, String road) {
		
	}
	
	@Override
	public boolean deleteTown(String v) {
		
	}
	
	@Override
	public ArrayList<String> allTowns() {
		
	}
	
	@Override
	public ArrayList<String> getPath(String town1, String town2) {
		
	}
}
