package card;

import java.util.*;
import java.util.stream.*;

import interfaces.*;

public class Deck implements CardCollection {

	private final List<Card> cards;

	public Deck() {
		Mark[] marks = Mark.values();
		List<Card> cards = Stream.of(marks)
				.flatMap(mark -> IntStream.rangeClosed(1, 13)
											.mapToObj(CardNumber::new)
											.map(number -> new StandardCard(number,mark)))
				.collect(Collectors.toList());
		Collections.shuffle(cards);
		this.cards = cards;
	}

	public void shuffle() {
		Collections.shuffle(cards);
	}

	@Override
	public Card putCard() {
		// TODO 自動生成されたメソッド・スタブ
		Card topCard = cards.get(0);
		cards.remove(0);
		return topCard;
	}

	@Override
	public CardCollection consumeCard(Card card) {
		// TODO 自動生成されたメソッド・スタブ
		cards.add(card);
		return this;
	}

	@Override
	public String toString() {
		return cards.stream().map(Card::toString).collect(Collectors.joining());
	}

	@Override
	public boolean isEmpty() {
		// TODO 自動生成されたメソッド・スタブ
		return cards.isEmpty();
	}

	@Override
	public Map<String, List<Card>> groupingByCardNumber() {
		// TODO 自動生成されたメソッド・スタブ
		return this.cards.stream().collect(Collectors.groupingBy(Card::toNumber));
	}

	@Override
	public CardCollection sort() {
		// TODO 自動生成されたメソッド・スタブ
		cards.sort(Comparator.comparing(Card::toNumber));
		return this;
	}
}
