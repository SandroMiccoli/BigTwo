package GameStates;
import Game.BigTwo;

public class NextPlayerState implements GameState {

	@Override
	public void doAction(BigTwo game) {
		game.setGameTurn(game.getGameTurn()+1);
		game.setNextPlayer();
		game.setState(new waitCombinationState());
	}

}
