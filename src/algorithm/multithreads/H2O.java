package algorithm.multithreads;

import java.util.Scanner;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/**
 * Leetcode 1117 H2O����
 *
 * �����������̣߳��� oxygen ���� hydrogen�����Ŀ������֯�������߳�������ˮ���ӡ�
 * ����һ�����ϣ�barrier��ʹ��ÿ���̱߳���Ⱥ�ֱ��һ������ˮ�����ܹ�������������
 * ������̻߳ᱻ�ֱ���� releaseHydrogen �� releaseOxygen ��������������ͻ�����ϡ�
 * ��Щ�߳�Ӧ����������ͻ�����ϲ���������ϲ���һ��ˮ���ӡ�
 * ���뱣֤����һ��ˮ���������̵߳Ľ�ϱ��뷢������һ��ˮ���Ӳ���֮ǰ��
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
