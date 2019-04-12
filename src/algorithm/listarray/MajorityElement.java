package algorithm.listarray;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MajorityElement {
  
  public static int majorityElement(int[] nums) {
    int num = -1;
    Map<Integer, Integer> timesPerElement = new HashMap<>();
    for(int i=0; i<nums.length; i++) {
      if(!timesPerElement.containsKey(nums[i])) {
        timesPerElement.put(nums[i], 1);
      }else {
        int times = timesPerElement.get(nums[i]);
        times ++;
        timesPerElement.put(nums[i], times);
      }
      
    }
    Set<Integer> keys = timesPerElement.keySet();
    for(int key : keys) {
      if(timesPerElement.get(key) > (nums.length /2) ) {
        num = key;
        break;
      }
    }
    return num;
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    int[] nums = {3,2,3};
    int m = majorityElement(nums);
    System.out.println(m);
  }

}
