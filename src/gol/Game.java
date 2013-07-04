package gol;

public class Game {

	private boolean[][] board;
	private boolean[][] prevBoardState;

	public Game(boolean[][] board) {
		this.board = board;
	}

	public void evolve() {
		prevBoardState = currentState();
		for (int j = 0; j < board.length; j++) {
			for (int i = 0; i < board[0].length; i++) {
				board[i][j] = isCellStillLife(i, j);
			}
		}
	}

	private boolean isCellStillLife(int x, int y) {
		int amountOfNeighbours = amountOfLiveNeighbours(x, y);
		if (board[x][y]) {
			amountOfNeighbours--;
			return amountOfNeighbours >= 2 && amountOfNeighbours <= 3;
		}
		return amountOfNeighbours == 3;
	}

	private int amountOfLiveNeighbours(int x, int y) {
		int liveNeighbours = 0;
		for (int i = x - 1; i < x + 2; i++) {
			for (int j = y - 1; j < y + 2; j++) {
				if (outOfBounds(i, j)) {
					liveNeighbours += prevBoardState[i][j] ? 1 : 0;
				}
			}
		}
		return liveNeighbours;
	}

	private boolean outOfBounds(int x, int y) {
		if (y < board.length && y >= 0)
			return x < board.length && x >= 0;
		return false;
	}

	private boolean[][] currentState() {
		boolean[][] newArray = (boolean[][]) board.clone();

		for (int row = 0; row < board.length; row++) {
			newArray[row] = (boolean[]) board[row].clone();
		}
		return newArray;
	}

	public boolean isCellAlive(int x, int y) {
		return board[x][y];
	}
}