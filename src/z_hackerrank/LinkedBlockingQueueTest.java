package z_hackerrank;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class Thread1 implements Runnable{

	BlockingQueue<Integer> queue;
	public Thread1(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}
	
	@Override
	public void run() {
		System.out.println("Waiting for consuming");
		try {
			Integer i = queue.take();
			System.out.println("Consumed :: "+i);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}


class Thread2 implements Runnable{

	BlockingQueue<Integer> queue;
	public Thread2(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}
	
	@Override
	public void run() {
		System.out.println("Started producing");
		try {
			Integer i = 6;
			queue.put(i);
			System.out.println("produced "+i);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}

public class LinkedBlockingQueueTest {
	
	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<Integer> b1 = new LinkedBlockingQueue();
		Thread t1 = new Thread(new Thread1(b1));
		Thread t2 = new Thread(new Thread2(b1));
		
		
		System.out.println("Starting thread consumer : ");
		t1.start();
		System.out.println("After Starting thread consumer : ");
		Thread.sleep(100);
		System.out.println("Starting thread producer : ");
		t2.start();
		System.out.println("After Starting thread producer : ");
	}
	
}
