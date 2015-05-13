import java.util.Scanner;


public class ListActions implements GameState {
	
	@Override
	public void doAction(BigTwo game) {
		
		System.out.println(game.getCurrentPlayer().getName()+" choose your action:");

		listActions();

		int action = waitingForInput();
		
		game.setState(nextState(action, game));
		
	}
	
	public int waitingForInput(){
		Scanner scanner = new Scanner(System.in);
		int input=0;
		
		while(input==0){
			System.out.println("Selection your action...");
			input = scanner.nextInt();
		}
		
		return input;
	}
	
	public void listActions(){
		System.out.println("1) Pass");
		System.out.println("2) Sort hand by suit");
		System.out.println("3) Sort hand by rank");
		System.out.println("4) Create combination of cards");
	}
	
	public GameState nextState(int action, BigTwo game){

		switch(action){
			case 1:
				return new NextPlayer();
			case 2:
				System.out.println("Sorting hand by suit...");
				game.getCurrentPlayer().sortHandBySuit();
				game.getCurrentPlayer().printHand();
				return new ListActions();
			case 3:
				System.out.println("Sorting hand by rank...");
				game.getCurrentPlayer().sortHandByRank();
				game.getCurrentPlayer().printHand();
				return new ListActions();
			case 4:
				return new CreateCombination();
			default:
				System.out.println("Invalid option...");
				return new ListActions();
		}
		
	}

}
