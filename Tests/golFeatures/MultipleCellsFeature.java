package golFeatures;

import static org.junit.Assert.*;

import org.junit.Test;
import gol.Game;

public class MultipleCellsFeature {

	@Test
	public void sparseGridWithNoSurvivors() {

		//given
		boolean[][] board= new boolean[5][5];
		
		board[1][1]=true;
		board[1][3]=true;
		board[3][1]=true;
		board[3][3]=true;
		
		Game game= new Game(board);
		//when
		game.evolve();
		
		//then
		assertFalse("Cell 1,1 should have died", game.isCellAlive(1, 1));
		assertFalse("Cell 1,3 should have died", game.isCellAlive(1, 3));
		assertFalse("Cell 3,1 should have died", game.isCellAlive(3, 1));
		assertFalse("Cell 3,3 should have died", game.isCellAlive(3, 3));
	}

	@Test
	public void sparseGridWithNoSurvivors() {

		//given
		boolean[][] board= new boolean[5][5];
		
		board[1][1]=true;
		board[1][3]=true;
		board[3][1]=true;
		board[3][3]=true;
		
		Game game= new Game(board);
		//when
		game.evolve();
		
		//then
		assertFalse("Cell 1,1 should have died", game.isCellAlive(1, 1));
		assertFalse("Cell 1,3 should have died", game.isCellAlive(1, 3));
		assertFalse("Cell 3,1 should have died", game.isCellAlive(3, 1));
		assertFalse("Cell 3,3 should have died", game.isCellAlive(3, 3));
	}
}
