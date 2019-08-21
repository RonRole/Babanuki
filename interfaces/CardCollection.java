package interfaces;

import java.util.*;

import card.*;

public interface CardCollection {
	public Card putCard();
	public CardCollection consumeCard(Card card);

	public boolean isEmpty();
	public Map<String, List<Card>> groupingByCardNumber();

	public CardCollection sort();

	public default void consumeJoker() {
		Card joker = new Joker();
		consumeCard(joker);
	}
}
