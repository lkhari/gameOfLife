package gol;

public class CellCluster {

	private boolean isAlive;
	private NeighbouringCells neighbouringCells;

	public CellCluster(boolean isAlive, NeighbouringCells neighbouringCells) {
		this.isAlive = isAlive;
		this.neighbouringCells = neighbouringCells;
	}

	public boolean isCentreOfClusterAlive() {
		return isAlive;
	}

	public void evolve() {
		if (isAlive && neighbouringCells.lowPopulation()) {
			isAlive = false;
		}
		if (isAlive && neighbouringCells.highPopulation()) {
			isAlive = false;
		}
		if (!isAlive && neighbouringCells.atPerfectLevelForReproduction()) {
			isAlive = true;
		}
	}

}
