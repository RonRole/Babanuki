package interfaces;

public interface Player {
	public void setUseHand(CardCollection cards);
	public void drawFrom(CardCollection cards);
	public void putTo(CardCollection cards);
	public String showHand();
	public boolean isContinueable();
	public boolean isOverGame();
	public void sortHand();
}
