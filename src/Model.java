import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

public class Model {
	
	private boolean[][] board;

	public Model() {
		board = new boolean[50][50];
		insertRandomLiveCells(300);
	}

	public void insertRandomLiveCells(int amountOfLife) {
		Random random = new Random();
		for (int i = 0; i < amountOfLife; i++) {
			int x = random.nextInt(50);
			int y = random.nextInt(50);
			board[x][y] = true;
		}
	}

	public void evolve() {
		for (int i = 0; i < 50; i++) {
			for (int j = 0; j < 50; j++) {
				board[i][j] = isCellStillAlive(i, j);
			}
		}
	}

	private boolean isCellStillAlive(int i, int j) {
		int amountOfNeighbours = amountOfLiveNeighbours(i, j);

		if (board[i][j]) {
			amountOfNeighbours--;
			return amountOfNeighbours >= 2 && amountOfNeighbours <= 3;
		} else if (amountOfNeighbours == 3) {
			return true;
		}
		
		return false;
	}

	public int amountOfLiveNeighbours(int x, int y) {
		int liveNeighbours = 0;
		for (int i = x - 1; i < x + 1; i++) {
			for (int j = y - 1; j < y + 1; j++) {
				if (outOfBounds(i,j)) {
						liveNeighbours += board[i][j] ? 1 : 0;
				}
			}
		}
		return liveNeighbours;
	}
	
	//decomposed contidional or should it be a inline method
	public boolean outOfBounds(int i, int j){
		if(j<50 && j>=0)
			return i<50 && i>=0;
		return false;
		
	}

	public boolean[][] getBoard() {
		return board;
	}
	
}
