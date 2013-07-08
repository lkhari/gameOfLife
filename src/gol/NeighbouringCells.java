package gol;

import java.util.List;

public class NeighbouringCells {

	private List<Boolean> neighbouringCells;

	public NeighbouringCells(List<Boolean> neighbouringCells) {
		this.neighbouringCells = neighbouringCells;
	}

	public boolean lowPopulation() {
		return livingCount() <= 1;
	}

	public boolean highPopulation() {
		return livingCount() >= 4;
	}

	public boolean atPerfectLevelForReproduction() {
		return livingCount() == 3;
	}

	private int livingCount() {
		int livingCount = 0;
	
		for (boolean isAlive : neighbouringCells) {
			livingCount += isAlive ? 1 : 0;
		}
		
		return livingCount;
	}

}
