package concurrent;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import java.util.concurrent.*;

/**
 * static方法 + synchronize
 * 非static方法 + synchronize
 * 使用线程池创建和管理线程
 */
public class SynchTest implements Runnable{
    private static int num = 0;
    private static int numThread = 20;
    private static CountDownLatch latch = new CountDownLatch(numThread);
    private static ThreadFactory tf = new ThreadFactoryBuilder()
            .setNameFormat("thread-%d").build();
    private static ExecutorService executor = new ThreadPoolExecutor(5
            , 20, 0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>(), tf,
            new ThreadPoolExecutor.AbortPolicy());

    private synchronized void add1() {
        num++;
    }

    private synchronized static void add2() {
        num++;
    }

    @Override
    public void run() {
        try {
            add1();
            add2();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            latch.countDown();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < numThread; i++) {
            executor.submit(new SynchTest());
        }
        executor.shutdown();
        try {
            latch.await();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        System.out.println(num);
    }

}