package algorithm.priorityqueue;

import java.util.ArrayDeque;
import java.util.Deque;

// 滑动窗口最大值
public class SlidingWindowMax {
    private int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        Deque<Integer> window = new ArrayDeque<>(k);
        if ((len == 0) || (k <= 0))
            return new int[0];
        if (k == 1)
            return nums;
        int[] maxs = new int[len-k+1];
        int idx = 0;
        for (int i = 0; i < len; i++) {
            if (window.isEmpty())
                window.add(i);
            else {
                if (window.peekFirst() <= i - k) {
                    window.removeFirst();
                }
                while (!window.isEmpty() && nums[window.peekFirst()] <= nums[i]) {
                    window.removeFirst();
                }
                while (!window.isEmpty() && nums[window.peekLast()] < nums[i])
                    window.removeLast();
                window.add(i);
                if ((i >= k - 1) && !window.isEmpty()) {
                    maxs[idx++] = nums[window.peekFirst()];
                }
            }
        }
        return maxs;
    }

    public static void main(String[] args) {
        int[] nums3 = {1, 3, 1, 2, 0, 5};
        int k = 3;
        int[] msw = new SlidingWindowMax().maxSlidingWindow(nums3, k);
        for (int i : msw) {
            System.out.print(i + "\t");
        }
    }

}
