package main;

import card.*;
import interfaces.*;
import player.*;

public class Main {
	public static void main(String[] args) {
		CardCollection deck = new Deck();
		deck.consumeJoker();

		BabanukiPlayer[] players = new BabanukiPlayer[] {
				new Com("Sawai"),
				new Com("Kengo"),
				new Com("Hisatsune"),
				new Com("Suzuki"),
				new Com("Tadokoro"),
				new Com("Mur"),
				new Com("Kmr"),
				new Com("Takuya")
		};

		Game babanuki = new Game(players);
		babanuki.readyToGame(deck);
		Player remainingPlayer = babanuki.doGame();
		System.out.println("Loser is "+ remainingPlayer + "!");

	}
}
