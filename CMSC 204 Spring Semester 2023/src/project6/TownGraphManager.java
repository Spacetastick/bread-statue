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
	
	public boolean addRoad(String town1, String town2, int weight, String roadName) {
		
	}
	
	public String getRoad(String town1, String town2) {
		
	}
	
	public boolean addTown(String v) {
		
	}
	
	public Town getTown(String name) {
		
	}
	
	public boolean containsTown(String v) {
		
	}
	
	public boolean containsRoadConnection(String town1, String town2) {
		
	}
	
	public ArrayList<String> allRoads() {
		
	}
	
	public boolean deleteRoadConnection(String town1, String town2, String road) {
		
	}
	
	public boolean deleteTown(String v) {
		
	}
	
	public ArrayList<String> allTowns() {
		
	}
	
	public ArrayList<String> getPath(String town1, String town2) {
		
	}
}
