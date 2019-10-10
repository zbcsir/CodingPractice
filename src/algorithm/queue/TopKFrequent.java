package algorithm.queue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 前 k个高频元素
 */
public class TopKFrequent {
    class KV {
        int key;
        int val;
    }

    /**
     * 基于哈希 + 小顶堆
     * @param nums
     * @param k
     * @return  前k个高频元素
     */
    private List<Integer> topKFrequentV1(int[] nums, int k) {
        if ((k <= 0) || (nums.length == 0)) {
            return new ArrayList<>();
        }
        List<Integer> kvals = new ArrayList<>();
        HashMap<Integer, Integer> freq = new HashMap<>();
        PriorityQueue<KV> topk = new PriorityQueue<>(k, (a, b) -> a.val - b.val);
        List<Integer> keys = new ArrayList<>();
        for (int num: nums) {
            if (freq.containsKey(num)) {
                int f = freq.get(num);
                ++ f;
                freq.put(num, f);
            } else {
                freq.put(num, 1);
                keys.add(num);
            }

        }
        for (int key : keys) {
            KV kv = new KV();
            kv.key = key;
            kv.val = freq.get(kv.key);
            if (topk.size() < k) {
                topk.offer(kv);
            } else {
                KV minKV = topk.peek();
                if (kv.val > minKV.val) {
                    topk.poll();
                    topk.offer(kv);
                }
            }
        }
        for (KV kv : topk) {
            kvals.add(kv.key);
        }
        return kvals;
    }

    /**
     * 基于哈希 + 桶
     * @param nums
     * @param k
     * @return  前k个高频元素
     */
    private List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> kvals = new ArrayList<>(k);
        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        for (int key : freq.keySet()) {
            int cnt = freq.get(key);
            if (buckets[cnt] == null) {
                buckets[cnt] = new ArrayList<>();
            }
            buckets[cnt].add(key);
        }
        for (int i = nums.length; (i >= 0) && (kvals.size() < k) ; i--) {
            if (buckets[i] != null)
                kvals.addAll(buckets[i]);
        }
        return kvals;
    }

    public static void main(String[] args) {
        TopKFrequent tf = new TopKFrequent();
        int[] nums2 = {4,1,-1,2,-1,2,3};
        List<Integer> topK = tf.topKFrequent(nums2, 2);
        for (int key : topK) {
            System.out.print(key + "\t");
        }
    }
}
