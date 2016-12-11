package game;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import mechanics.Match;

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
		new Match().startRound();
	}
	
	public synchronized void stop() {
		running = false;
		try {
			thread.join();
			new Match().endRound();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		while (running) {
			render();
			update();
		}
	}
	
	public void update() {
		
	}
	
	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
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