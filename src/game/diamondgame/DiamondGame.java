package game.diamondgame;

import java.util.ArrayList;
import java.util.List;

import game.Game;
import game.Player;
import game.Strategy;
import structures.Card;
import structures.Deck;
import structures.Hand;

public class DiamondGame extends Game {
	
	private Hand table;
	private List<DiamondPlayer> players;
	private Deck deck;
	
	public DiamondGame() {
		this.deck = new Deck();
		this.players = new ArrayList<DiamondPlayer>();
		createPlayers();
		table = new Hand(deck.getAndRemoveSuit(Card.DIAMONDS));
		table.shuffle();
	}
	
	private void createPlayers() {
		Strategy[] strategies = {new UserStrategy(), new RandomStrategy()};
		
		for (int i=Card.SPADES; i<Card.CLUBS; i++) {
			Hand playerHand = new Hand(deck.getAndRemoveSuit(i));
			DiamondPlayer player = new DiamondPlayer(playerHand, Player.playerNames[i]);
			player.setStrategy(strategies[i]);
			players.add(player);
		}
	}
	
	public DiamondPlayer play() {
		while (table.size() > 0) {
			Card onBid = table.draw();
			List<Card> bidCards = new ArrayList<Card>();
			
			for (int i=0; i<players.size(); i++) {
				bidCards.add(players.get(i).bid(onBid));
			}
			
			System.out.println("You bid: " + bidCards.get(0));
			System.out.println("The computer bid: " + bidCards.get(1));
		
			int roundWinner = winRound(bidCards);
			System.out.println("Round Winner: " + Player.playerNames[roundWinner]);
			
			players.get(roundWinner).updatePoints(onBid.getFace());
			
			System.out.println("Points tally\n" + players.get(0).points + " " + players.get(1).points + "\n");
		}
		return winner();
	}
	
	private DiamondPlayer winner() {
		DiamondPlayer overallWinner = null;
		int maxPoints = 0;
		for (DiamondPlayer p : this.players) {
			if (p.points > maxPoints) {
				maxPoints = p.points;
				overallWinner = p;
			}
		}
		return overallWinner;
	}
	
	private int winRound(List<Card> bidCards) {
		int winner = 0;
		int points = bidCards.get(0).getFace();
		for (int i=0; i<bidCards.size(); i++) {
			if (bidCards.get(i).getFace() > points) {
				winner = i;
				points = bidCards.get(i).getFace();
			}
		}
		return winner;
	}

	@Override
	public int evaluate() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public static void main(String[] args) {
		DiamondGame dg = new DiamondGame();
		DiamondPlayer winner = dg.play();
		System.out.println(winner);
	}
}
