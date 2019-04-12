package hash;

import java.util.HashMap;

public class TwoSum {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    int[] nums = {2, 7, 7, 11, 15};
    int target = 9;
    int[] res = new TwoSum().twoSum1(nums, target);
    System.out.println(res[0] + "\t" + res[1]);
  }

  public int[] twoSum1(int[] nums, int target) {
    int[] res = new int[2];
    HashMap<Integer, Integer> num2Idx = new HashMap<>();
    for(int i=0; i<nums.length; i++) {
      num2Idx.put(nums[i], i);
    }
    for(int i=0; i<nums.length; i++) {
      if(num2Idx.containsKey(target - nums[i]) && (num2Idx.get(target 
          - nums[i]) != i)) {
        res[0] = i;
        res[1] = num2Idx.get(target - nums[i]);
        break;
      }
    }
    return res;
  }
  
  public int[] twoSum(int[] nums, int target) {
    int[] res = new int[2];
    HashMap<Integer, Integer> num2Idx = new HashMap<>();
    for(int i=0; i<nums.length; i++) {
      int another = target - nums[i];
      if(num2Idx.containsKey(another)) {
        res[0] = i;
        res[1] = num2Idx.get(another);
        break;
      }
      num2Idx.put(nums[i], i);
    }
    return res;
  }
}
