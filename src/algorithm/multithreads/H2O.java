package algorithm.multithreads;

import java.util.Scanner;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/**
 * Leetcode 1117 H2O生成
 *
 * 现在有两种线程，氢 oxygen 和氧 hydrogen，你的目标是组织这两种线程来产生水分子。
 * 存在一个屏障（barrier）使得每个线程必须等候直到一个完整水分子能够被产生出来。
 * 氢和氧线程会被分别给予 releaseHydrogen 和 releaseOxygen 方法来允许它们突破屏障。
 * 这些线程应该三三成组突破屏障并能立即组合产生一个水分子。
 * 必须保证产生一个水分子所需线程的结合必须发生在下一个水分子产生之前。
 *
 */
public class H2O {
    private Semaphore hyd, oxy;
    private CyclicBarrier barrier;
    private H2O() {
        hyd = new Semaphore(2);
        oxy = new Semaphore(1);
        barrier = new CyclicBarrier(3);
    }

    private void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hyd.acquire();
        try {
            barrier.await();
            System.out.println(Thread.currentThread().getName() + " is running");
        } catch (BrokenBarrierException bbe) {
            bbe.printStackTrace();
        }
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        hyd.release();
    }

    private void oxygen(Runnable releaseOxygen) throws InterruptedException {
        oxy.acquire();
        try {
            barrier.await();
            System.out.println(Thread.currentThread().getName() + " is running");
        } catch (BrokenBarrierException bbe) {
            bbe.printStackTrace();
        }
        // releaseOxygen.run() outputs "H". Do not change or remove this line.
        releaseOxygen.run();
        oxy.release();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        H2O h2O = new H2O();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'H' || input.charAt(i) == 'h') {
                new Thread(() -> {
                    try {
                        h2O.hydrogen(() -> System.out.println("H"));
                    } catch (InterruptedException ie) {
                        ie.printStackTrace();
                    }
                }).start();
            } else if (input.charAt(i) == 'O' || input.charAt(i) == 'o') {
                new Thread(() -> {
                    try {
                        h2O.oxygen(() -> System.out.println("O"));
                    } catch (InterruptedException ie) {
                        ie.printStackTrace();
                    }
                }).start();
            }
        }
    }
}
