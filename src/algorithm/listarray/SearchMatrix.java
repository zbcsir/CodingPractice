package algorithm.listarray;

public class SearchMatrix {
  
  public boolean searchMatrix1(int[][] matrix, int target) {
    boolean found = false;
    for(int i=0; i<matrix.length; i++) {
      for(int j=0; j<matrix[0].length; j++) {
        if(matrix[i][j] == target) {
          found = true;
          break;
        }
      }
    }
    return found;
  }
  
  public boolean searchMatrix2(int[][] matrix, int target) {
    boolean found = false;
    for(int i=0; i<matrix.length; i++) {
      if(binarySearch(matrix[i], target)) {
        found = true;
        break;
      }
    }
    return found;
  }
  
  public boolean binarySearch(int[] nums, int target) {
    boolean found = false;
    int right = nums.length-1;
    int left = 0;
    
    while(right >= left) {
      int mid = (right + left) >> 1;
      if(nums[mid] == target) {
        found = true;
        break;
      }else if(nums[mid] > target) {
        right = mid - 1;
      }else {
        left = mid + 1;
      }
    }
    return found;
  }
  
  public boolean searchMatrix(int[][] matrix, int target) {
    boolean found = false;
    if(matrix.length == 0 || matrix == null)
      return false;
    int col = matrix[0].length;
    int row = matrix.length;
    int c = col-1;
    int r = 0;
    while(c >= 0 && r < row) {
      if(matrix[r][c] == target) {
        found = true;
        break;
      }else if(target < matrix[r][c]) {
        c--;
      }else {
        r++;
      }
    }
    return found;
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    int[][] matrix = {{1, 4, 7, 11, 15},
                      {2, 5, 8, 12, 19},
                      {3, 6,  9, 16, 22},
                      {10, 13, 14, 17, 24},
                      {18, 21, 23, 26, 30},
                      {18, 21, 23, 26, 30}};
    System.out.println(new SearchMatrix().searchMatrix(matrix, 20));
//    System.out.println(new SearchMatrix().binarySearch(matrix[0], 19));
  }

}
