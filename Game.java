package hw3;
/*
 * This class has basic methods for implementing the game's framework. The class has three private attributes: a computer dealer, a human player, and the deck.
 */
public class Game {
	private Computer cPlayer; // The computer player.
	private Player hPlayer; // The human player.
	private Deck deck; // The fresh deck for a new game.
	
	// This is the constructor of the class that initializes a computer player, a human player and a deck.
	public Game() {
		deck=new Deck();
		
		Card c1=deck.pickACard();
		Card c2=deck.pickACard();
		cPlayer=new Computer(c1,c2);
		
		Card c3=deck.pickACard();
		Card c4=deck.pickACard();
		hPlayer=new Player(c3,c4);
	}
	
	// This method simulate a first deal.
	public void firstDeal() {
		cPlayer.showfirstHand();
		hPlayer.showHand();
	}
	
	// This method picks a card for the dealer.
	public void cPlayerGetCard() {
		Card c=deck.pickACard();
		cPlayer.updateHand(c);
	}
	
	// This method picks a card for the human player.
	public void hPlayerGetCard() {
		Card c=deck.pickACard();
		hPlayer.updateHand(c);
	}
	
	// This method mimics the dealer's stand.
	public boolean cPlayerStands() {
		if(cPlayer.getScore()>=17) {
			System.out.println("The dealer chose to stand. The dealer's total score is: "+cPlayer.getScore()+".");
			return true;
		}
		else {
			System.out.println("The dealer chose to continue. The dealer will get a new card.");
			return false;
		}
	}
	
	// This method mimics the human player's stand.
	public void hPlayerStands(boolean stand) {
		if(stand) {
			System.out.println("You chose to stand. Your total score is: "+hPlayer.getScore()+".");
		}
		else {
			System.out.println("You chose to continue. You will get a new card.");
		}
	}
	
	// This method returns the total score of the computer player.
	public int getCPlayerScore() {
		return cPlayer.getScore();
	}
	// This method returns the total score of the human player.
	public int getHPlayerScore() {
		return hPlayer.getScore();
	}
	
	/*
	 *  This method ends the game with conclusions of the result.
	 *  @param hExceed, whether the dealing ends with the hPlayer's score exceeding 21.
	 *  @param cExceed, whether the dealing ends with the cPlayer's score exceeding 21.
	 *  @param stand, whether the dealing ends with both of the players standing.
	 */
	
	public void endGame(boolean hExceed, boolean cExceed, boolean stand) {
		int hScore=hPlayer.getScore();
		int cScore=cPlayer.getScore();
		if(hExceed) {
			System.out.println("Your total score is: "+hScore+". Your score has exceeded 21.");
			System.out.println("You lost the game. Game over.");
			return;
		}
		if(cExceed) {
			cPlayer.showAllHand();
			System.out.println("The dealer's total score is: "+cScore+". The dealer's score has exceeded 21.");
			System.out.println("You won the game.");
			return;
		}
		if(stand) {
			cPlayer.showAllHand();
			System.out.println("The dealer's total score is: "+cScore+".");
			System.out.println("Your total score is: "+hScore+".");
			// Compare the total score of the two players. If even, then there is no winner or loser.
			if(cScore>hScore) {
				System.out.println("You lost the game. Game over.");
			}
			else if(cScore<hScore) {
				System.out.println("You won the game.");
			}
			else {
				System.out.println("It's a tie!");
			}
			return;
		}
		// End of the game.
	}
	
}
