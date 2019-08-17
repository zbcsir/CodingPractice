package algorithm.multithreads;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * Leetcode 1116 打印零与奇偶数
 *
 * 相同的一个 ZeroEvenOdd 类实例将会传递给三个不同的线程：
 *
 * 线程 A 将调用 zero()，它只输出 0 。
 * 线程 B 将调用 even()，它只输出偶数。
 * 线程 C 将调用 odd()，它只输出奇数。
 *
 * 示例：
 * 输入：n = 5
 * 输出："0102030405"
 */
public class ZeroEvenOdd {
    private int n;
    private Semaphore s0, s1, s2;

    private ZeroEvenOdd(int n) {
        this.n = n;
        s0 = new Semaphore(1);
        s1 = new Semaphore(0);
        s2 = new Semaphore(0);
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    private void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            s0.acquire();
            printNumber.accept(0);
            if ((i & 1) == 1) {
                s1.release();
            } else {
                s2.release();
            }
        }
    }

    private void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i+=2) {
            s2.acquire();
            printNumber.accept(i);
            s0.release();
        }
    }

    private void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i+=2) {
            s1.acquire();
            printNumber.accept(i);
            s0.release();
        }
    }

    public static void main(String[] args) {
        ZeroEvenOdd zeo = new ZeroEvenOdd(9);
        IntConsumer ic = new IntConsumer() {
            @Override
            public void accept(int value) {
                System.out.print(value);
            }
        };
        new Thread(() -> {
            try {
                zeo.zero(ic);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                zeo.odd(ic);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                zeo.even(ic);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
