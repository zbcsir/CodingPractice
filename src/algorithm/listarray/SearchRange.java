package algorithm.listarray;

/**
 * Leetcode 34 在排序数组中查找元素的第一个和最后一个位置
 */
public class SearchRange {
    private static int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        int len = nums.length;
        if (len == 0 || (len == 1 && nums[0] != target)) {
            return res;
        }
        if (len == 1 && nums[0] == target) {
            return new int[2];
        }
        int low = 0, high = len - 1, mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                int start = mid;
                int end = mid;
                while (start != 0 && nums[start - 1] == target) {
                    -- start;
                }
                while (end != len - 1 && nums[end + 1] == target) {
                    ++ end;
                }
                res[0] = start;
                res[1] = end;
                break;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return res;
    }

    private static void printRes(int[] res) {
        for (int i : res) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums1 = {5,7,7,8,8,10};
        int target1 = 8;
        int[] res1 = searchRange(nums1, target1);
        printRes(res1);
    }
}
