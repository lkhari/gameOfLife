package gol;

public class Game {
	private boolean[][] board;

	public Game(boolean[][] board) {
		this.board=board;
	}

	public void evolve() {
		int amountOfLiveNeighbours=0;
		for(int j=0;j<board[0].length;j++){
			for(int i=0;i<board.length;i++){
				if(board[i][j]) amountOfLiveNeighbours++;
			}
		}
		if(amountOfLiveNeighbours-1==3 || amountOfLiveNeighbours-1==2){
			board[1][1]=true;
		}else{
			board[1][1]=false;
		}
	}

	public boolean isCellAlive(int i, int j) {
		return board[i][j];
	}

}
