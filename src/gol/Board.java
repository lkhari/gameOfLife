package gol;

public class Board {

	private Row[] rows;

	public Board(Row[] rows) {
		this.rows = rows;
	}

	public void evolve() {
		for (Row row : rows) {
			row.evolve();
		}
	}

	public boolean isCellAlive(int x, int y) {
		return rows[y].isCellAlive(x);
	}

}
