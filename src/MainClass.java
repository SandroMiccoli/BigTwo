import java.util.ArrayList;


public class MainClass {

	public static void main(String[] args) {
			BigTwo game = new BigTwo();
			game.startGame();
			game.printAllPlayersHands();
			for (int i=0; i<10; i++){
				ArrayList<Card> hand = game.getPlayer(0).randomHand();
				System.out.println(hand);
				CardCombination c = new CardCombination(hand);
				System.out.println(c.checkCombination());
			}
			
	}

}
