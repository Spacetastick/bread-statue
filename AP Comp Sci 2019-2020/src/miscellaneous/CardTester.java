package miscellaneous;

public class CardTester {

	public static void main(String[] args) {
		Card aceOfSpades = new Card("Spades", "Ace", 1);
		System.out.println(aceOfSpades.suit());
		System.out.println(aceOfSpades.rank());
		System.out.println(aceOfSpades.pointValue());
		System.out.println(aceOfSpades);
		System.out.println();
		
		Card eightOfHearts = new Card("Hearts", "Eight", 8);
		System.out.println(eightOfHearts.suit());
		System.out.println(eightOfHearts.rank());
		System.out.println(eightOfHearts.pointValue());
		System.out.println(eightOfHearts);
		System.out.println();
		
		Card queenOfDiamonds = new Card("Diamonds", "Queen", 10);
		System.out.println(queenOfDiamonds.suit());
		System.out.println(queenOfDiamonds.rank());
		System.out.println(queenOfDiamonds.pointValue());
		System.out.println(queenOfDiamonds);
		System.out.println();
		
		
	}
}
