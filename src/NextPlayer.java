
public class NextPlayer implements GameState {

	@Override
	public void doAction(BigTwo game) {
		game.setGameRound(game.getGameRound()+1);
		game.setNextPlayer();
		game.setState(new waitCombinationState());
	}

}
