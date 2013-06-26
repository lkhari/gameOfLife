import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Frame;
import java.awt.Graphics2D;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;

public class View extends Canvas {
	Model model;
	private BufferStrategy strategy;

	public View() {
		model = new Model();
		Frame frame = new Frame();
		frame.setLayout(null);
		setBounds(0, 0, 500, 500);
		frame.add(this, BorderLayout.CENTER);
		frame.setSize(500, 500);
		frame.setResizable(false);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		frame.setVisible(true);
		createBufferStrategy(2);
		strategy = getBufferStrategy();
		play();
	}

	public void play() {
		while (true) {
			Graphics2D g = (Graphics2D) strategy.getDrawGraphics();
			g.translate(0, 0);
			model.paint(g);
			g.dispose();
			strategy.show();
			model.play();
			try {
				Thread.sleep(40);
			} catch (Exception e) {
			}
			;
		}
	}

	public static void main(String args[]) {
		View v = new View();
	}
}
