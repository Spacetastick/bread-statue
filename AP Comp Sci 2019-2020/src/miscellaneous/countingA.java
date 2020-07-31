package miscellaneous;

public class countingA {
	
	public static void main(String[] args) {
		
		String testString = "Guadalajarah";
		int num = 0;
		
		for (int i = testString.length(); i > 0; i--) {
			if (testString.substring(i-1, i).equals("a"))
				num++;
		}
		
		System.out.println("Number of a's = " + num);
		
	}

}
