package hw3;
/*
 * This class creates the Card object, which is a basic class that will be used in other classes.
 */
public class Card {
	// A card object has three attributes, the suit, the rank and the score.
	private String suit;
	private String rank;
	private int score;
	
	/*
	 * This is the constructor of the Card class.
	 * @param s is the suit.
	 * @param r is the rank.
	 * The score of Ace is set to be 1 initially.
	 */
	public Card(String s, String r) {
		suit=s;
		rank=r;
	
		if(rank.equalsIgnoreCase("Jack")||rank.equalsIgnoreCase("Queen")||rank.equalsIgnoreCase("King")||rank.equalsIgnoreCase("10")) {
			score=10;
		}
		else if(rank.equalsIgnoreCase("2")){
			score=2;
		}
		else if(rank.equalsIgnoreCase("3")) {
			score=3;
		}
		else if(rank.equalsIgnoreCase("4")) {
			score=4;
		}
		else if(rank.equalsIgnoreCase("5")) {
			score=5;
		}
		else if(rank.equalsIgnoreCase("6")){
			score=6;
		}
		else if(rank.equalsIgnoreCase("7")) {
			score=7;
		}
		else if(rank.equalsIgnoreCase("8")){
			score=8;
		}
		else if(rank.equalsIgnoreCase("9")) {
			score=9;
		}
		else {
			score=1;
			}
			
	}
	
	// This method is the getter of the score.
	public int getScore() {
		return score;
	}
	
	// This method is the getter of the suit.
	public String getSuit() {
		return suit;
	}
	
	// This method is the getter of the rank.
	public String getRank() {
		return rank;
	}

}
