package algorithm.dp;

/**
 * Leetcode ��ͬ·��1��2���ֱ��ӦLeetcode��62���63��
 */
public class UniquePaths {
    /**
     * Leetcode 62
     * һ��������λ��һ�� m x n ��������Ͻǣ�������ÿ��ֻ�����»��������ƶ�һ����
     * ��������ͼ�ﵽ��������½ǣ��ܹ��ж�������ͬ��·����
     * V1�����ڶ�̬�滮 dp[i][j] = dp[i-1][j] + dp[i][j-1]
     * @param m  ��������
     * @param n  ��������
     * @return   ·����
     */
    private static int uniquePathsV1(int m, int n) {
        if (m <= 0 || n <= 0) {
            return -1;
        }
        int[][] pathNum = new int[m][n];
        for (int i = 0; i < m; i++) {
            pathNum[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            pathNum[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                pathNum[i][j] = pathNum[i-1][j] + pathNum[i][j-1];
            }
        }
        return pathNum[m-1][n-1];
    }

    /**
     * Leetcode 62 ����ͬ��
     * V2������������� ��m+n-2��ѡ��m-1������n-1����ȣ����ж��������
     * @param m  ��������
     * @param n  ��������
     * @return   ·����
     */
    private static int uniquePathsV2(int m, int n) {
        int down = m + n - 2;
        int up = m - 1;
        double res = 1;
        for (int i = 1; i <= up; i++) {
            res = res * (double) (down - up + i) / i;
        }
        return (int) res;
    }

    /**
     * Leetcode 63
     * ��62��Ļ����ϣ��������������ϰ����ô�����Ͻǵ����½ǽ����ж�������ͬ��·��
     * @param obstacleGrid  ����ֵΪ1˵���ø����ϰ���
     * @return  ·����
     */
    private static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (n == 0) {
            return -1;
        }
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1) {
            return 0;
        }
        int[][] pathNum = new int[m][n];
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            }
            pathNum[i][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            }
            pathNum[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    pathNum[i][j] = pathNum[i-1][j] + pathNum[i][j-1];
                } else {
                    pathNum[i][j] = 0;
                }
            }
        }
        return pathNum[m-1][n-1];
    }

    public static void main(String[] args) {
        System.out.println("Leetcode 62 ==> ��ͬ·��1");
        int m1 = 3, n1 = 2;
        System.out.println("====== V1 ======");
        System.out.println(uniquePathsV1(m1, n1));
        int m2 = 7, n2 = 3;
        System.out.println(uniquePathsV1(m2, n2));
        System.out.println("====== V2 ======");
        System.out.println(uniquePathsV2(m1, n1));
        System.out.println(uniquePathsV2(m2, n2));
        System.out.println();
        System.out.println("Leetcode 63 ==> ��ͬ·��2");
        int[][] obs = new int[3][3];
        obs[1][1] = 1;
//        obs[2][2] = 1;
        System.out.println(uniquePathsWithObstacles(obs));
    }
}
