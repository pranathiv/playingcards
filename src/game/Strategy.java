package game;

import structures.Card;
import structures.Hand;

public abstract class Strategy {
	
	public abstract Card nextCard(Card onBid, Hand hand);

}
