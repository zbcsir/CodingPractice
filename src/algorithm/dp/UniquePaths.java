package algorithm.dp;

/**
 * Leetcode 不同路径1和2，分别对应Leetcode第62题和63题
 */
public class UniquePaths {
    /**
     * Leetcode 62
     * 一个机器人位于一个 m x n 网格的左上角，机器人每次只能向下或者向右移动一步。
     * 机器人试图达到网格的右下角，总共有多少条不同的路径？
     * V1：基于动态规划 dp[i][j] = dp[i-1][j] + dp[i][j-1]
     * @param m  网格行数
     * @param n  网格列数
     * @return   路径数
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
     * Leetcode 62 描述同上
     * V2：基于排列组合 从m+n-2中选出m-1（或者n-1，相等）个有多少种组合
     * @param m  网格行数
     * @param n  网格列数
     * @return   路径数
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
     * 在62题的基础上，考虑网格中有障碍物，那么从左上角到右下角将会有多少条不同的路径
     * @param obstacleGrid  网格值为1说明该格有障碍物
     * @return  路径数
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
        System.out.println("Leetcode 62 ==> 不同路径1");
        int m1 = 3, n1 = 2;
        System.out.println("====== V1 ======");
        System.out.println(uniquePathsV1(m1, n1));
        int m2 = 7, n2 = 3;
        System.out.println(uniquePathsV1(m2, n2));
        System.out.println("====== V2 ======");
        System.out.println(uniquePathsV2(m1, n1));
        System.out.println(uniquePathsV2(m2, n2));
        System.out.println();
        System.out.println("Leetcode 63 ==> 不同路径2");
        int[][] obs = new int[3][3];
        obs[1][1] = 1;
//        obs[2][2] = 1;
        System.out.println(uniquePathsWithObstacles(obs));
    }
}
