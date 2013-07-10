package gol;

import java.util.ArrayList;
import java.util.List;

public class CellCluster {

	private boolean isAlive;
	private NeighbouringCells neighbouringCells;
	
	private List<CellStateListener> listeners;

	public CellCluster(boolean isAlive, NeighbouringCells neighbouringCells) {
		this.isAlive = isAlive;
		this.neighbouringCells = neighbouringCells;
		listeners = new ArrayList<CellStateListener>();
	}
	
	public void addListener(CellStateListener listener) {
		listeners.add(listener);
	}

	public boolean isCentreOfClusterAlive() {
		return isAlive;
	}

	public void evolve() {
		if (isAlive && neighbouringCells.lowPopulation()) {
			isAlive = false;
			notifyListenersOfNewState(isAlive);
		}
		if (isAlive && neighbouringCells.highPopulation()) {
			isAlive = false;
		}
		if (!isAlive && neighbouringCells.atPerfectLevelForReproduction()) {
			isAlive = true;
		}
	}

	private void notifyListenersOfNewState(boolean newState) {
		for (CellStateListener listener : listeners) {
			listener.stateChanged(newState);
		}
	}

}
