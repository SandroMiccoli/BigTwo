import java.util.ArrayList;


public class BigTwo {

		private Deck deck;
		private ArrayList<Player> players;
		private Player currentPlayer;
		private CardCombination currentCombination;
		private GameState state;
		
		private int gameRound=0;
		
		public int lowestHand=13;
		
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
			this.setState(new StartState());
		}
		
		// Creates four players
		private void createPlayers(){
			System.out.println("Creating players...");
			for (int i=0; i<4; i++){
				players.add(new Player("Player "+(i+1)));
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
			return c.getSuit()==Card.suitType.DIAMONDS && c.getRank()==Card.rankType.THREE;
		}
		
		public Player getPlayer(int i){
			return players.get(i);
		}
		
		public Player getCurrentPlayer(){
			return this.currentPlayer;
		}
		
		// Print 
		public void printAllPlayersHands(){
			for (int i=0; i<players.size(); i++){
				System.out.println(players.get(i).getName());
				players.get(i).printHand();
			}
		}
		
		public void setState(GameState state){
			this.state = state;
		}
		
		public GameState getState(){
			return this.state;
		}
		
		public void request(){
			this.state.doAction(this);
		}
		
		public boolean gameOver(){
			if (lowestHand==0){
				System.out.println("Game over!");
				return true;
			}
			else
				return false;
		}

		public int getGameRound() {
			return gameRound;
		}

		public void setGameRound(int gameRound) {
			this.gameRound = gameRound;
		}
		
		public boolean isFirstRound(){
			return this.gameRound==0;
		}
}
