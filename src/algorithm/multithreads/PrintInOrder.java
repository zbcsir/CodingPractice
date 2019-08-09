package algorithm.multithreads;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

/**
 * Leetcode 1114 多线程按序打印
 * 基于CountDownLatch
 */
public class PrintInOrder {
    private CountDownLatch cd1, cd2;
    private PrintInOrder() {
        cd1 = new CountDownLatch(1);
        cd2 = new CountDownLatch(1);
    }

    private void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        cd1.countDown();
    }

    private void second(Runnable printSecond) throws InterruptedException {
        cd1.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        cd2.countDown();
    }

    private void third(Runnable printThird) throws InterruptedException {
        cd2.await();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }

    public static void main(String[] args) {
        Foo f = new Foo();
        PrintInOrder p = new PrintInOrder();
        try {
            p.first(() -> System.out.print("one"));
            p.second(() -> System.out.print("two"));
            p.third(() -> System.out.print("three"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            f.first(() -> System.out.print("one"));
            f.second(() -> System.out.print("two"));
            f.third(() -> System.out.print("three"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

/**
 * Leetcode 1114 多线程按序打印
 * 基于信号量
 */
class Foo {

    private Semaphore s1, s2, s3;
    Foo() {
        s1 = new Semaphore(1);
        s2 = new Semaphore(0);
        s3 = new Semaphore(0);
    }

    void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        s1.acquire();
        printFirst.run();
        s2.release();
    }

    void second(Runnable printSecond) throws InterruptedException {
        s2.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        s3.release();
    }

    void third(Runnable printThird) throws InterruptedException {
        s3.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
