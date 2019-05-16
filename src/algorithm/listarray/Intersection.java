package algorithm.listarray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 求两个数组交集
public class Intersection {
    private int[] intersect(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if ((len1 == 0) || (len2 == 0))
            return len1 == 0 ? nums1 : nums2;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> numsRes = new ArrayList<>();
        int p1 = 0;
        int p2 = 0;
        while ((p1 < len1) && (p2 < len2)) {
            if (nums1[p1] == nums2[p2]) {
                numsRes.add(nums1[p1]);
                ++ p1;
                ++ p2;
            } else if (nums1[p1] < nums2[p2]) {
                ++ p1;
            } else {
                ++ p2;
            }
        }
        int[] numsIS = new int[numsRes.size()];
        int cur = 0;
        for (int num : numsRes) {
            numsIS[cur++] = num;
        }
        return numsIS;
    }

    private int[] intersectV2(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if ((len1 == 0) || (len2 == 0))
            return len1 == 0 ? nums1 : nums2;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] numsIS = new int[Math.min(len1, len2)];
        int p1 = 0;
        int p2 = 0;
        int pIS = 0;
        while ((p1 < len1) && (p2 < len2)) {
            if (nums1[p1] == nums2[p2]) {
                numsIS[pIS++] = nums1[p1];
                ++ p1;
                ++ p2;
            } else if (nums1[p1] < nums2[p2]) {
                ++ p1;
            } else {
                ++ p2;
            }
        }
        return Arrays.copyOfRange(numsIS, 0, pIS);
    }

    private void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + "\t");
        }
    }

    public static void main(String[] args) {
        Intersection is = new Intersection();
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        int[] numsIS = is.intersect(nums1, nums2);
        is.printArray(numsIS);
        numsIS = is.intersectV2(nums1, nums2);
        is.printArray(numsIS);
    }
}
