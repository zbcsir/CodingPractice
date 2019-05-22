package algorithm.priorityqueue;

import java.util.PriorityQueue;

// 数据流中的第 k大数
public class KthLargest {

    private PriorityQueue<Integer> pq;
    private int k;

    private KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>(k);
        this.k = k;
        for (int i : nums) {
            if (pq.size() < k) {
                pq.offer(i);
            } else {
                if (i > pq.peek()) {
                    pq.poll();
                    pq.offer(i);
                }
            }
        }
    }

    public int add(int val) {
        int kth;
        if (pq.size() < this.k) {
            pq.offer(val);
            return pq.peek();
        }
        int minCur = pq.peek();
        if (val <= minCur) {
            kth = minCur;
        } else {
            pq.poll();
            pq.offer(val);
            kth = pq.peek();
        }
        return kth;
    }

    public static void main(String[] args) {
        int k = 2;
        int[] arr2 = {0};
        int[] numsToAdd = {-1, 1, -2, -4, 3};
        KthLargest kthLargest = new KthLargest(k, arr2);
        int kth;
        for (int num : numsToAdd) {
            kth = kthLargest.add(num);
            System.out.println(kth);
        }
    }

}
