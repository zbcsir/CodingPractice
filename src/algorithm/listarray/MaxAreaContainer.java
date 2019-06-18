package algorithm.listarray;

// leetcode 盛最多水的容器
public class MaxAreaContainer {
    private static int maxArea(int[] height) {
        int maxArea = 0;
        int low = 0, high = height.length-1;
        while (low < high) {
            if (height[low] < height[high]) {
                maxArea = Math.max(maxArea, height[low]*(high-low));
                ++ low;
            }
            else {
                maxArea = Math.max(maxArea, height[high]*(high-low));
                -- high;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }
}
