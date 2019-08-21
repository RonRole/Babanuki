package player;

import interfaces.*;

public final class Com implements BabanukiPlayer {

	protected String name;
	protected BabanukiHandMove hand;

	public Com(String name) {
		this.name = name;
	}

	@Override
	public void setUseHand(CardCollection hand) {
		if(hand instanceof BabanukiHandMove) {
			this.hand = (BabanukiHandMove) hand;
		}
		return;
	}

	@Override
	public void drawFrom(CardCollection cards) {
		// TODO 自動生成されたメソッド・スタブ
		if(cards.isEmpty()) {
			System.out.println(cards + "isEmpty!");
			return;
		}
		Card drawCard = cards.putCard();
		hand.consumeCard(drawCard);
	}

	@Override
	public void drawFrom(Player player) {
		if(player.isOverGame()) {
			System.out.println(player + "isEmpty!");
			return;
		}
		player.putTo(this.hand);
	}

	@Override
	public void putTo(CardCollection cards) {
		// TODO 自動生成されたメソッド・スタブ
		Card addCard = hand.putCard();
		cards.consumeCard(addCard);
	}

	@Override
	public String showHand() {
		// TODO 自動生成されたメソッド・スタブ
		return name + hand;
	}

	@Override
	public boolean isContinueable() {
		return !isOverGame();
	}

	@Override
	public String toString() {
		return this.name;
	}

	@Override
	public void putPairs() {
		hand.putPairCards();
	}

	@Override
	public boolean isOverGame() {
		// TODO 自動生成されたメソッド・スタブ
		return this.hand.isEmpty();
	}

	@Override
	public void sortHand() {
		this.hand.sort();
	}

}
