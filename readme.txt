Instruction:

At the beginning, after the first deal, one of the randomly picked cards from the computer will be shown to the player.
The two cards the player get will be printed to the screen.
The player, as indicated by the prompted instruction, will need to indicate whether to stand or not.
If the player choose to get another card, and if the total score exceeds 21, the game ends automatically. The player loses.
If the player stands (and does it successfully), the a new round of dealing will start with the computer player.
The player doesn't have to type in anything since then.
If at a point the computer's score exceeds 21, the game ends. The player wins.
If the computer stands, both players' score will be printed and the comparison will be made.
Then the winner will be given.
Game ends here.





Explanation about design:

There are 6 classes all together.

The Card class is a basic class that will be used in other classes.
A card object has two parameters, the suit and the rank. There will be getters of the privates and a getter for the score of the card.
An Ace's initial score is set to be 1.

The Deck class is for for picking and shuffling cards.
When picking a card from the pool, a random number is generated to connect with the index of the pool ArrayList.
The chosen card is returned and removed from the pool.

The Player class represents a human player.
A player should have his/her own hand, and be able to return his/her own score with the discrete of all the Aces' score.
Also a player will be able to update and show his/her current hand.

The Computer class represents a computer dealer.
This class is similar to the human player class, just with one more responsibility: show one of the two cards it gets after the first deal.

The Game class implements the stages of the BlackJack game.
It has basic methods for implementing the game's framework.
The class has three private attributes: a computer dealer, a human player, and the deck.
It simulates the first deal.
It picks cards for the both kinds of players.
It has a method that mimics the "stand" action of the players.
It can get the total score of the players.
Finally, it has a method to end the game with conclusions of the result.

The game could be ended due to:
the human player's score exceeds 21;
the cPlayer's score exceeds 21;
both of the players choose to stand.

The BlackJack is the class that actually plays a game.
It takes input from the player and shows results to the player.




Explanation about changes:

At first, the Card class has a private boolean variable called flag.
The "flag" variable is to indicate whether to set the Ace's score to be 11 or not, if the player has one.
The human player has to indicate whether or not to choose each Ace's score to be 1. That is, every time the player's score is calculated, a boolean input is needed.
The Player and Computer classes both have a getter to get the hands of both of the players.

However, given a level-headed player who can do basic math, the total score of the current hand should be fixed.
The player just need to indicate whether to stand or not.
Indicator of the Ace's score is not necessary. The calculation process can be done within the getScore() function.

Also, the two classes for the players don't need a getter of the hand.
The Game class doesn't need to know the player's hand directly, for the players have already got a showHand() function to print out their hands.
The Game class just needs the total score of the players to implement methods representing each stage of the game.

A new attribute called "unavailable" is added to the Deck class just to give a clearer view of what the class is doing.
The newly added "unavailable" contains all the cards that are given to the players.
This private variable is just used in debugging.
