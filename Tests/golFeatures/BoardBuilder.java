package golFeatures;

import gol.Board;
import gol.CellCluster;
import gol.NeighbouringCells;
import gol.Row;

import java.util.ArrayList;
import java.util.List;

public class BoardBuilder {
	
	private boolean[][] initialState;
	
	public BoardBuilder(boolean[][] initialState) {
		this.initialState = initialState;
	}
	
	public Board build() {
		Row[] rowsOfCellClusters = new Row[initialState.length]; 
		
		for (int y = 0; y < initialState.length; y++) {
			CellCluster[] cellClustersInRow = new CellCluster[initialState[y].length];
			
			for (int x = 0; x < initialState[y].length; x++) {
				boolean isAlive = initialState[y][x];
				
				List<Boolean> stateOfNeighbouringCells = getNeighbouringCells(y, x);
				
				cellClustersInRow[x] = new CellCluster(isAlive, new NeighbouringCells(stateOfNeighbouringCells));
			}
			
			rowsOfCellClusters[y] = new Row(cellClustersInRow);
		}
		
		return new Board(rowsOfCellClusters);
	}

	private List<Boolean> getNeighbouringCells(int y, int x) {
		List<Boolean> neighbouringCells = new ArrayList<Boolean>();
		
		for (int row = y - 1; row <= y + 1; row++) {
			for (int column = x - 1; column <= x + 1; column++) {
				if (cellExists(row, column) && !same(row, column, y, x)) {
					neighbouringCells.add(initialState[row][column]);
				}
			}
		}
		
		return neighbouringCells;
	}

	private boolean cellExists(int row, int column) {
		if (row < 0 || row >= initialState.length) {
			return false;
		}
		if (column < 0 || column >= initialState[row].length) {
			return false;
		}
		return true;
	}

	private boolean same(int row, int column, int y, int x) {
		return row == y && column == x;
	}

}
