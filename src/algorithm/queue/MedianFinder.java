package algorithm.queue;

import java.util.PriorityQueue;


/**
 * 数据流的中位数 Leetcode 295
 */

public class MedianFinder {
    /** initialize your data structure here. */

    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;
    private MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        maxHeap = new PriorityQueue<>((o1, o2) -> o2- o1);
    }

    private void addNum(int num) {
        int sizeSum = minHeap.size() + maxHeap.size();
        if (maxHeap.isEmpty()) {
            maxHeap.add(num);
            return;
        }
        if (minHeap.isEmpty()) {
            if (num > maxHeap.peek()) {
                minHeap.add(num);
            } else {
                minHeap.add(maxHeap.poll());
                maxHeap.add(num);
            }
            return;
        }
        if ((sizeSum & 1) == 0) {
            if (num <= minHeap.peek()) {
                maxHeap.add(num);
            } else {
                maxHeap.add(minHeap.poll());
                minHeap.add(num);
            }
        } else {
            if (num > maxHeap.peek()) {
                minHeap.add(num);
            } else {
                minHeap.add(maxHeap.poll());
                maxHeap.add(num);
            }
        }
    }

    private double findMedian() {
        int sizeNum = minHeap.size() + maxHeap.size();
        double median = 0;
        if ((sizeNum & 1) == 0) {
            if (!minHeap.isEmpty() && !maxHeap.isEmpty()) {
                median = (minHeap.peek() + maxHeap.peek()) / 2.0;
            }
        } else {
            if (!maxHeap.isEmpty()) {
                median = maxHeap.peek();
            }
        }
        return median;
    }

    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf.addNum(-1);
        mf.addNum(-2);
        System.out.println(mf.findMedian());
        mf.addNum(-3);
        System.out.println(mf.findMedian());
        mf.addNum(-4);
        System.out.println(mf.findMedian());
        mf.addNum(-5);
        System.out.println(mf.findMedian());

    }
}
