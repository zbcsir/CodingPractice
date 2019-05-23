package concurrent;

// 多线程自增操作保证线程安全
public class ThreadInc {

    private static int counts = 0;

    private synchronized void inc(){
        counts++;
    }

    public static void main(String[] args) throws Exception{

        ThreadInc v = new ThreadInc();
        for (int i = 0; i < 100; i++){
            Thread t = new Thread(() -> {
                v.inc();
            });
            t.start();
            t.join();
        }
        System.out.println(counts); //输出100
        counts = 0;
        for (int i = 0; i < 100; i++) {
            new Thread(){
                @Override
                public void run() {
                    v.inc();
                }
            }.start();
        }
        System.out.println(counts); //输出一般小于100
    }
}
