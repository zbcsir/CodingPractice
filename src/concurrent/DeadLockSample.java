package concurrent;

import javax.management.MXBean;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class DeadLockSample extends Thread{
    String lockStr1;
    String lockStr2;

    public DeadLockSample(String name, String lockStr1, String lockStr2) {
        super(name);
        this.lockStr1 = lockStr1;
        this.lockStr2 = lockStr2;
    }

    @Override
    public void run() {
        synchronized (lockStr1) {
            System.out.println(this.getName() + " : " + lockStr1);
            try {
                Thread.sleep(1000);
                synchronized (lockStr2) {
                    System.out.println(this.getName() + " : " + lockStr2);
                }
            }catch (InterruptedException ie) {
                ie.printStackTrace();
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {
        String lockStr1 = "Lock1";
        String lockStr2 = "lock2";

        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                long[] deadlocks = threadMXBean.findDeadlockedThreads();
                if (deadlocks != null) {
                    ThreadInfo[] threadInfos = threadMXBean.getThreadInfo(deadlocks);
                    for (ThreadInfo threadInfo : threadInfos) {
                        System.out.println(threadInfo.getThreadId() +" : " + threadInfo.getThreadName());
                    }
                }
            }
        };
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
        ses.scheduleAtFixedRate(runnable, 2, 5, TimeUnit.SECONDS);

        DeadLockSample dl1 = new DeadLockSample("thread1", lockStr1, lockStr2);
        DeadLockSample dl2 = new DeadLockSample("thread2", lockStr2, lockStr1);
        dl1.start();
        dl2.start();
        dl1.join();
        dl2.join();
    }
}
