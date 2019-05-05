package algorithm.listarray;

import java.util.ArrayList;
import java.util.List;

public class Permute {
    // Leetcode 46 全排列
    // 给定一个没有重复数字的序列，返回其所有可能的全排列
    private List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0)
            return res;
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

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Permute p = new Permute();
        List<List<Integer>> res = p.permute(nums);
        p.printRes(res);
    }
}
