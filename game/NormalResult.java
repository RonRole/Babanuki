package game;

import java.util.*;

import interfaces.*;

public class NormalResult<T extends Player> implements GameResult<T> {

	private List<T> winners = new ArrayList<>();
	private List<T> losers = new ArrayList<>();

 	@Override
	public void showWinners() {
		// TODO 自動生成されたメソッド・スタブ
 		System.out.println("Winners:" + winners);
	}

	@Override
	public void showLosers() {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("Losers:" + losers);
	}

	@Override
	public void memorizeWinners(T winner) {
		// TODO 自動生成されたメソッド・スタブ
		this.winners.add(winner);
	}

	@Override
	public void memorizeLosers(T loser) {
		// TODO 自動生成されたメソッド・スタブ
		this.losers.add(loser);
	}

}
