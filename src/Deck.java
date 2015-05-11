import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class Deck {
	
	private ArrayList<Card> cards;
	
	public Deck(){
		cards = new ArrayList<Card>();
		for (Card.suitType s : Card.suitType.values()){
			for (Card.rankType r : Card.rankType.values()){
				cards.add(new Card(r,s));
			}
		}
	}
	
	public void printAllCards(){
		System.out.println("Printing all cards...");
		for(Card c : cards){
			c.printCard();
		}
	}
	
	public void shuffle(){
		System.out.println("Shuffling the deck...");
		long seed = System.nanoTime();
		Collections.shuffle(cards, new Random(seed));
	}
	
	public Card get(int index){
		Card c = cards.get(index);
		cards.remove(index);
		return c;
		
	}

}
