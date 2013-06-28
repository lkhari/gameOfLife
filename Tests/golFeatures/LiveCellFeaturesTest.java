package golFeatures;

import static org.junit.Assert.*;
import gol.Game;

import org.junit.Test;

public class LiveCellFeaturesTest {

	@Test
	public void livingCellWithZeroNeighboursDies() {
	    //given
	    boolean[][] board= new boolean[3][3];
	    board[1][1]=true;
	    
	    Game game = new Game(board);
		//when
	    game.evolve();
	    
	    //then
	    assertFalse("This Cell should be dead",game.isCellAlive(1,1));
	}
	
	@Test
	public void livingCellWithTwoNeighbourLives(){
		//given
		boolean[][] board=new boolean[3][3];
		board[1][1] = true;
		
		board[0][1]=true;
		board[1][2]=true;
		
		Game game = new Game(board);
		
		//when 
		game.evolve();
		
		//then
		assertTrue("Cell 1,1 should Still live", game.isCellAlive(1, 1));
		
	}

}
