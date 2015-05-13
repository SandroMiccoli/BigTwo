import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class Player {

	private ArrayList<Card> hand;
	private String name;
	
	public Player(String n){
		this.name = n;
		hand = new ArrayList<Card>();
	}
	
	public void getCard(Card c){
		if (hand.size() < 13)
			hand.add(c);
	}
	
	public String getName(){
		return name;
	}
	
	public void removeCard(Card c){
		if (hand.size()>0)
			hand.remove(c);
	}
	
	public void printHand(){
		System.out.println("Current hand...");
		for (Card c : hand){
			c.printCard();
		}
	}

	public void sortHandBySuit(){
		Collections.sort(hand, new Comparator<Card>() {
	        @Override
			public int compare(Card c1, Card c2){
	            return  c1.getSuit().compareTo(c2.getSuit());
	        }
	    });
	}
	
	public void sortHandByRank(){
		Collections.sort(hand, new Comparator<Card>() {
	        @Override
			public int compare(Card c1, Card c2){
	            return  c1.getRank().compareTo(c2.getRank());
	        }
	    });
	}
	
	public ArrayList<Card> randomHand(){
		int fromIndex = (int) (Math.random()*7);
		int toIndex = 1+fromIndex+(int) (Math.random()*5);
		
		return new ArrayList<Card>(hand.subList(fromIndex, toIndex));
	}
	
	public ArrayList<Card> getHand(){
		return this.hand;
	}
	
}
