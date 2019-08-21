package main;

import java.util.*;
import java.util.stream.*;

import card.*;
import interfaces.*;

public class Game {
	private List<BabanukiPlayer> players = new ArrayList<>();
	private CardCollection deck;

	public Game(BabanukiPlayer... players) {
		Stream.of(players).forEach(this.players::add);
	}

	public void readyToGame(CardCollection deck) {
		this.deck = deck;
		players.forEach(player -> {
			player.setUseHand(new BabanukiHand());
		});
		while(!this.deck.isEmpty()) {
			players.forEach(player -> {
				player.drawFrom(this.deck);
			});
		}
		players.forEach(BabanukiPlayer::putPairs);
		players.forEach(BabanukiPlayer::sortHand);
		System.out.println("GameStart!");
		this.showPlayers();
	}

	public Player doGame() {
		int playerSize = players.size();
		if(playerSize == 0) {
			return null;
		}
		if (playerSize == 1) {
			return players.get(0);
		}
		players.forEach(player -> {
			System.out.println("turn:" + player);
			BabanukiPlayer beforePlayer = this.getBeforePlayer(player);
			player.drawFrom(beforePlayer);
			showPlayers();
			player.putPairs();
		});
		players.removeIf(Player::isOverGame);
		return doGame();
	}

	private void showPlayers() {
		players.stream().map(Player::showHand).forEach(System.out::println);
		System.out.println("");
	}

	private BabanukiPlayer getBeforePlayer(BabanukiPlayer player) {
		List<BabanukiPlayer> onGamePlayers = players.stream().filter(Player::isContinueable).collect(Collectors.toList());
		int indexOfThisPlayer = onGamePlayers.indexOf(player);
		int indexOfBeforePlayer = indexOfThisPlayer == 0 ? onGamePlayers.size() - 1 : indexOfThisPlayer - 1;
		return indexOfBeforePlayer < 0 ? player : onGamePlayers.get(indexOfBeforePlayer);
	}
}
