package GameStates;
import java.util.Scanner;

import Game.BigTwo;


public class ListActionsState implements GameState {
	
	@Override
	public void doAction(BigTwo game) {
		
		System.out.println(game.getCurrentPlayer().getName()+" choose your action:");

		listActions();

		int action = waitingForInput();
		
		game.setState(nextState(action, game));
		
	}
	
	public int waitingForInput(){
		Scanner scanner = new Scanner(System.in);
		int input=-1;
		
		while(input==-1){
			System.out.println("Selection your action...");
			input = scanner.nextInt();
		}
		
		return input;
	}
	
	public void listActions(){
		System.out.println("1) Sort hand by suit");
		System.out.println("2) Sort hand by rank");
		System.out.println("3) Create combination of cards");
		System.out.println("4) Pass");
	}
	
	public GameState nextState(int action, BigTwo game){

		switch(action){
			case 1:
				System.out.println("Sorting hand by suit...");
				game.getCurrentPlayer().sortHandBySuit();
				game.getCurrentPlayer().printHand();
				return new ListActionsState();
			case 2:
				System.out.println("Sorting hand by rank...");
				game.getCurrentPlayer().sortHandByRank();
				game.getCurrentPlayer().printHand();
				return new ListActionsState();
			case 3:
				return new CreateCombinationState();
			case 4:
				return new NextPlayerState();
			default:
				System.out.println("Invalid option...");
				return new ListActionsState();
		}
		
	}

}
