import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

public class Model {
	public boolean[][] board;

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

	public void evolving() {
		for (int i = 0; i < 50; i++) {
			for (int j = 0; j < 50; j++) {
				int amountOfNeighbours = amountOfLiveNeighbours(i, j);

				if (board[i][j]) {
					amountOfNeighbours--;
					if (amountOfNeighbours < 2 || amountOfNeighbours > 3) {
						board[i][j] = false;
					}

				} else {
					if (amountOfNeighbours == 3) {
						board[i][j] = true;
					}
				}
			}
		}
	}

	public int amountOfLiveNeighbours(int x, int y) {
		int liveNeighbours = 0;

		for (int i = x - 1; i < x + 1; i++) {
			for (int j = y - 1; j < y + 1; j++) {
				if (outOfBounds(i)) {
					if (outOfBounds(j)) {
						liveNeighbours += board[i][j] ? 1 : 0;
					}
				}
			}
		}
		return liveNeighbours;
	}
	
	//decomposed contidional or should it be a inline method
	public boolean outOfBounds(int i){
		if(i>=50 || i<0){
			return false;
		}
		return true;
		
	}
	
	public void paintingCells(Graphics2D canvas) {
		for (int i = 0; i < 50; i++) {
			for (int j = 0; j < 50; j++) {
				canvas.setColor(new Color(0, 0, 0));
				if (board[i][j]) {
					canvas.setColor(new Color(68, 89, 110));
				}

				canvas.fillRect(i * 10, j * 10, 10, 10);
			}
		}
	}
}
