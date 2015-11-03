/**
 * @author Bryan
 * 
 * This program shows how one thread can interrupt another
 */
import java.util.*;

class InfiniteLoop extends Thread{
	//The volatile data type ensures that Java does not mistakingly optimize and cache
	// the running variable, which could possibly cause a problem on some systems.
	private volatile boolean running = true;
	public void run(){
		while(running){
			System.out.println("Hello");
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void shutdown(){
		running = false;
	}
}

public class MultithreadVolatile {
	
	public static void main(String[] args){
		InfiniteLoop loop1 = new InfiniteLoop();
		// The first threat starts here, but the main thread continues on
		loop1.start();
		
		System.out.println("Press return to stop the inifinite loop");
		Scanner myInput = new Scanner(System.in);
		myInput.nextLine();
		
		//The second thread runs and sets running = false
		loop1.shutdown();
	}
}
