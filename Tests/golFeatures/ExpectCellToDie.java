package golFeatures;

import static org.junit.Assert.assertFalse;
import gol.CellStateListener;

public class ExpectCellToDie implements CellStateListener {

	public void stateChanged(boolean newState) {
		assertFalse("Expected Cell to be dead", newState);
	}

}
