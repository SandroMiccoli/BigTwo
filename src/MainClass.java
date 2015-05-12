import java.util.ArrayList;


public class MainClass {

	public static void main(String[] args) {
			BigTwo game = new BigTwo();
			
			game.startGame();
			
			while (!game.gameOver()){
				game.request();
			}
			
	}

}
