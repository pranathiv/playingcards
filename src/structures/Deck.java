package structures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author ashish
 *
 */
public class Deck {
	private List<Card> cards;
	
	public Deck(List<Card> cards) {
		this.cards = cards;
	}
	
	public Deck() {
		this.cards = new ArrayList<Card>();
	}
	
	public Deck(int number, int jokers) {
		this();
		this.add(new Pack(jokers));
		for (int i=1; i<number; i++) {
			this.add(new Pack(0));
		}
	}
	
	public boolean add(Card card) {
		return this.cards.add(card);
	}
	
	public boolean add(List<Card> cards) {
		return this.cards.addAll(cards);
	}
	
	public boolean add(Pack pack) {
		return add(pack.cards);
	}
	
	public boolean remove(Card card) {
		return this.cards.remove(card);
	}
	
	public boolean removeAll(Card card) {
		for (Card c : this.cards) {
			if (c.equals(card)) {
				this.cards.remove(c);
			}
		}
		return true;
	}
	
	public List<Card> get(int suit) {
		ArrayList<Card> cardsSuit = new ArrayList<Card>();
		for (Card c : this.cards) {
			if (c.getSuit() == suit) {
				cardsSuit.add(c);
				this.cards.remove(c);
			}
		}
		return cardsSuit;
	}
	
	public void shuffle() {
		Collections.shuffle(this.cards);
	}
	
	public List<Card> deal(int n) {
		ArrayList<Card> hand = new ArrayList<Card>();
		int count = 0;
		if (n > this.cardsLeft()) {
			return null;
		}
		while (count < n) {
			Card card = this.cards.get(0);
			hand.add(card);
			this.remove(card);
			count++;
		}
		return hand;
	}
	
	public int cardsLeft() {
		return this.cards.size();
	}
	
	public static void main(String[] args) {
		Deck deck = new Deck(2, 4);
		deck.shuffle();
		System.out.println(deck.deal(5));
	}
}
