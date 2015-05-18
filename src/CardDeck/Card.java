package CardDeck;

public class Card {

	public static enum suitType{
		DIAMONDS, CLUBS, HEARTS, SPADES 
	};
	
	public static enum rankType{
		THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN,
		JACK, QUEEN, KING,
		ACE,
		TWO
	}
	
	private rankType rank; // Card rank. From 1 to 13, with 1=A, 11=J, 12=Q e 13=K.
	private suitType suit;
	
	public Card(rankType r, suitType s){
		this.rank = r;
		this.suit = s;
	}
	
	public void printCard(){
		System.out.println(this.rank+" of "+this.suit);
	}
	
	public rankType getRank(){
		return this.rank;
	}
	
	public suitType getSuit(){
		return this.suit;
	}
	
	// Compare instance with another card.
	// Returns:
	// false if this is lower then that OR
	// true if this is higher then that
	public boolean compare(Card that){
		if (this.rank.ordinal() < that.rank.ordinal())
			return false;
		else if (this.rank.ordinal() > that.rank.ordinal())
			return true;
		else if (this.rank.ordinal() == that.rank.ordinal()){
			if (this.suit.ordinal() < that.suit.ordinal())
				return false;
			else if (this.suit.ordinal() > that.suit.ordinal())
				return true;
		}
		return false;
	}
	
}
