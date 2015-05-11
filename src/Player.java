import java.util.ArrayList;


public class Player {

	private ArrayList<Card> hand;
	
	public Player(){
		hand = new ArrayList<Card>();
	}
	
	public void getCard(Card c){
		if (hand.size() < 13)
			hand.add(c);
	}
	
	public void printHand(){
		System.out.println("Current hand...");
		for (Card c : hand){
			c.printCard();
		}
	}
}
