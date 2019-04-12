package listarray;

public class MergeSortedArray {
  
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    if(n == 0) return;
    if(m == 0 && nums1.length == n) {
      for(int i=0; i<n; i++) {
        nums1[i] = nums2[i];
      }
    }
    int p1 = m-1, p2 = n-1;
    int p = m+n-1;
    while(p2 >= 0 && p1 >= 0) {
      if(p1 >= 0 && nums1[p1] >= nums2[p2]) {
        nums1[p] = nums1[p1];
        p1 --;
      }else {
        nums1[p] = nums2[p2];
        p2 --;
      }
      p--;
    }
    while(p2 >= 0) {
      nums1[p--] = nums2[p2--];
    }
    for(int i=0; i<nums1.length; i++) {
      System.out.println(nums1[i] + "\t");
    }
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
//    int m=3, n=3;
//    int[] nums1 = {1,2,3,0,0,0};
//    int[] nums2 = {2,5,6};
    int m=1, n=1;
    int[] nums1 = {2,0};
    int[] nums2 = {1};
    new MergeSortedArray().merge(nums1, m, nums2, n);
  }

}
