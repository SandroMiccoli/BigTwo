package CardDeck;

public class Card {

	public static enum suitType{
		DIAMONDS, CLUBS, HEARTS, SPADES
	};
	
	public static enum rankType{
		ACE,
		TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN,
		JACK, QUEEN, KING	
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
	
}
