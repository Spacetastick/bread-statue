package deck;

public class Card {
	
	private String suit;
	private String rank;
	private int pointValue;

	public Card(String suit, String rank, int pointValue) {
		this.suit = suit;
		this.rank = rank;
		this.pointValue = pointValue;
		
	}

	public String suit() {
		return this.suit;
   }

	public String rank() {
		return this.rank;
	}

	public int pointValue() {
		return this.pointValue;
	}

	public boolean matches(Card otherCard) {
		if ((this.suit.equals(otherCard.suit)) && (this.rank.equals(otherCard.rank))) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override 
	public String toString() {
		return rank() + " of " + suit() + " (point value = [" + pointValue() + "])";
	}
}
