
public class waitCombinationState implements GameState {

	@Override
	public void doAction(BigTwo game) {
		System.out.println("Waiting for "+game.getCurrentPlayer().getName()+"'s action...");
		
		game.getCurrentPlayer().setState(new ListActions());
		game.getCurrentPlayer().request();
		
		game.lowestHand=0; // Only for testing... 
	}

}
