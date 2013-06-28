package gol;

public class Game {
	private boolean[][] board;

	public Game(boolean[][] board) {
		this.board=board;
	}

	public void evolve() {
				board[1][1] = updateCellLife(1, 1);
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
		for (int j = 0; j < board.length; j++) {
			for (int i =0; i < board[0].length; i++) {
					liveNeighbours += board[i][j] ? 1 : 0;
			}
		}
		return liveNeighbours;
	}
	
	public boolean isCellAlive(int i, int j) {
		return board[i][j];
	}

}
