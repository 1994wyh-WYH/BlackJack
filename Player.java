package hw3;

import java.util.ArrayList;
/*
 * This class represents a human player.
 */
public class Player {
	private ArrayList<Card> hand; // The current hand the player has.
	
	// This is the constructor of the player given two initial cards.
	public Player(Card c1, Card c2) {
		hand=new ArrayList<Card>();
		hand.add(c1);
		hand.add(c2);
		
	}
	
	// This method returns the total score of the player, with an Ace score optimizes the player's chance of winning.
	public int getScore() {
		int score=0;
		int aceCount=0;
		for(Card c:hand) {
			if((c.getRank()).equalsIgnoreCase("Ace")) {
				aceCount++;
				continue;
			}
			else{
				score+=c.getScore();
			}
		}
		
		int diff=21-score;
		if(diff<=0) {
			return score+1*aceCount;
		}
		
		for(int i=1;i<=aceCount;i++) {
			if(21-score-11>0) {
				score+=11;
			}
			else {
				score+=1;
			}
		}
		return score;
	}
	
	// This method prints out the player's hand.
	public void showHand() {
		int p=1;
		System.out.println("Here are the first two cards of yours.");
		for(Card c : hand) {
			System.out.println("The "+p+" card is: "+c.getSuit()+" "+c.getRank()+".");
			p++;
		}
	}
	
	// This method updates the player's hand after picking a new card.
	public void updateHand(Card c) {
		System.out.println("Your newly added card is: "+c.getSuit()+" "+c.getRank()+".");
		hand.add(c);
	}
}
