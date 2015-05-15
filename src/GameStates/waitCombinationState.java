package GameStates;
import Game.BigTwo;

public class waitCombinationState implements GameState {

	@Override
	public void doAction(BigTwo game) {
		
		
		System.out.println("Waiting for "+game.getCurrentPlayer().getName()+"'s action...");
		
		if (game.isFirstRound()){
			game.setState(new ListStartRoundActionsState());
			game.request();
			game.isFirstRound(false);
		}
		else {
			game.setState(new NextPlayerState());
			game.setState(new ListActionsState());
			game.request();
		}
		
		//game.lowestHand=0; // Only for testing... 
	}

}
