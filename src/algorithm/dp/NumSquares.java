package algorithm.dp;

import java.util.Scanner;

/**
 * Leetcode 279
 * ���������� n���ҵ����ɸ���ȫƽ���������� 1, 4, 9, 16, ...��
 * ʹ�����ǵĺ͵��� n������Ҫ����ɺ͵���ȫƽ�����ĸ������١�
 */
public class NumSquares {
    private static int numSquares(int n) {
        if (n <= 1) {
            return 1;
        }
        int[] dp = new int[n+1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 0; i-j*j >= 0 ; j++) {
                dp[i] = Math.min(dp[i], dp[i-j*j]+1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(numSquares(n));
    }
}
