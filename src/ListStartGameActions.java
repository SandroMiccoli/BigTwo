
public class ListStartGameActions extends ListActions{
	
	@Override
	public void listActions(){
		System.out.println("1) Sort hand by suit");
		System.out.println("2) Sort hand by rank");
		System.out.println("3) Create combination of cards");
	}
	
	@Override
	public GameState nextState(int action, BigTwo game){

		switch(action){
			case 1:
				System.out.println("Sorting hand by suit...");
				game.getCurrentPlayer().sortHandBySuit();
				game.getCurrentPlayer().printHand();
				return new ListStartGameActions();
			case 2:
				System.out.println("Sorting hand by rank...");
				game.getCurrentPlayer().sortHandByRank();
				game.getCurrentPlayer().printHand();
				return new ListStartGameActions();
			case 3:
				return new CreateCombination();
			default:
				System.out.println("Invalid option...");
				return new ListActions();
		}
		
	}

}
