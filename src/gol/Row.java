package gol;

public class Row {

	private CellCluster[] cellClusters;

	public Row(CellCluster[] cellClusters) {
		this.cellClusters = cellClusters;
	}

	public void evolve() {
		for (CellCluster cellCluster : cellClusters) {
			cellCluster.evolve();
		}
	}

	public boolean isCellAlive(int x) {
		return cellClusters[x].isCentreOfClusterAlive();
	}

	public void addCellStateListener(int x, CellStateListener listener) {
		cellClusters[x].addListener(listener);
	}

}
