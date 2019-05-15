package algorithm.listarray;

// Leetcode 240 搜索二维矩阵2
public class SearchMatrix {

    private boolean searchMatrix1(int[][] matrix, int target) {
        boolean found = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == target) {
                    found = true;
                    break;
                }
            }
        }
        return found;
    }

    private boolean searchMatrix2(int[][] matrix, int target) {
        boolean found = false;
        for (int i = 0; i < matrix.length; i++) {
            if (binarySearch(matrix[i], target)) {
                found = true;
                break;
            }
        }
        return found;
    }

    private boolean binarySearch(int[] nums, int target) {
        boolean found = false;
        int right = nums.length - 1;
        int left = 0;

        while (right >= left) {
            int mid = (right + left) >> 1;
            if (nums[mid] == target) {
                found = true;
                break;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return found;
    }

    // 从右上方开始遍历
    private boolean searchMatrixRightUp(int[][] matrix, int target) {
        boolean found = false;
        if (matrix.length == 0)
            return false;
        int col = matrix[0].length;
        int row = matrix.length;
        int c = col - 1;
        int r = 0;
        while (c >= 0 && r < row) {
            if (matrix[r][c] == target) {
                found = true;
                break;
            } else if (target < matrix[r][c]) {
                c--;
            } else {
                r++;
            }
        }
        return found;
    }

    // 从左下方开始遍历
    private boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int nrow = matrix.length;
        int ncol = matrix[0].length;
        int rcur = nrow - 1;
        int ccur = 0;
        while ((rcur >= 0) && (ccur < ncol)) {
            if (matrix[rcur][ccur] == target)
                return true;
            else if (matrix[rcur][ccur] < target)
                ++ccur;
            else
                --rcur;
        }
        return false;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] matrix = {{1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30},
                {18, 21, 23, 26, 30}};
        System.out.println(new SearchMatrix().searchMatrix(matrix, 21));
    }

}
