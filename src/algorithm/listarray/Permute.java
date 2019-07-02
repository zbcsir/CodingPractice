package algorithm.listarray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permute {

    /**
     * Leetcode 46 全排列
     * 给定一个没有重复数字的序列，返回其所有可能的全排列
     * @param nums  给定的序列
     * @return  所有可能的全排列
     */
    private List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }
        recursion(nums, 0, res);
        return res;
    }

    private void recursion(int[] nums, int index, List<List<Integer>> res) {
        if (index == nums.length - 1) {
            List<Integer> tmpRes = new ArrayList<>();
            for (int i : nums) {
                tmpRes.add(i);
            }
            res.add(tmpRes);
            return;
        }

        for (int i = index; i < nums.length; i++) {
            int tmp = nums[index];
            nums[index] = nums[i];
            nums[i] = tmp;
            recursion(nums, index + 1, res);
            tmp = nums[index];
            nums[index] = nums[i];
            nums[i] = tmp;
        }
    }

    private void printRes (List<List<Integer>> res) {
        for (List<Integer> eleRes : res) {
            for (Integer e : eleRes) {
                System.out.print(e + "\t");
            }
            System.out.println();
        }
    }

    private void printArray(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " -> ");
        }
        System.out.println();
    }

    /**
     * Leetcode 31 下一个排列
     * @param nums  当前排列
     */
    private void nextPermutation(int[] nums) {
        int len = nums.length;
        int i = len - 2;
        while ((i >= 0) && (nums[i] >= nums[i+1])) {
            -- i;
        }
        if (i >= 0) {
            int j = len - 1;
            while ((j >= 0) && (nums[j] <= nums[i])) {
                -- j;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void swap(int[] a, int i, int j) {
        a[i] = a[i] ^ a[j];
        a[j] = a[i] ^ a[j];
        a[i] = a[i] ^ a[j];
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            ++ i;
            -- j;
        }
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1};
        int[] nums2 = {1,1,5};
        int[] nums3 = {1,2,3};
        Permute p = new Permute();
//        List<List<Integer>> res = p.permute(nums);
//        p.printRes(res);
        p.nextPermutation(nums);
        p.nextPermutation(nums2);
        p.nextPermutation(nums3);
        p.printArray(nums);
        p.printArray(nums2);
        p.printArray(nums3);
    }
}
