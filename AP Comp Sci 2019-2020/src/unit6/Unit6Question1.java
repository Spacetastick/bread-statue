package unit6;

public class Unit6Question1 {

	static String[] words = {"ten", "fading", "post", "card", "thunder", "hinge", "trailing", "batting"};
	
	public static void main(String[] args) {
		
		for (String word : words) {
			
			if (word.endsWith("ing")) {
				System.out.println(word);
			}
			
		}
		
	}
	
} 


/* alternatively: 

package randomWork;

public class Unit6Question1 {

	static String[] words = {"ten", "fading", "post", "card", "thunder", "hinge", "trailing", "batting"};
	
	public static void main(String[] args) {
		
		for (String word : words) {
			int length = word.length();
			String ing = word.substring(length-3, length);
			
			if (ing.equals("ing"))
				System.out.println(word);
			
			
		}
		
	}
	
}


*/