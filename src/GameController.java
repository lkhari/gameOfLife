
public class GameController {
	
	public static void main(String[] args) {
		new GameController().runGame();
	}
	
	private View view;
	private Model model;

	public GameController() {
		model = new Model();
		view = new View();
	}
	
	public void runGame() {
		for(;;) {
			view.renderCells(model.getBoard());
			model.evolve();
			
			try {
				Thread.sleep(40);
			} catch (Exception e) {}
		}
	}
		
}