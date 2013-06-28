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
	    game .evolve();
	    
	    //then
	    assertFalse("This Cell should be dead",game.isCellAlive(1,1));
	}

}
