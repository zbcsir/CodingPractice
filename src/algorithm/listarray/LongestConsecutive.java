package algorithm.listarray;

import java.util.Arrays;
import java.util.HashMap;
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
    private int longestConsecutiveByHash(int[] nums) {
        long startTime = System.currentTimeMillis();
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
        long endTime = System.currentTimeMillis();
        System.out.println("Time : " + (endTime - startTime));
        return cnt;
    }

    // 基于排序
    private int longestConsecutiveBySort(int[] nums) {
        long startTime = System.currentTimeMillis();
        if (nums.length == 0) return 0;
        int cnt = 1;
        int maxCnt = 1;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i-1] == 1) {
                ++ cnt;
                maxCnt = Math.max(maxCnt, cnt);
            }
            else if (nums[i] != nums[i-1])
                cnt = 1;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time : " + (endTime - startTime));
        return maxCnt;
    }

    // 基于并查集 好像并不如排序快，就不做了
    private int longestConsecutiveByUF(int[] nums) {
        if (nums.length <= 1)  return nums.length;

        return 0;
    }

    // 返回e的顶层父节点
    private int find(HashMap<Integer, Integer> uf, int e) {
        if (uf.get(e) == e) return e;
        int parent = find(uf, uf.get(e));
        uf.put(e, parent);
        return parent;
    }

    // 另一种基于哈希set的方法，遍历的时候不断删除来减少重复遍历
    private int longestConsecutiveByHash2(int[] nums) {
        if (nums.length < 2) return nums.length;
        int maxLen = 1;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int num : nums) {
            int cur = num;
            int maxLenTmp = 0;
            while (set.remove(cur)) -- cur;
            maxLenTmp += (num - cur);
            cur = num + 1;
            while (set.remove(cur)) ++ cur;
            maxLenTmp += (cur - num - 1);
            maxLen = maxLenTmp > maxLen ? maxLenTmp : maxLen;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        LongestConsecutive lc = new LongestConsecutive();
        int[] nums = {100, 4, 200, 1, 3, 2};
        int cnt = lc.longestConsecutiveByHash(nums);
        System.out.println("res : " + cnt);
        int cnt2 = lc.longestConsecutiveBySort(nums);
        System.out.println("res : " + cnt2);
        int cnt3 = lc.longestConsecutiveByHash2(nums);
        System.out.println("res : " + cnt3);
    }
}
