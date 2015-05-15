package CardDeck;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class CardCombination {

	public static enum combinationType{
		SINGLE,
		PAIR,
		TRIPLE,
		STRAIGHT,
		FLUSH,
		FULLHOUSE,
		FOUR,
		STRAIGHTFLUSH,
		NOTVALID;
		
		@Override
		  public String toString() {
		    switch(this) {
		      case SINGLE: return "Single";
		      case PAIR: return "Pair";
		      case TRIPLE: return "Triple";
		      case STRAIGHT: return "Straight";
		      case FLUSH: return "Flush";
		      case FULLHOUSE: return "Full House";
		      case FOUR: return "Four";
		      case STRAIGHTFLUSH: return "Straight Flush";
		      case NOTVALID: return "Not valid";
		      
		      default: throw new IllegalArgumentException();
		    }
		  }
	}
	
	private ArrayList<Card> combination;
	
	private combinationType type = combinationType.NOTVALID;
	
	private Card highestCard;

	public CardCombination(ArrayList<Card> c){
		combination = c;
		setHighestCard();
		checkCombination();
	}
	
	public void setHighestCard(){
		sortBySuit();
		sortByRank();
		highestCard = combination.get(combination.size()-1);
	}
	
	public Card getHighestCard(){
		return highestCard;
	}
	
	public String getType(){
		return type.toString();
	}
	
	public void print(){
		System.out.println(type.toString());
		for (Card c : combination){
			c.printCard();
		}
	}
	
	public void clear(){
		combination.clear();
		type=null;
	}
	
	public boolean checkCombination(){		
		if (combination.size()==1){
			this.type = combinationType.SINGLE;
			return true;
		}
		else if (combination.size()==2){
			return checkTwoCards();
		}
		else if(combination.size()==3){
			return checkThreeCards();
		}
		else if(combination.size()==5){
			return checkFiveCards(); 
		}
		else{
			this.type = combinationType.NOTVALID;
			return false;
		}
	}
	
	private boolean checkTwoCards(){
		if (combination.get(0).getRank() == combination.get(1).getRank()){
			this.type = combinationType.PAIR;
			return true;
		}
		else
			return false;
	}
	
	private boolean checkThreeCards(){
		if (combination.get(0).getRank() == combination.get(1).getRank() &&
			combination.get(1).getRank() == combination.get(2).getRank()){
			this.type = combinationType.TRIPLE;
			return true;
		}
		else
			return false;
	}
	
	private boolean checkFiveCards(){

		if (checkStraight()){
			this.type = combinationType.STRAIGHT;
			return true;
		}
		else if (checkFlush()){
			this.type = combinationType.FLUSH;
			return true;
		}
		else if (checkFullHouse()){
			this.type = combinationType.FULLHOUSE;
			return true;
		}
		else if (checkFour()){
			this.type = combinationType.FOUR;
			return true;
		}
		else if (checkStraight() && checkFlush()){
			this.type = combinationType.STRAIGHTFLUSH;
			return true;
		}
		else
			return false;
	}
	
	private boolean checkStraight(){
		sortByRank();
		boolean isStraight=true;
		ArrayList<Card.rankType> ranks = new ArrayList<Card.rankType>();
		
		for (Card c : combination){
			ranks.add(c.getRank());
		}
		
		for (int i = 0; i<ranks.size()-1; i++){
			if(ranks.get(i).ordinal() == ranks.get(i+1).ordinal()-1)
				isStraight = true;
			else{
				isStraight = false;
				break;
			}
		}
		
		
		return isStraight;
	}
	
	private boolean checkFlush(){
		
		ArrayList<Card.suitType> suits = new ArrayList<Card.suitType>();

		for (Card c : combination){
			suits.add(c.getSuit());
		}
		
		int freq = Collections.frequency(suits, suits.get(0));
		
		if (freq==5)
			return true;
		else
			return false;
	}
	
	private boolean checkFullHouse(){

		sortByRank();
		
		boolean isFull=false;
		
		ArrayList<Card.rankType> ranks = new ArrayList<Card.rankType>();
		
		for (Card c : combination){
			ranks.add(c.getRank());
		}

		int freqFirst = Collections.frequency(ranks, ranks.get(0));
		int freqLast = Collections.frequency(ranks, ranks.get(4));
		
		if ( (freqFirst==3 && freqLast==2) || (freqFirst==2 && freqLast==3) )
			isFull = true;
		else
			isFull = false;	
		
		return isFull;
	}
	
	private boolean checkFour(){
		sortByRank();
		
		boolean isFour=false;
		
		ArrayList<Card.rankType> ranks = new ArrayList<Card.rankType>();
		
		for (Card c : combination){
			ranks.add(c.getRank());
		}

		int freqFirst = Collections.frequency(ranks, ranks.get(0));
		int freqLast = Collections.frequency(ranks, ranks.get(4));
		
		if ( (freqFirst==4 && freqLast==1) || (freqFirst==1 && freqLast==4) )
			isFour = true;
		else
			isFour = false;	
		
		return isFour;
	}
	
	private boolean checkThreeOfDiamonds(){
		for (Card c : combination){
			if(c.getRank()==Card.rankType.THREE && c.getSuit()==Card.suitType.DIAMONDS)
				return true;
		}
		return false;
		
	}	
	
	public boolean checkFirsCombination(){
		return checkCombination() && checkThreeOfDiamonds();
	}
	
	public ArrayList<Card> getCards(){
		return combination;
	}
	
	private void sortByRank(){
		Collections.sort(combination, new Comparator<Card>() {
	        @Override
			public int compare(Card c1, Card c2){
	            return  c1.getRank().compareTo(c2.getRank());
	        }
	    });
	}

	public void sortBySuit(){
		Collections.sort(combination, new Comparator<Card>() {
	        @Override
			public int compare(Card c1, Card c2){
	            return  c1.getSuit().compareTo(c2.getSuit());
	        }
	    });
	}

	// Compare instance with another card.
	// Returns:
	// false if this is lower then that OR
	// true if this is higher then that
	public boolean isHigherThan(CardCombination that){
		if (this.type.ordinal() < that.type.ordinal())
			return false;
		else if (this.type.ordinal() > that.type.ordinal())
			return true;
		else{
		// SINGLE, PAIR, TRIPLE, STRAIGHT, FLUSH, STRAIGHT FLUSH
		return this.getHighestCard().compare(that.getHighestCard());
		// FOUR and FULLHOUSE // Just set the highest card
		}

	}
}
