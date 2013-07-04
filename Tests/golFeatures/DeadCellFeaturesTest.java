package golFeatures;

import static org.junit.Assert.*;
import gol.Board;
import gol.Game;

import org.junit.Test;

public class DeadCellFeaturesTest {

	@Test
	public void DeadgCellWithZeroNeighboursDies() {
	    //given
	    Board board= new Board(3, 3);
	    
	    Game game = new Game(board.rows);
		//when
	    game.evolve();
	    
	    //then
	    assertFalse("This Cell should be dead",game.isCellAlive(1,1));
	}
	
	@Test
	public void deadCellWithTwoNeighbourDies(){
		//given
		Board board=new Board(3, 3);

		board.rows[0][1]=true;
		board.rows[1][2]=true;
		
		Game game = new Game(board.rows);
		
		//when 
		game.evolve();
		
		//then
		assertFalse("Cell 1,1 should Still be dead", game.isCellAlive(1, 1));
		
	}
	
	@Test
	public void deadCellWithThreeNeighbourLives(){
		//given
		Board board=new Board(3, 3);
		
		board.rows[0][1]=true;
		board.rows[1][2]=true;
		board.rows[1][0]=true;
		
		Game game = new Game(board.rows);
		
		//when 
		game.evolve();
		
		//then
		assertTrue("Cell 1,1 should come to live", game.isCellAlive(1, 1));
		
	}
	
	@Test
	public void DeadCellWithFourNeighbourDies(){
		//given
		Board board=new Board(3, 3);
		
		board.rows[0][1]=true;
		board.rows[1][2]=true;
		board.rows[1][0]=true;
		board.rows[2][1]=true;
		
		Game game = new Game(board.rows);
		
		//when 
		game.evolve();
		
		//then
		assertFalse("Cell 1,1 should Still be dead", game.isCellAlive(1, 1));
		
	}

}
