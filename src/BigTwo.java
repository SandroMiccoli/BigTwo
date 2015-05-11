import java.util.ArrayList;


public class BigTwo {

		private Deck deck;
		private ArrayList<Player> players;
		
		public BigTwo(){
			deck = new Deck();
			players = new ArrayList<Player>();
		}
		
		// Starts game
		public void startGame(){
			System.out.println("Starting game...");
			this.shuffleDeck();
			this.createPlayers();
			this.distributeCards();
		}
		
		// Creates four players
		private void createPlayers(){
			System.out.println("Creating players...");
			for (int i=0; i<4; i++){
				players.add(new Player());
			}
		}
		
		// Shuffles the deck
		private void shuffleDeck(){
			deck.shuffle();
		}
		
		// Gives 13 cards to each player
		private void distributeCards(){
			System.out.println("Distributing cards...");
			for (Player p : players){
			    for (int i=0; i<13; i++){
			    	p.getCard(deck.get(0)); // Gets top card of the deck
			    }
			}
		}
		
		public void printAllPlayersCards(){
			for (int i=0; i<players.size(); i++){
				System.out.println("Player "+(i+1));
				players.get(i).printHand();
			}
		}
		
}
