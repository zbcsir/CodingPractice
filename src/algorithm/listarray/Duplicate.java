package algorithm.listarray;

import java.util.HashSet;
import java.util.Set;

// leetcode ÖØ¸´ÔªËØ
public class Duplicate {
    private boolean containsDuplicate(int[] nums) {
        int len = nums.length;
        if (len <= 1)
            return false;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.contains(num))
                set.add(num);
            else
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Duplicate dup = new Duplicate();
        dup.containsDuplicate(nums);
    }
}
