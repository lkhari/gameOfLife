package golFeatures;

import static org.junit.Assert.*;
import gol.Board;
import gol.Game;

import org.junit.Test;

public class LiveCellFeaturesTest {

	@Test
	public void livingCellWithZeroNeighboursDies() {
	    //given
	    Board board= new Board(3, 3);
	    board.rows[1][1]=true;
	    
	    Game game = new Game(board.rows);
		//when
	    game.evolve();
	    
	    //then
	    assertFalse("This Cell should be dead",game.isCellAlive(1,1));
	}
	
	@Test
	public void livingCellWithTwoNeighbourLives(){
		//given
		Board board=new Board(3, 3);
		board.rows[1][1] = true;
		
		board.rows[0][1]=true;
		board.rows[1][2]=true;
		
		Game game = new Game(board.rows);
		
		//when 
		game.evolve();
		
		//then
		assertTrue("Cell 1,1 should Still live", game.isCellAlive(1, 1));
		
	}
	
	@Test
	public void livingCellWithThreeNeighbourLives(){
		//given
		Board board=new Board(3, 3);
		board.rows[1][1] = true;
		
		board.rows[0][1]=true;
		board.rows[1][2]=true;
		board.rows[1][0]=true;
		
		Game game = new Game(board.rows);
		
		//when 
		game.evolve();
		
		//then
		assertTrue("Cell 1,1 should Still live", game.isCellAlive(1, 1));
		
	}
	
	@Test
	public void livingCellWithFourNeighbourDies(){
		//given
		Board board=new Board(3, 3);
		board.rows[1][1] = true;
		
		board.rows[0][1]=true;
		board.rows[1][2]=true;
		board.rows[1][0]=true;
		board.rows[2][1]=true;
		
		Game game = new Game(board.rows);
		
		//when 
		game.evolve();
		
		//then
		assertFalse("Cell 1,1 should die", game.isCellAlive(1, 1));
		
	}

}
