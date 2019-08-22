package interfaces;

public interface GameResult<T extends Player> {
	public void showWinners();
	public void showLosers();
	public void memorizeWinners(T winner);
	public void memorizeLosers(T loser);
}
