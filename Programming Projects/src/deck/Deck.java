package deck;

import java.util.List;
import java.util.ArrayList;

public class Deck {
	
	static String[] ranks = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
	static String[] suits = {"Spades", "Hearts", "Diamonds", "Cloves"};
	static int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};

	
	//all cards in deck
	private static List<Card> cards = new ArrayList<Card>();

	//number of cards still in deck
	private static int size;

	//pairs each element in each array with corresponding values (to make individual cards)
	public Deck(String[] ranks, String[] suits, int[] values) {
		for (int i = 0; i < suits.length; i++) {
			for (int j = 0; j < ranks.length; j++) {
				Card card = new Card(suits[i], ranks[j], values[j]);
				cards.add(card);
			}
		}
		size = cards.size();
		
	}

	public boolean isEmpty() {
		if (size <= 0) {
			return true;
		}
		else {
			return false;
		}
	}

	public int size() {
		return size;
	}

	/**
	 * Randomly permute the given collection of cards
	 * and reset the size to represent the entire deck.
	 */
	public void shuffle() {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 4 *** */
	}

	/**
	 * Deals a card from this deck.
	 * @return the card just dealt, or null if all the cards have been
	 *         previously dealt.
	 */
	public Card deal() {
		if (size > 0) {
			size--;
			return cards.get(size);
		}
		else {
			return null;
		}
	}
	
	public static String[] rankList() {
		return ranks;
	}
	
	public static String[] suitsList() {
		return suits;
	}
	
	public static int[] valuesList() {
		return values;
	}
	
	public static void reset() {
		cards.clear();
	}

	@Override
	public String toString() {
		String rtn = "size = " + size + "\nUndealt cards: \n";

		for (int k = size - 1; k >= 0; k--) {
			rtn = rtn + cards.get(k);
			if (k != 0) {
				rtn = rtn + ", ";
			}
			if ((size - k) % 2 == 0) {
				// Insert carriage returns so entire deck is visible on console.
				rtn = rtn + "\n";
			}
		}

		rtn = rtn + "\nDealt cards: \n";
		for (int k = cards.size() - 1; k >= size; k--) {
			rtn = rtn + cards.get(k);
			if (k != size) {
				rtn = rtn + ", ";
			}
			if ((k - cards.size()) % 2 == 0) {
				// Insert carriage returns so entire deck is visible on console.
				rtn = rtn + "\n";
			}
		}

		rtn = rtn + "\n";
		return rtn;
	}
}

/* 
Answers to four questions:
1. The relationship between a deck and a card is that a card is a part of a deck,
and many cards make up one deck.
2. It contains six cards
3: 
	static String[] ranks = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
	static String[] suits = {"Spades", "Hearts", "Diamonds", "Cloves"};
	static int[] values = {11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
	
4. The order of the values in the arrays does matter to the extent that the elements in
the arrays need to line up correctly depending on their position in the array
(for example the Two of Spades should have its rank and point value in the same position,
in this case in position 1).

*/