package mechanics;

import java.util.Timer;
import java.util.TimerTask;

public class Match extends TimerTask implements Runnable {

	private static int roundtime = 180; // In seconds.

	private Thread match;
	private static boolean running = false;

	public void run() {
		Timer t = new Timer();
		t.scheduleAtFixedRate(new TimerTask() {

			public void run() {
				print(secondsToString(roundtime--));

			}
		}, 0, 1000);

	}

	public synchronized void startRound() {
		running = true;
		match = new Thread(this, "Match");
		match.start();
	}

	public synchronized void endRound() {
		running = false;
		try {
			match.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public String secondsToString(int pTime) {
	    return String.format("%02d:%02d", pTime / 60, pTime % 60);
	}

	public static void print(String x) {
		System.out.println(x);
	}

}