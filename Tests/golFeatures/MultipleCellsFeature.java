package golFeatures;

import static org.junit.Assert.*;

import org.junit.Test;

import gol.Board;
import gol.Game;

public class MultipleCellsFeature {

	@Test
	public void sparseGridWithNoSurvivors() {

		//given
		Board board= new Board(5, 5);
		
		board.rows[1][1]=true;
		board.rows[1][3]=true;
		board.rows[3][1]=true;
		board.rows[3][3]=true;
		
		Game game= new Game(board.rows);
		//when
		game.evolve();
		
		//then
		assertFalse("Cell 1,1 should have died", game.isCellAlive(1, 1));
		assertFalse("Cell 1,3 should have died", game.isCellAlive(1, 3));
		assertFalse("Cell 3,1 should have died", game.isCellAlive(3, 1));
		assertFalse("Cell 3,3 should have died", game.isCellAlive(3, 3));
	}

}
