package algorithm.dp;

// leetcode 70 ÅÀÂ¥ÌÝ
// ¶¯Ì¬¹æ»®
public class ClimbStairs {

    private int climbStairs(int n) {
        if((n == 1) || (n == 2)) {
            if(n == 1)
                return 1;
            else
                return 2;
        }
        int[] f = new int[n];
        f[0] = 1;
        f[1] = 2;
        for (int i = 2; i < n; i++) {
            f[i] = f[i-1] + f[i-2];
        }
        return f[n-1];
    }

    public static void main(String[] args) {
        int n = new ClimbStairs().climbStairs(4);
        System.out.println(n);
    }
}
