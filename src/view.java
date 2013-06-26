import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Frame;
import java.awt.Graphics2D;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;


public class view extends Canvas {
	model w;
	private BufferStrategy strategy;
	
	public view(){
		w=new model();
		  Frame frame =new Frame();
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
	
	public void play(){
		while(true){
			   
		        
		        Graphics2D g=(Graphics2D) strategy.getDrawGraphics();
		        g.translate(0,0);
		        w.paint(g);
		        g.dispose();
		        strategy.show();
		        w.play();
		        try { Thread.sleep(40); } catch (Exception e) {}; 
		          
		        
		}
	}
	public static void main(String args[]){
		view v=new view();
	}
}

