import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics2D;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;

public class View extends Canvas {
	
	BufferStrategy displayBuffer;
	private Graphics2D picture;

	public View() {
		createClosableWindow(500,500);
		createBufferStrategy(2);
		displayBuffer = getBufferStrategy();
		picture = (Graphics2D) displayBuffer.getDrawGraphics();
	}
	
	public void createClosableWindow(int x, int y){
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

	public void renderCells(boolean[][] cells) {
		picture.translate(0, 0);
		
		for (int i = 0; i < 50; i++) {
			for (int j = 0; j < 50; j++) {
				picture.setColor(new Color(0, 0, 0));
				if (cells[i][j]) {
					picture.setColor(new Color(68, 89, 110));
				}

				picture.fillRect(i * 10, j * 10, 10, 10);
			}
		}
		
		picture.dispose();
		displayBuffer.show();
	}

}
