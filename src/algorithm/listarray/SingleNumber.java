package listarray;

public class SingleNumber {
  
  public int singleNumber(int[] nums) {
    int res = 0;
    for(int i=0; i<nums.length; i++) {
      res = res^nums[i];
      System.out.println(res);
    }
    return res;
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    
    int[] nums = {4,1,2,1,2};
    int res = new SingleNumber().singleNumber(nums);
//    System.out.println(res);
    System.out.println(4^1);
  }

}
