package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample {

    public static void main(String[] args) {
        ExecutorService executorService  = Executors.newCachedThreadPool();
        ExecutorService executorService1 = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            executorService1.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() +" start");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException ie) {
                        ie.printStackTrace();
                    }
                }
            });
        }
        executorService1.shutdown();
    }
}
