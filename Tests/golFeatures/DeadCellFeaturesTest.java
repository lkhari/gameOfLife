package golFeatures;

import static org.junit.Assert.*;
import gol.Game;

import org.junit.Test;

public class DeadCellFeaturesTest {

	@Test
	public void DeadgCellWithZeroNeighboursDies() {
	    //given
		boolean[][] initialState = new boolean[3][3];
	    
	    Game game = new Game(new BoardBuilder(initialState).build());

		//when
	    game.evolve();
	    
	    //then
	    assertFalse("This Cell should be dead",game.isCellAlive(1,1));
	}
	
	@Test
	public void deadCellWithTwoNeighbourDies(){
		//given
		boolean[][] initialState = new boolean[3][3];

		initialState[0][1]=true;
		initialState[1][2]=true;
		
		Game game = new Game(new BoardBuilder(initialState).build());
		
		//when 
		game.evolve();
		
		//then
		assertFalse("Cell 1,1 should Still be dead", game.isCellAlive(1, 1));
		
	}
	
	@Test
	public void deadCellWithThreeNeighbourLives(){
		//given
		boolean[][] initialState = new boolean[3][3];
		
		initialState[0][1]=true;
		initialState[1][2]=true;
		initialState[1][0]=true;
		
		Game game = new Game(new BoardBuilder(initialState).build());
		
		//when 
		game.evolve();
		
		//then
		assertTrue("Cell 1,1 should come to live", game.isCellAlive(1, 1));
		
	}
	
	@Test
	public void DeadCellWithFourNeighbourDies(){
		//given
		boolean[][] initialState = new boolean[3][3];
		
		initialState[0][1]=true;
		initialState[1][2]=true;
		initialState[1][0]=true;
		initialState[2][1]=true;
		
		Game game = new Game(new BoardBuilder(initialState).build());
		
		//when 
		game.evolve();
		
		//then
		assertFalse("Cell 1,1 should Still be dead", game.isCellAlive(1, 1));
		
	}

}
