package GameStates;
import Game.BigTwo;

public class NextPlayerState implements GameState {

	@Override
	public void doAction(BigTwo game) {
		System.out.println("--------------------------------");
		game.setGameTurn(game.getGameTurn()+1);
		game.setNextPlayer();
		if (game.getCurrentPlayer()==game.getOwnerOfLastCombination())
			game.isFirstRound(true);
		game.setState(new waitCombinationState());
	}

}
