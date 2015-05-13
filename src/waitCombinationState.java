
public class waitCombinationState implements GameState {

	@Override
	public void doAction(BigTwo game) {
		
		
		System.out.println("Waiting for "+game.getCurrentPlayer().getName()+"'s action...");
		
		if (game.isFirstRound()){
			game.setState(new ListStartGameActions());
			game.request();
		}
		else {
			game.setState(new NextPlayer());
			game.setState(new ListActions());
			game.request();
		}
		
		//game.lowestHand=0; // Only for testing... 
	}

}
