package hw3;

import java.util.Scanner;

/*
 * This class actually plays a game.
 */
public class BlackJack {

	public static void main(String[] args) {
		// Creates a new game.
		Game game=new Game();
		game.firstDeal();
		Scanner in = new Scanner(System.in);
		boolean flag=true; // Indicates whether to end the loop for dealing with a player or not.
		boolean end=false; // Indicates whether to end the game or not.
		
		/*
		 *  First deal with the human player. The player can input whether he/she wants to continue or not.
		 *  At a point where the player's score exceeds 21, the game ends.
		 */
		
		while(flag && (!end)) {
			System.out.println("Please indicate if you want to get one more card. 1 for true, 2 for false.");
			if(in.nextInt()==1) {
				game.hPlayerStands(false);
				game.hPlayerGetCard();
			}
			else {
				game.hPlayerStands(true);
				flag=false;
			}
			
			if(game.getHPlayerScore()>21) {
				game.endGame(true, false, false);
				flag=true;
				end=true;
			}
		}
		
		/*
		 *  Then we can deal with the computer player now. Since its strategy is fixed, no input is needed.
		 *  Similarly, at a point where the player's score exceeds 21, the game ends.
		 */
		
		flag=true;
		while(flag && (!end)) {
			if(!game.cPlayerStands()) {
				game.cPlayerGetCard();
			}
			else {
				flag=false;
			}
			if(game.getCPlayerScore()>21) {
				game.endGame(false, true, false);
				flag=true;
				end=true;
			}
		}
		
		// If both of the players stand and no one's score exceeds 21, the game ends here with a comparison to determine who is the winner.
		if(!end) {
			game.endGame(false, false, true);
		}
		in.close();
	}

}
