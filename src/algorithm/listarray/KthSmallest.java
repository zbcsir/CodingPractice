package algorithm.listarray;

// 有序矩阵中第K小的元素
public class KthSmallest {
    // 基于二分查找
    private int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0];
        int high = matrix[n-1][n-1];
        while (low < high) {
            int mid = (high - low) / 2 + low;
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; (j < n) && (matrix[i][j] <= mid); j++) {
                    ++ cnt;
                }
            }
            if (cnt < k)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }

    private int kthSmallestOptim(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0];
        int high = matrix[n-1][n-1];
        while (low < high) {
            int mid = (high - low) / 2 + low;
            int cnt = 0;
            int j = n - 1;
            for (int i = 0; i < n; i++) {
                while ((j >= 0) && (matrix[i][j] > mid)) {
                    -- j;
                }
                cnt += (j + 1);
            }
            if (cnt < k)
                low = mid + 1;
            else
                high = mid;
        }
        return low; // A Question: 为什么返回low就可以，不会碰到矩阵中不存在的数吗
    }

    public static void main(String[] args) {
        KthSmallest ks = new KthSmallest();
        int[][] matrix = {{1,  5,  9}, {10, 11, 13}, {12, 13, 15}};
        System.out.println(ks.kthSmallestOptim(matrix, 8));
    }
}
