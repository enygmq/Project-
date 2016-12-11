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
	
	private Thread start;
	private boolean running = false;
	
	public ProjectO() {
		frame = new JFrame("Project O – a platformer");
	}

	public void run() {
		
	}
	
	public static void main(String[] args) {
		frame.setResizable(true);
		frame.setVisible(true);
		frame.setSize(new Dimension(width * scale, height * scale));
	}

}