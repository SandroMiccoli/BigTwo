package GameStates;

import Game.BigTwo;

public class EndOfGameState implements GameState {

	@Override
	public void doAction(BigTwo game) {
		System.out.println("Game over!");
		System.out.println(game.getCurrentPlayer().getName()+" wins!");

	}

}
