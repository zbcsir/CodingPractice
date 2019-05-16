package algorithm.listarray;

// 递增的三元子序列
public class Triplet {
    //针对连续递增序列
    private boolean increasingTripletSimple(int[] nums) {
        int window = 3;
        int len = nums.length;
        if (len < window)
            return false;
        for (int i = 0; i <= nums.length - window; i++) {
            boolean increase = true;
            for (int j = i + 1; j < i + window; j++) {
                increase &= (nums[j] > nums[j-1]);
            }
            if (increase)
                return true;
        }
        return false;
    }

    // 面向非连续递增子序列 （Leetcode 334）
    private boolean increasingTriplet(int[] nums) {
        int firstLarge = Integer.MAX_VALUE;
        int secondLarge = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= firstLarge) {
                firstLarge = num;
            } else if (num <= secondLarge) {
                secondLarge = num;
            } else
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4,5};
        int[] nums2 = {5,4,3,2,1};
        int[] nums3 = {2,1,5,0,4,6};
        int[] nums4 = {5,1,5,5,2,5,4};
        Triplet t = new Triplet();
        System.out.println(t.increasingTriplet(nums1));
        System.out.println(t.increasingTriplet(nums2));
        System.out.println(t.increasingTriplet(nums3));
        System.out.println(t.increasingTriplet(nums4));

    }
}
