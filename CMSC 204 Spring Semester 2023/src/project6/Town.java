package project6;

import java.util.ArrayList;

/*.
 * Create a Town class that holds the name of the town and a list of adjacent towns, and other fields as desired, and the traditional methods (constructors,
 * getters/setters, toString, etc).
 * Two towns will be considered the same if their name is the same (for compare method).
 * 
 * Towns are vertices in graph terms
 */
public class Town implements Comparable<Town> {

	private String name;
	private ArrayList<Town> adjacentTowns = new ArrayList<>();
	
	public Town(String name) {
		//constructor
		this.name = name;
	}
	
	public Town(Town templateTown) {
		//copy constructor
		this.name = templateTown.name;
		//might need or want to copy the adjacentTowns list as well
	}
	
	public String getName() {
		//return the town's name
		return this.name;
	}
	
	//not provided in javadoc
	public  void setName(String name) {
		//sets name of town
		this.name = name;
	}
	
	//not provided in javadoc
	public ArrayList<Town> getAdjacentTowns() {
		//return the town's adjacencies
		return this.adjacentTowns;
	}
	
	//not provided in javadoc
	public void setAdjacentTowns(ArrayList<Town> list) {
		//sets the town's adjacencies‍
		this.adjacentTowns = list;
	}
	
	@Override
	public int compareTo(Town o) {
		//compare to method
		//returns 0 if names are equal, a positive or negative number if the names are not equal
		return this.name.compareTo(o.name);
		
	}
	
	@Override
	public String toString() {
		//to string method
		//returns the town name
		return this.name;
	}
	
	@Override
	public int hashCode() {
		//returns the hashcode for the name of the town
		int result = 17;
		result = 31 * result + name.hashCode();
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		//returns true if the town names are equal, false if not
		if (this.getClass() != obj.getClass())
			return false;
		
		return this.name.equals(((Town)obj).name);
	}
	
}
