package sardois.lucas.Battleship;

public abstract class Game {

	protected Player[] players;
	protected Player winner = null;
	protected Player loser = null;
	protected int[] shipSizes = {5, 4, 3, 3, 2};
	protected int currentPlayerIndex = 0;
	protected int turn = 1;
	
	public Game(Player firstPlayer, Player secondPlayer) {
		players = new Player[2];
	}
	
	protected void nextTurn() {
		currentPlayerIndex++;
		if (currentPlayerIndex >= players.length) {
			currentPlayerIndex = 0;
			turn++;
		}
	}
	
	protected Player getEnnemyPlayer() {
		if (currentPlayerIndex == 0) {
			return players[1];
		}
		return players[0];
	}
	
	protected Player getCurrentPlayer() {
		return players[currentPlayerIndex];
	}
	
	public Player getWinner() {
		return winner;
	}
	
	public Player getLoser() {
		return loser;
	}
	
	public abstract int play();
	
	public void reset() {
		turn = 1;
		currentPlayerIndex = 0;
		loser = null;
		winner = null;
		
	}
}