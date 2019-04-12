package algorithm;

public class MaxProductSubarray {

    public int maxProduct(int[] nums) {
        int[] maxProduct = new int[nums.length];
        int[] minProduct = new int[nums.length];
        maxProduct[0] = nums[0];
        minProduct[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= 0) {
                maxProduct[i] = Math.max(maxProduct[i-1] * nums[i], nums[i]);
                minProduct[i] = Math.min(minProduct[i-1] * nums[i], nums[i]);
            } else {
                maxProduct[i] = Math.max(minProduct[i-1] * nums[i], nums[i]);
                minProduct[i] = Math.min(maxProduct[i-1] * nums[i], nums[i]);
            }
        }
        int maxP = maxProduct[0];
        for (int i = 1; i < maxProduct.length; i++) {
            if (maxProduct[i] > maxP) {
                maxP = maxProduct[i];
            }
        }
        return maxP;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,-2,4};
        System.out.println(new MaxProductSubarray().maxProduct(nums));
    }
}
