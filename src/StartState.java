
public class StartState implements GameState {

	@Override
	public void doAction(BigTwo game) {
		System.out.println(game.getCurrentPlayer().getName()+"'s plays first.");

		game.setState(new waitCombinationState());	
	}
	
	public String toString(){
		return "Start State";
	}

}