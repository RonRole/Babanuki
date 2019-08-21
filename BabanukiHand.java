package card;

import java.util.*;
import java.util.stream.*;

import interfaces.*;

public class BabanukiHand implements BabanukiHandMove {

	private List<Card> cards = new ArrayList<>();

	@Override
	public Card putCard() {
		// TODO 自動生成されたメソッド・スタブ
		Collections.shuffle(cards);
		Card putCard = cards.get(0);
		cards.remove(0);
		return putCard;
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
	public CardCollection putPairCards() {
		// TODO 自動生成されたメソッド・スタブ
		Map<String, List<Card>> numberToCards = this.groupingByCardNumber();
		Set<String> keySet = numberToCards.keySet();
		List<List<Card>> makePairCards = keySet.stream().map(numberToCards::get).filter(list -> list.size() >= 2).collect(Collectors.toList());
		makePairCards.forEach(list -> {
			int times = list.size() / 2 * 2;
			IntStream.range(0, times).forEach(i -> {
				cards.remove(list.get(0));
				list.remove(0);
			});
		});
		return this;
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
