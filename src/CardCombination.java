import java.util.ArrayList;


public class CardCombination {
	
	private ArrayList<Card> combination;
	
	public static enum combinationType{
		SINGLE,
		PAIR,
		TRIPLE,
		FIVECARD
	}

	public CardCombination(ArrayList<Card> c){
		combination = c;
	}
	
	public boolean checkCombination(){

		ArrayList<Card.rankType> ranks = new ArrayList<Card.rankType>();
		ArrayList<Card.suitType> suits = new ArrayList<Card.suitType>();
		for (Card c : combination){
			ranks.add(c.getRank());
			suits.add(c.getSuit());
		}
		System.out.println("Ranks and suits...");
		System.out.println(ranks);
		System.out.println(suits);
		
		
		if (combination.size()==1){
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
		else
			return false;
	}
	
	private boolean checkTwoCards(){
		if (combination.get(0).getRank()==combination.get(1).getRank())
			return true;
		else
			return false;
	}
	
	private boolean checkThreeCards(){
		if (combination.get(0).getRank()==combination.get(1).getRank() &&
			combination.get(1).getRank()==combination.get(2).getRank())
			return true;
		else
			return false;
	}
	
	private boolean checkFiveCards(){
		// todo
		return true;
		
		//return false;
	}
}
