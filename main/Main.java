package main;

import card.*;
import game.*;
import interfaces.*;
import player.*;

public class Main {
	public static void main(String[] args) {
		CardCollection deck = new Deck();
		Card joker = new Joker();
		deck.consumeCard(joker);

		BabanukiPlayer[] players = new BabanukiPlayer[] {
				new Com("Sawai"),
				new Com("Kengo"),
				new Com("Hisatsune"),
				new Com("Suzuki"),
				new Com("Tadokoro"),
				new Com("Mur"),
				new Com("Kmr"),
				new Com("Takuya"),
				new Com("Ren"),
				new Com("Hide"),
				new Com("Hirano")
		};

		BabanukiGame babanuki = new BabanukiGame(players);
		babanuki.readyToGame(deck);
		GameResult<BabanukiPlayer> result = babanuki.doGame();
		result.showLosers();
		result.showWinners();

	}
}
