package gol;

public class Board {
	
	// TODO make private, no getters!
	public boolean[][] rows;
	
	public Board(int width, int height) {
		rows = new boolean[height][width];
	}

}
