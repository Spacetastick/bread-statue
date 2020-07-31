package miscellaneous;

public class DeckTester {
	
	static String[] ranks = Deck.rankList();
	static String[] suits = Deck.suitsList();
	static int[] values = Deck.valuesList();

	public static void main(String[] args) {
		Deck deck1 = new Deck(ranks, suits, values);
		for (int i = 0; i < 52; i++) {
			deck1.deal();
		}
		System.out.println("Size of deck 1 is: " + deck1.size());
		System.out.println("Is empty: " + deck1.isEmpty());
		Deck.reset();
		
		Deck deck2 = new Deck(ranks, suits, values);
		for (int i = 0; i < 30; i++) {
			deck2.deal();
		}
		System.out.println("Size of deck 2 is: " + deck2.size());
		System.out.println("Is empty: " + deck2.isEmpty());
		Deck.reset();
		
		Deck deck3 = new Deck(ranks, suits, values);
		for (int i = 0; i < 1; i++) {
			deck3.deal();
		}
		System.out.println("Size of deck 3 is: " + deck3.size());
		System.out.println("Is empty: " + deck3.isEmpty());
		Deck.reset();
	}
}
