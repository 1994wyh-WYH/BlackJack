package hw3;

import java.util.ArrayList;
import java.util.Random;

/* 
 * This class creates a Deck object for picking and shuffling cards.
 */
public class Deck {
	
	private ArrayList<Card> pool; // The pool where the computer picks a card randomly for the player or itself.
	private ArrayList<Card> unavailable; // The pool of the unavailable (given) cards.
	
	// This is the constructor of the Deck class.
	public Deck() {
		pool=new ArrayList<Card>();
		unavailable=new ArrayList<Card>();
		String[] suits= {"Spade", "Diamond", "Club", "Heart"};
		String[] ranks= {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
		for(String s:suits) {
			for (String r:ranks) {
				Card c=new Card(s,r);
				pool.add(0,c);
			}
		}
	}
	// This method picks a card from the pool and removes it from the pool, then add it to the unavailable pool. 
	public Card pickACard() {
		Random r=new Random();
		int pick=r.nextInt(pool.size());
		Card ret=pool.get(pick);
		unavailable.add(ret);
		pool.remove(pick);
		return ret;
	}
}
