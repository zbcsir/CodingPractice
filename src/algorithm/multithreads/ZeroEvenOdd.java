package algorithm.multithreads;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * Leetcode 1116 ��ӡ������ż��
 *
 * ��ͬ��һ�� ZeroEvenOdd ��ʵ�����ᴫ�ݸ�������ͬ���̣߳�
 *
 * �߳� A ������ zero()����ֻ��� 0 ��
 * �߳� B ������ even()����ֻ���ż����
 * �߳� C ������ odd()����ֻ���������
 *
 * ʾ����
 * ���룺n = 5
 * �����"0102030405"
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
