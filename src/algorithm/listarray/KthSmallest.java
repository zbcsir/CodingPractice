package algorithm.listarray;

// ��������е�KС��Ԫ��
public class KthSmallest {
    // ���ڶ��ֲ���
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
        return low; // A Question: Ϊʲô����low�Ϳ��ԣ��������������в����ڵ�����
    }

    public static void main(String[] args) {
        KthSmallest ks = new KthSmallest();
        int[][] matrix = {{1,  5,  9}, {10, 11, 13}, {12, 13, 15}};
        System.out.println(ks.kthSmallestOptim(matrix, 8));
    }
}
