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
				board[i][j] = updateCellLife(i, j);
			}
		}
	}

	private boolean updateCellLife(int i, int j) {
		int amountOfNeighbours = amountOfLiveNeighbours(i, j);
		if (board[i][j]) {
			amountOfNeighbours--;
			return amountOfNeighbours >= 2 && amountOfNeighbours <= 3;
		}
		return amountOfNeighbours == 3;
	}

	public int amountOfLiveNeighbours(int x, int y) {
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

	public boolean outOfBounds(int i, int j) {
		if (j < board.length && j >= 0)
			return i < board.length && i >= 0;
		return false;
	}

	public boolean[][] currentState() {
		boolean[][] newArray = (boolean[][]) board.clone();

		for (int row = 0; row < board.length; row++) {
			newArray[row] = (boolean[]) board[row].clone();
		}
		return newArray;
	}

	public boolean isCellAlive(int i, int j) {
		return board[i][j];
	}

}
