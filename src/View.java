import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Frame;
import java.awt.Graphics2D;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;

public class View extends Canvas {
	Model model;
	private BufferStrategy displayBuffer;

	public View() {
		model = new Model();
		createWindow(500,500);
		createBufferStrategy(2);
		displayBuffer = getBufferStrategy();
		updatingDisplayBuffer();
	}
	
	public void createWindow(int x, int y){
		Frame frame = new Frame();
		frame.setLayout(null);
		setBounds(0, 0, x, y);
		frame.add(this, BorderLayout.CENTER);
		frame.setSize(x, y);
		frame.setResizable(false);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		frame.setVisible(true);
	}

	public void updatingDisplayBuffer() {
		while (true) {
			Graphics2D g = (Graphics2D) displayBuffer.getDrawGraphics();
			g.translate(0, 0);
			model.paintingCells(g);
			g.dispose();
			displayBuffer.show();
			model.evolving();
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
