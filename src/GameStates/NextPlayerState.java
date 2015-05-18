package GameStates;
import Game.BigTwo;

public class NextPlayerState implements GameState {

	@Override
	public void doAction(BigTwo game) {
		System.out.println("--------------------------------");
		if(!game.gameOver()){
			game.setGameTurn(game.getGameTurn()+1);
			game.setNextPlayer();
			if (game.getCurrentPlayer()==game.getOwnerOfLastCombination())
				game.resetRound();
			game.setState(new WaitCombinationState());
		}
		else
			game.setState(new EndOfGameState());
	}

}
