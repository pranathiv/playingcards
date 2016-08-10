package game.diamondgame;

import java.util.Scanner;

import game.Strategy;
import structures.Card;
import structures.Hand;

public class UserStrategy extends Strategy {
	
	public Card nextCard(Card onBid, Hand hand) {
		System.out.println("The card on bid is: " + onBid);
		System.out.println("The cards in your hand are\n" + hand);
		System.out.println("Choose the card you want to bid: ");
		Scanner in = new Scanner(System.in);
		int input = in.nextInt();
		return hand.draw(input);
	}

}
