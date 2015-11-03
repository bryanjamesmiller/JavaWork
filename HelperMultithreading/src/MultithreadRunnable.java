/**
 * 
 * @author Bryan
 *
 *  * Two ways to multithread:	extends the Thread class or
 * 								implements the Runnable interface
 *
 * A multithread is simply the processor running at least two threads at once (concurrently)
 */
class Runner2 implements Runnable {

	public void run() {
		for(int i=0; i<10; i++){
			System.out.println("Hello " + i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}

public class MultithreadRunnable {
		public static void main (String[] args){
			Thread runner1 = new Thread(new Runner2());
			Thread runner2 = new Thread(new Runner2());
			/*Call the built-in start() method instead of run() in order 
			to get a thread OTHER THAN THE MAIN THREAD to run the run() method.
			Notice how they take turns running, but run at the same time*/  
			runner1.start();
			runner2.start();
		}
}
