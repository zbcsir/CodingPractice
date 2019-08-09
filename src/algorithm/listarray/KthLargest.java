package algorithm.listarray;

import java.util.PriorityQueue;

// 数组中第 k大的数
public class KthLargest {
    // 基于小顶堆
    private int findKthLargestV1(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k);
        for (int num : nums) {
            if (queue.size() < k) {
                queue.add(num);
            }
            else {
                if (!queue.isEmpty() && queue.peek() < num) {
                    queue.poll();
                    queue.add(num);
                }
            }
        }
        if (!queue.isEmpty()) {
            return queue.peek();
        }
        else {
            return Integer.MIN_VALUE;
        }
    }

    // 采用快排的划分思想划分区域
    private int partation(int[] nums, int low, int high) {
        int tmp = nums[low];
        while (low < high) {
            while ((low < high) && (nums[high] >= tmp)) {
                high--;
            }
            nums[low] = nums[high];
            while ((low < high) && (nums[low] <= tmp)) {
                low++;
            }
            nums[high] = nums[low];
        }
        nums[low] = tmp;
        return low;
    }

    private int helper(int[] nums, int low, int high, int k) {
        int res;
        int idx = partation(nums, low, high);
        if (idx == nums.length - k) {
            return nums[idx];
        }
        else if (idx < nums.length - k) {
            res = helper(nums, idx + 1, high, k);
        }
        else {
            res = helper(nums, low, idx - 1, k);
        }
        return res;
    }

    // 借助快排划分的思想，直到第 k个元素为基准元素
    private int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        return helper(nums, 0, len-1, k);
    }

    public static void main(String[] args) {
        int[] nums1 = {3,2,1,5,6,4};
        int[] nums2 = {3,2,3,1,2,4,5,5,6};
        KthLargest kl = new KthLargest();
        System.out.println(kl.findKthLargestV1(nums1, 2));
        System.out.println(kl.findKthLargestV1(nums2, 4));
        System.out.println(kl.findKthLargest(nums2, 2));
        System.out.println(kl.findKthLargest(nums2, 4));
    }
}
