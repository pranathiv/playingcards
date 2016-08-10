package game.diamondgame;

import game.Strategy;
import structures.Card;
import structures.Hand;

public class RandomStrategy extends Strategy{
	
	public Card nextCard(Card onBid, Hand hand) {
		hand.shuffle();
		return hand.draw();
	}
}
