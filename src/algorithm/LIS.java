package algorithm;

import java.util.ArrayList;
import java.util.List;

// 最长上升子序列
public class LIS {

    // 基于动态规划求解 O(N^2)
    public int lengthOfLISDP(int[] nums) {
        int[] lens = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            lens[i] = 1;
        }
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && (lens[j] + 1 > lens[i])) {
                    lens[i] = lens[j] + 1;
                }
            }
            if (lens[i] > maxLen)
                maxLen = lens[i];
        }
        return maxLen;
    }

    public int lengthOfLISV2(int[] nums) {
        List<Integer> lis = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (lis.size() == 0) {
                lis.add(nums[i]);
            } else {
                if (lis.get(lis.size()-1) < nums[i]) {
                    lis.add(nums[i]);
                } else {
                    for (int j = 0; j < lis.size(); j++) {
                        if (lis.get(j) > nums[i]) {
                            lis.set(j, nums[i]);
                        }
                    }
                }
            }
        }
        return lis.size();
    }

    // 结合二分法求解 O(NlogN)
    public int lengthOfLIS(int[] nums) {
        List<Integer> lis = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (lis.size() == 0) {
                lis.add(nums[i]);
            } else if (lis.size() == 1) {
                if (lis.get(0) == nums[i])
                    continue;
                if (lis.get(0) < nums[i]){
                    lis.add(nums[i]);
                }else {
                    lis.set(0, nums[i]);
                }
            } else {
                int lisSize = lis.size();
                int right = lisSize - 1;
                int left = 0;
                int mid = 0;
                if (lis.get(right) < nums[i]) {
                    lis.add(nums[i]);
                } else if (nums[i] < lis.get(0)) {
                    lis.set(0, nums[i]);
                } else {
                    while (right > left) {
                        mid = left + ((right - left) >> 1);
                        if (lis.get(mid) >= nums[i]) {
                            right = mid;
                        } else {
                            left = mid+1;
                        }
                    }
                    lis.set(right, nums[i]);
                }

            }
        }
        return lis.size();
    }

    public static void main(String[] args) {
        int[] seq = {10,9,2,5,3,7,101,18};
        int[] seq2 = {3,5,6,2,5,4,19,5,6,7,12};
        LIS lis = new LIS();
        int maxLen = lis.lengthOfLIS(seq2);
        System.out.println(maxLen);
    }
}
