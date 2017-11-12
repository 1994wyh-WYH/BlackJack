package hw3;

import java.util.ArrayList;
import java.util.Random;

/*
 * This class represents the computer.
 */
public class Computer {
	private ArrayList<Card> hand; // The current hand the computer player has.
	
	//This is the constructor of the computer player given two initial cards.
	public Computer(Card c1, Card c2) {
		hand=new ArrayList<Card>();
		hand.add(c1);
		hand.add(c2);
	}
	
	// This method updates the computer player's hand after picking a new card.
	public void updateHand(Card c) {
		System.out.println("The dealer's newly added card is: "+c.getSuit()+" "+c.getRank()+".");
		hand.add(c);
	}
	
	// This method shows one of the two cards of the dealer after the first deal.
	public void showfirstHand() {
		Random r=new Random();
		int index=r.nextInt(2);
		System.out.println("One of the two cards the dealer got is: "+hand.get(index).getSuit()+" "+hand.get(index).getRank()+".");
	}
	
	// This method prints out all of the computer player's hand.
	public void showAllHand() {
		int p=1;
		for(Card c : hand) {
			System.out.println("The "+p+" card is "+c.getSuit()+" "+c.getRank()+".");
			p++;
		}
	}
	
	// This method returns the total score of the dealer, with an Ace score optimizes the dealer's chance of winning.
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
	
	
}
