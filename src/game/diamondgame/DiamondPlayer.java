package game.diamondgame;

import game.Player;
import game.Strategy;
import structures.Card;
import structures.Hand;

public class DiamondPlayer extends Player {
	int points;
	Strategy strategy;
	
	public DiamondPlayer(Hand hand, String name) {
		this.hand = hand;
		this.points = 0;
		this.name = name;
	}
	
	public DiamondPlayer(Hand hand, String name, Strategy strategy) {
		this(hand, name);
		this.strategy = strategy;
	}
		
	public Card bid(Card onBid) {
		return this.strategy.nextCard(onBid, hand);
	}
	
	public void remove(Card card) {
		this.hand.removeCard(card);
	}
	
	public void updatePoints(int points) {
		this.points += points;
	}
	
	public int getPoints() {
		return this.points;
	}
	
	public void setStrategy(Strategy s) {
		this.strategy = s;
	}
	
	public String toString() {
		return this.name;
	}
}
