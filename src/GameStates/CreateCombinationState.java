package GameStates;
import java.util.ArrayList;
import java.util.Scanner;

import CardDeck.Card;
import CardDeck.CardCombination;
import Game.BigTwo;


public class CreateCombinationState implements GameState {
	
	private ArrayList<Card> hand;
	private CardCombination combination;
	
	private int sizeOfComb=0;
	
	private boolean playCombination = false;

	@Override
	public void doAction(BigTwo game) {
		hand = game.getCurrentPlayer().getHand();
		
		while(!playCombination){
			System.out.println("Choices of cards...");
			listHand(game);
			if (game.getCurrentCombination() != null){
				sizeOfComb=game.getCurrentCombination().getCards().size();
				game.printCurrentCombination();
				System.out.println("You can only create a combination with "+sizeOfComb+" cards: ");
			}
			else{
				if(!setSizeOfCombination()){

					if (game.isFirstRound())
						game.setState(new ListStartRoundActionsState());
					else
						game.setState(new ListActionsState());
					break;
				}
			}

			if(isValidSize()){
				if(!createCombination()){

					if (game.isFirstRound())
						game.setState(new ListStartRoundActionsState());
					else
						game.setState(new ListActionsState());
					break;
				};
				combination.print();
				checkCombination(game);
			}
		}
		
		if (playCombination){
			if (game.getGameTurn()!=0 && game.getCurrentCombination()!=null){
				if(combination.isHigherThan(game.getCurrentCombination())){
					playCombination(game);
				}
				else{
					System.out.println("Your game is inferior then the game on the table. Try again...");
					playCombination=false;
					game.setState(new ListActionsState());
				}
			}
			else{
				playCombination(game);
			}

			
		}
		
	}
	
	public void listHand(BigTwo game){
		for (int i=0; i< hand.size(); i++){
			System.out.print("[ "+(i+1)+" ] ");
			hand.get(i).printCard();
		}
	}
	
	public void playCombination(BigTwo game){
		// Remove cards from player's hand
		removeCombinationFromHand(game);
		game.getCurrentPlayer().printHand();
		if (game.getCurrentPlayer().getHand().size() < game.getLowestHand())
			game.updateLowestHand(game.getCurrentPlayer());
		// Update current combination
		game.setCurrentCombination(combination);			
		// Update current player -> state NextPlayer
		game.setState(new NextPlayerState());
		// Sets first round if this player 
		if(game.getCurrentPlayer()==game.getOwnerOfLastCombination()){
			game.resetRound();	
		}
		else
		{
			game.isFirstRound(false);
		}
		// Sets player that made the play
		game.setOwnerOfLastCombination(game.getCurrentPlayer());		
	}
	
	public boolean createCombination(){
		Scanner dd = new Scanner(System.in);
		int[] vars = new int[sizeOfComb];
		int temp=0;
		ArrayList<Card> tempHand = new ArrayList<Card>();
		
		for(int i = 0; i < vars.length; i++) {
		  System.out.println("Enter next card: ");
		  while (!dd.hasNextInt()) {
			   System.out.println("Only numbers, please.");
			   dd.nextLine();
			   return false;
			}
		  temp = dd.nextInt()-1;
		  if (temp<0 || temp>hand.size()){
			  System.out.println("Card not available, please choose again.");
			  i--;
		  }
		  else{
			  vars[i] = temp;
			  tempHand.add(hand.get(temp));
		  }
		}
	
		combination = new CardCombination(tempHand);
		return true;
	
	}
	
	public boolean setSizeOfCombination(){
		while (!isValidSize()){
			System.out.println("How many cards will you combination have? (1, 2, 3 or 5)");
			System.out.println("(press any letter to go back to actions)");
			Scanner scanner = new Scanner(System.in);
			while (!scanner.hasNextInt()) {
				   System.out.println("Only numbers, please.");
				   scanner.nextLine();
				   return false;
				}
			sizeOfComb = scanner.nextInt();
			if (!isValidSize()){
				System.out.println("Amount not valid. Please choose again.");
			}
			else
				return true;
		}
		return false;
	}
	
	public boolean confirmCombination(){

		Scanner dd = new Scanner(System.in);
		boolean submit=false;
		System.out.println("Play this combination? (y/n)");
		String yn = dd.next();
		// print combination
		if(yn.equals("y"))
			submit=true;
		else if(yn.equals("n")){
			sizeOfComb = 0;
			System.out.println("Choose another card combination...");
			submit=false;
		}
		else{
			sizeOfComb = 0;
			System.out.println("Invalid option.");
			submit=false;
		}
		
		return submit;
	}
	
	public void checkCombination(BigTwo game){
		if (game.isFirstRound()&&game.getGameTurn()==0){
			if (!combination.checkFirsCombination()){
				System.out.println("Combination not valid, please try again.");
				clearVariables();
			}
			else
				playCombination = confirmCombination();
		}
		else {
			if (!combination.checkCombination()){
				System.out.println("Combination not valid, please try again.");
				clearVariables();
			}
			else
				playCombination = confirmCombination();
		}
	}
	
	public void removeCombinationFromHand(BigTwo game){
		for (Card c : combination.getCards()){
			game.getCurrentPlayer().removeCard(c);
		}
	}
	
	private boolean isValidSize(){
		return (sizeOfComb==1 || sizeOfComb==2 || sizeOfComb==3 || sizeOfComb==5);
	}
	
	private void clearVariables(){
		sizeOfComb = 0;
		combination.clear();
		
	}

}
