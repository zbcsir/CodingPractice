package hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    int[] nums = {-1, 0, 1, 2, -1, -4};
    List<List<Integer>> res = new ThreeSum().threeSum(nums);
    for(List<Integer> t : res) {
      for(int e : t) {
        System.out.print(e + "\t");
      }
      System.out.println();
    }
  }

  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    HashMap<Integer, Integer> num2Idx = new HashMap<>();
    HashSet<Integer> elementNoRepeat = new HashSet<>();     
    for(int i=0; i<nums.length; i++) {
      num2Idx.put(nums[i], i);
      elementNoRepeat.add(i);
    }
    if((elementNoRepeat.size() == 1) && elementNoRepeat.contains(0) 
        && (nums.length > 3)) {
      List<Integer> res_e = new ArrayList<>();
      res_e.add(0);
      res_e.add(0);
      res_e.add(0);
      res.add(res_e);
      return res;
    }   
    Set<List<Integer>> s = new HashSet<>();
    for(int i=0; i<nums.length; i++) {
      for(int j=i+1; j<nums.length; j++) {
        if(j == i) continue;
        int another = 0 - nums[i] - nums[j];
        if(num2Idx.containsKey(another) && (num2Idx.get(another) > Math.max(i, j)) ) {
          List<Integer> res_e = new ArrayList<>();
          res_e.add(nums[i]);
          res_e.add(nums[j]);
          res_e.add(another);
          Collections.sort(res_e);
          s.add(res_e);
        }
      }
    }
    for(List<Integer> st : s) {
      res.add(st);
    }
    return res;
  }
}
