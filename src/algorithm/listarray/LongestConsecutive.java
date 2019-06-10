package algorithm.listarray;

import java.util.HashSet;
import java.util.Set;

// Leetcode 128 最长连续序列
// 给定一个未排序的整数数组，找出最长连续序列的长度
public class LongestConsecutive {
    private boolean contains(int[] nums, int e) {
        for (int num : nums) {
            if (num == e)
                return true;
        }
        return false;
    }

    // 基于暴力求解
    private int longestConsecutive(int[] nums) {
        int cnt = 1;
        int cnt_tmp;
        int curNum;
        for (int i : nums) {
            curNum = i + 1;
            cnt_tmp = 1;
            while (contains(nums, curNum)) {
                cnt_tmp ++;
                curNum ++;
            }
            cnt = Math.max(cnt, cnt_tmp);
        }
        return cnt;
    }

    // 基于哈希set
    public int longestConsecutiveByHash(int[] nums) {
        if (nums.length == 0)
            return 0;
        int cnt = 1;
        int cnt_tmp;
        int curNum;
        Set<Integer> hashset = new HashSet<>();
        for (int num : nums) {
            hashset.add(num);
        }
        for (int i : nums) {
            curNum = i + 1;
            cnt_tmp = 1;
            while (hashset.contains(curNum)) {
                cnt_tmp ++;
                curNum ++;
            }
            cnt = Math.max(cnt, cnt_tmp);
        }
        return cnt;
    }

    public static void main(String[] args) {
        LongestConsecutive lc = new LongestConsecutive();
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(lc.contains(nums, 4));
        int cnt = lc.longestConsecutive(nums);
        System.out.println(cnt);
    }
}
