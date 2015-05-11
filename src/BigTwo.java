import java.util.ArrayList;


public class BigTwo {

		private Deck deck;
		private ArrayList<Player> players;
		private Player currentPlayer;
		
		public BigTwo(){
			deck = new Deck();
			players = new ArrayList<Player>();
		}
		
		// Starts game:
		// Shuffles deck
		// Creates players
		// Distribute cards among players
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
			    	Card c = deck.get(0);
			    	
			    	if (checkIfStartPlayer(c))
			    		currentPlayer = p;
			    		
			    	p.getCard(c); // Gets top card of the deck
			    }
			}
		}
		
		public boolean checkIfStartPlayer(Card c){
			return c.getSuit()==Card.suitType.DIAMOND && c.getRank()==Card.rankType.THREE;
		}
		
		public Player getPlayer(int i){
			return players.get(i);
		}
		
		// Print 
		public void printAllPlayersHands(){
			for (int i=0; i<players.size(); i++){
				System.out.println("Player "+(i+1));
				players.get(i).printHand();
			}
		}
		
}
