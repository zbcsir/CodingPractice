package algorithm.priorityqueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMax {
  
  public int[] maxSlidingWindow(int[] nums, int k) {
    if(nums.length == 0)
      return new int[0];
    if(k == 1)
      return nums;
    Deque<Integer> window = new ArrayDeque<>();
    int n = nums.length;
    int[] maxs = new int[n-k+1];
    int mi = 0;
    int l = 0;
    for(int j=0; j<n; j++) {
      int i = nums[j];
      if(window.size() == 0) {
        window.add(j);
      }else if(window.size() > 0){
        l = window.peekLast();
        if(l < j-k+1) {
          int p = window.removeFirst();
          System.out.println("p : " + p);
        }
//        System.out.println("peekLast : " + l);
        l = window.peekLast();
        while(i > nums[l]) {
          window.removeLast();
          if(window.isEmpty()) break;
          l = window.peekLast();
        }
        window.add(j);
        if(j >= k-1) {
          maxs[mi] = nums[window.peekFirst()];
//          System.out.println("maxs " + mi + " : " + maxs[mi]);
          mi ++;
        }       
      }
      System.out.println("win size : "+ window.size());
      System.out.println("first element : " + nums[l] + 
          "\t" + l);
    }  
    return maxs;
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub[1,3,1,2,0,5]
    int[] nums = {1,3,1,2,0,5};
    for(int i=0; i< nums.length; i++) {
      System.out.print(nums[i] + "\t");
    }
    System.out.println();
    int k = 3;
    int[] msw = new SlidingWindowMax().maxSlidingWindow(nums, k);
    for(int i=0; i< msw.length; i++) {
      System.out.print(msw[i] + "\t");
    }
  }

}
