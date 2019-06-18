package algorithm.str;

// 最长有效括号
public class LongestValidParentheses {
    // 基于动态规划
    // 时间复杂度 O(N)
    // 空间复杂度 O(N)
    private static int longestValidParenthesesDP(String s) {
        int strLen = s.length();
        if (strLen < 2) return 0;
        int[] len = new int[strLen];
        int maxValidLen = 0;
        for (int i = 1; i < strLen ; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i-1) == '(') {
                    len[i] = (i >= 2 ? len[i-2] : 0) + 2;
                } else {
                    if ((i > len[i-1]) && (s.charAt(i-len[i-1]-1) == '(')) {
                        len[i] = len[i-1] + 2 + (i-len[i-1] >= 2 ? len[i-len[i-1]-2] : 0);
                    }
                }
            }
            if (len[i] > maxValidLen)
                maxValidLen = len[i];
        }
        return maxValidLen;
    }

    public static void main(String[] args) {
        String s1 = "(()";
        System.out.println(longestValidParenthesesDP(s1));
        String s2 = ")()())";
        System.out.println(longestValidParenthesesDP(s2));
    }
}
