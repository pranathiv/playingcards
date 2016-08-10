package structures;

import java.util.ArrayList;
import java.util.List;

public class Pack {
	public List<Card> cards;
	
	public Pack(int j) {
		this.cards = generate();
		this.cards.addAll(jokers(j));
	}
	
	public List<Card> generate() {
		List<Card> cards = new ArrayList<Card>();
		for (int i=Card.SPADES; i<=Card.DIAMONDS; i++) {
			cards.addAll(generate(i));
		}
		return cards;
	}
	
	public List<Card> generate(int suit) {
		List<Card> cards = new ArrayList<Card>();
		for (int face = Card.ACE; face <= Card.KING; face++) {
			cards.add(new Card(suit, face));
		}
		return cards;
	}
	
	public List<Card> jokers(int n) {
		List<Card> cards = new ArrayList<Card>();
		for (int i=0; i<n; i++) {
			cards.add(new Card(Card.JOKER, Card.JOKER));
		}
		return cards;
	}
}
