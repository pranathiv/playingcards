package game;

import java.util.ArrayList;
import java.util.List;

import structures.Deck;
import structures.Hand;

public class Poker extends Game {
	
	Hand table;
	List<Hand> players;
	Deck deck;
	
	public Poker(int n) {
		deck = new Deck(1, 0);
		deck.shuffle();
		table = new Hand(deck.deal(5));
		deal(n);
	}
	
	public void deal(int n) {
		players = new ArrayList<Hand>();
		for (int i=0; i<n; i++) {
			players.add(new Hand(deck.deal(2)));
		}
	}
	
	@Override
	public int evaluate() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String toString() {
		String s = "Table: " + table + "\n"; 
		String[] playerNames = {"Abhishek", "Anusha", "Ashish", "Nisarg"};
		for (int i=0; i<players.size(); i++) {
			s += playerNames[i] + ": " + players.get(i) + "\n";
		}
		return s;
	}
	
	public static void main(String[] args) {
		Poker game = new Poker(4);
		System.out.println(game);
	}
}
