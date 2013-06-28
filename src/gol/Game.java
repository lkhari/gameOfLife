package gol;

public class Game {
	private boolean[][] board;

	public Game(boolean[][] board) {
		this.board=board;
	}

	public void evolve() {
		// TODO Auto-generated method stub
		if(!board[0][1]){
			board[1][1]=false;
		}
	}

	public boolean isCellAlive(int i, int j) {
		return board[i][j];
	}

}
