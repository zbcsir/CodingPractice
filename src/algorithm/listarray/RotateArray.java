package algorithm.listarray;

// Leetcode 旋转数组
// 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数
public class RotateArray {

    // 空间复杂度 O(n)
    // 新开辟一个数组
    private int[] rotateV1(int[] nums, int k) {
        int len = nums.length;
        if ((k == 0) || (len <= 1))
            return nums;
        int[] newNums = new int[len];
        for (int i = 0; i < len; i++) {
            int newIdx = (i + k) % len;
            newNums[newIdx] = nums[i];
        }
        return newNums;
    }

    // 空间复杂度 O(1)
    // 原地修改
    private void rotateV2(int[] nums, int k) {
        int len = nums.length;
        if ((k == 0) || (len <= 1))
            return;
        int pre;
        int cur = nums[0];
        int idx = 0;
        int start = 0;
        for (int i = 0; i < len; i++) {
            pre = cur;
            idx = (idx + k) % len;
            cur = nums[idx];
            nums[idx] = pre;
            if ((idx == start) && (start < len-1)) {
                idx = ++start;
                cur = nums[idx];
            }
        }
    }

    // 递归  时间复杂度 O(n)，空间复杂度 O(1)
    // 先逆置前n-k个元素，再逆置后k个元素，最后逆置整个数组
    private void rotate(int[] nums, int k) {
        int len = nums.length;
        if ((k == 0) || (len <= 1))
            return;
        k = k % len;
        reverse(nums, 0, len-k-1);
        reverse(nums, len-k, len - 1);
        reverse(nums, 0, len-1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = tmp;
        }
    }

    public static void main(String[] args) {
        RotateArray ra = new RotateArray();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        ra.rotateV1(nums, 3);
        ra.rotateV2(nums, 3);
        ra.rotate(nums, 3);
    }
}
