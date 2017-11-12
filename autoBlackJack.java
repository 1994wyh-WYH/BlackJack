package hw3;

import java.util.Scanner;

public class autoBlackJack {
	
	public static int play() {
		// Creates a new game.
		autoGame game=new autoGame();
		int ret=0;
		Scanner in = new Scanner(System.in);
		boolean flag=true; // Indicates whether to end the loop for dealing with a player or not.
		boolean end=false; // Indicates whether to end the game or not.
		
		/*
		 *  First deal with the human player. The player can input whether he/she wants to continue or not.
		 *  At a point where the player's score exceeds 21, the game ends.
		 */
		
		while(flag && (!end)) {
			
			if(!game.aPlayerStands()) {
				
				game.aPlayerGetCard();
			}
			else {
				
				flag=false;
			}
			
			if(game.getAPlayerScore()>21) {
				ret=game.endGame(true, false, false);
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
				ret=game.endGame(false, true, false);
				flag=true;
				end=true;
			}
		}
		
		// If both of the players stand and no one's score exceeds 21, the game ends here with a comparison to determine who is the winner.
		if(!end) {
			ret=game.endGame(false, false, true);
		}
		in.close();
		
		return ret;
	

}
	
	public static void main(String[] args) {
		int c=1000;
		int autoWin=0;
		int cWin=0;
		while(c!=0) {
			int t=play();
			if(t==1) {
				autoWin++;
			}
			else if(t==-1) {
				cWin++;
			}
			else {
				continue;
			}
			c--;
		}
		System.out.println(autoWin);
		System.out.println(cWin);
	}
}
