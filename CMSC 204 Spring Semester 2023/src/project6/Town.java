package project6;

/*.
 * Create a Town class that holds the name of the town and a list of adjacent towns, and other fields as desired, and the traditional methods (constructors,
 * getters/setters, toString, etc).
 * Two towns will be considered the same if their name is the same (for compare method).
 * 
 * Towns are vertices in graph terms
 */
public class Town implements Comparable<Town> {

	public Town(String name) {
		//constructor
	}
	
	public Town(Town templateTown) {
		//copy constructor
	}
	
	public String getName() {
		//return the town's name
	}
	
	@Override
	public int compareTo(Town o) {
		//compare to method
		//returns 0 if names are equal, a positive or negative number if the names are not equal
	}
	
	@Override
	public String toString() {
		//to string method
		//returns the town name
	}
	
	@Override
	public int hashCode() {
		//returns the hashcode for the name of the town
	}
	
	@Override
	public boolean equals(Object obj) {
		//returns true if the town names are equal, false if not
	}
	
}
