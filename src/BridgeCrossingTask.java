import java.util.concurrent.Semaphore;

public class BridgeCrossingTask implements Runnable {
	private final Semaphore signal;
	
	public BridgeCrossingTask(Semaphore signal) {
		this.signal = signal;
	}
	
	@Override
	public void run() {
		
		System.out.println("Train " + Thread.currentThread().getName() + " reached at rail bridge and waiting for signal.");
		
		try {
			signal.acquire();
			
			System.out.println("Train " + Thread.currentThread().getName() + " got signal, is passing and will take 10 sec");
			
			Thread.sleep(10000);
			
		} catch(InterruptedException e) {
			
			Thread.interrupted();
			
		} finally {
			
			System.out.println("Train " + Thread.currentThread().getName() + " is passed.");
			signal.release();
			
		}
	}
}
