package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestSync {

    public static void main(String[] args) {
//        System.out.println(9/3*3);
        ExecutorService executorService = Executors.newCachedThreadPool();
//        executorService.execute(() -> {
//            try {
//                Thread.sleep(2000);
//                System.out.println("Thread run");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//        executorService.shutdownNow();
//        System.out.println("Main run");
        SynchronizedExample se = new SynchronizedExample();
        SynchronizedExample se2 = new SynchronizedExample();
        executorService.execute(() -> se.func2());
        executorService.execute(() -> se2.func2());
        Object a = null;

    }
}

class SynchronizedExample {
    public void func1() {
//        synchronized (this) {
        for (int i = 0; i < 10; i++) {
            System.out.print(i + " ");
        }
//        }
    }

    synchronized void func2() {
//        for (int i = 0; i < 10; i++) {
//            System.out.print(i + " ");
//        }
        for (int i = 0; i < 10; i++) {
            System.out.print((i + 10) + " ");
        }
    }
}