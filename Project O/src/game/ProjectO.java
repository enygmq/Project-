package game;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class ProjectO extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;

	public static int width = 300;
	public static int height = width / 16 * 9;
	public static int scale = 3;
	
	private static JFrame frame;
	
	private Thread thread;
	private boolean running = false;
	
	public ProjectO() {
		Dimension size = new Dimension(width * scale, height * scale);
		setPreferredSize(size);
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
		frame.setSize(new Dimension(width * scale, height * scale));
		frame.setLocationRelativeTo(null);
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}