package card;

import java.util.*;

public class CardNumber {

	private int num;
	private final static Map<Integer, String> numToString = new HashMap<>();

	static {
		numToString.put(1, "A");
		numToString.put(11, "J");
		numToString.put(12, "Q");
		numToString.put(13, "K");
	}

	public CardNumber(int num) {
		this.num = num;
	}

	public boolean isSameNumberTo(CardNumber number) {
		return number.isSameNumberTo(this.num);
	}

	private boolean isSameNumberTo(int number) {
		return this.num == number;
	}

	@Override
	public String toString() {
		return numToString.getOrDefault(num, String.valueOf(num));
	}
}
