package concurrent;

//²âÊÔvolatile¹Ø¼ü×Ö
public class VolatileTest {
    public static volatile int a = 0;
    private static final int COUNT_THREAD = 20;
    private static void increase() {
        a++;
    }
    private static void test() {
        for (int i = 0; i < COUNT_THREAD; i++) {
            Thread t = new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    increase();
                }
            });
            t.start();
        }
        while (Thread.activeCount() < 1)
            Thread.yield();
        System.out.println(a);
    }


    public static void main(String[] args) {
        test();
    }
}
