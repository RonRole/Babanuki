package card;

import interfaces.*;

public class StandardCard implements Card {
	private CardNumber number;
	private Mark mark;

	public StandardCard(CardNumber number, Mark mark) {
		this.number = number;
		this.mark = mark;
	}

	@Override
	public String toString() {
		return "[" + mark+ ":" + number + "]";
	}

	public String toNumber() {
		return number.toString();
	}
}
