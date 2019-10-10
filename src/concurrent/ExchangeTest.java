package concurrent;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * Exchanger¿‡¡∑œ∞
 */

public class ExchangeTest {
    private static Exchanger<String> exchanger = new Exchanger<>();
    private static ExecutorService pool = Executors.newFixedThreadPool(3);
    private ThreadFactory factory = new ThreadFactoryBuilder().setNameFormat("pool-%d").build();
    ExecutorService pool2 = new ThreadPoolExecutor(5, 10, 0L,
            TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(100), new ThreadPoolExecutor.AbortPolicy());

    public static void main(String[] args) {
        pool.execute(() -> {
            String a = "str A";
            try {
                System.out.print("String A exchanged :");
                System.out.println(exchanger.exchange(a));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        pool.execute(() -> {
            String b = "str B";
            try {
                String a = exchanger.exchange(b);
                System.out.println("String B exchanged: " + a);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        pool.shutdown();
    }
}
