package algorithm.listarray;

import java.util.ArrayList;
import java.util.List;

// Leetcode 283 移动零
public class MoveZeroes {
    // 第一版
    public void moveZeroesV1(int[] nums) {
        List<Integer> zeroIdx = new ArrayList<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                zeroIdx.add(i);
            }
        }
        int nZeros = zeroIdx.size();
        for (int i = 1; i < zeroIdx.size(); i++) {
            for (int j = zeroIdx.get(i-1) + 1 ; j < zeroIdx.get(i); j++) {
                nums[j - i] = nums[j];
            }
        }
        for (int i = zeroIdx.get(nZeros-1) + 1; i < len; i++) {
            nums[i - nZeros] = nums[i];
        }
        for (int i = len - 1; i >=  len - nZeros ; i--) {
            nums[i] = 0;
        }
    }

    // 优化版
    private void moveZeroes(int[] nums){
        int cur = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] != 0) {
                nums[cur++] = nums[i];
            }
        }
        while (cur < len) {
            nums[cur++] = 0;
        }
    }

    public static void main(String[] args) {
        MoveZeroes mz = new MoveZeroes();
        int[] nums = {0,1,0,3,12};
        mz.moveZeroes(nums);
    }
}
