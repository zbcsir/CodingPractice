package algorithm.priorityqueue;

import java.util.PriorityQueue;

public class KthLargest {

    private PriorityQueue<Integer> pq;

    private KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>(k);
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
        // TODO Auto-generated method stub
        int k = 3;
        int[] arr = {4, 5, 8, 2};
        KthLargest kthLargest = new KthLargest(k, arr);
        int kth;
        kth = kthLargest.add(3);
        System.out.println(kth);
        kth = kthLargest.add(5);
        System.out.println(kth);
        kth = kthLargest.add(10);
        System.out.println(kth);
        kth = kthLargest.add(9);
        System.out.println(kth);
        kth = kthLargest.add(4);
        System.out.println(kth);
    }

}
