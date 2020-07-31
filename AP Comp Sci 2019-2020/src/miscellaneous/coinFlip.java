package miscellaneous;

public class coinFlip {

	public static String flip() {
		int i = (int)(Math.random() * (4 -1) + 1);
		if (i == 1 || i == 2) {
			return "heads";
		}
		else {
			return "tails";
		}
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 50; i++) {
			System.out.println(flip());
		}
	}
	
}