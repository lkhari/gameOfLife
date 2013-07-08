package gol;

public class Game {

	private Board board;

	public Game(Board board) {
		this.board = board;
	}

	public void evolve() {
		board.evolve();
	}

	public boolean isCellAlive(int x, int y) {
		return board.isCellAlive(x, y);
	}

}
