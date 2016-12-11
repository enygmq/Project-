package game;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class ProjectO extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;

	public static int width = 300;
	public static int height = width / 16 * 9;
	public static int scale = 3;
	
	private JFrame frame;
	
	private Thread thread;
	private boolean running = false;
	
	public ProjectO() {
		Dimension size = new Dimension(width * scale, height * scale);
		setPreferredSize(size);
		
		frame = new JFrame();
	}
	
	public synchronized void start() {
		running = true;
		thread = new Thread(this, "Display");
		thread.start();
	}
	
	public synchronized void stop() {
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		while (running) {
			
		}
	}
	
	public static void main(String[] args) {
		ProjectO game = new ProjectO();
		
		game.frame.setResizable(false);
		game.frame.setTitle("Project O - a platformer");
		game.frame.add(game);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);
	
		game.start();
	}

}