
public class waitCombinationState implements GameState {

	@Override
	public void doAction(BigTwo game) {
		System.out.println("Waiting for "+game.getCurrentPlayer().getName()+"'s combination of cards...");
		
		game.lowestHand=0; // Only for testing... 
	}

}
