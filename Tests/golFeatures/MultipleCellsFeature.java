package golFeatures;

import static org.junit.Assert.*;

import org.junit.Test;

import gol.Game;

public class MultipleCellsFeature {

	@Test
	public void sparseGridWithNoSurvivors() {
		//given
		boolean[][] initialState = new boolean[5][5];
		
		initialState[1][1]=true;
		initialState[1][3]=true;
		initialState[3][1]=true;
		initialState[3][3]=true;
		
		Game game= new Game(new BoardBuilder(initialState).build());

		//when
		game.evolve();
		
		//then
		assertFalse("Cell 1,1 should have died", game.isCellAlive(1, 1));
		assertFalse("Cell 1,3 should have died", game.isCellAlive(1, 3));
		assertFalse("Cell 3,1 should have died", game.isCellAlive(3, 1));
		assertFalse("Cell 3,3 should have died", game.isCellAlive(3, 3));
	}

}
