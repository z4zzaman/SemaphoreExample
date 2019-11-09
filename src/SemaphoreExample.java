import java.util.concurrent.Semaphore;

public class SemaphoreExample {
	public static void main(String[] args) {
		
		Semaphore passToken = new Semaphore(1);
	
		
		BridgeCrossingTask task = new BridgeCrossingTask(passToken);
		
		
		new Thread(task,"Shatabdi").start();
		new Thread(task,"Rajdhani").start();
		
	}
}

