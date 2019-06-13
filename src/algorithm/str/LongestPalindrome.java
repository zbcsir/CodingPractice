package algorithm.str;

// 最长回文子串
public class LongestPalindrome {
    private static String longestPalindrome(String s) {
        int len = s.length();
        if (len <= 1) return s;
        boolean[][] pd = new boolean[len][len];
        int start = 0;
        int maxLen = 1;
        for (int i = 0; i < len; i++) {
            pd[i][i] = true;
            if ((i < len - 1) && (s.charAt(i) == s.charAt(i+1))) {
                pd[i][i+1] = true;
                start = i;
                maxLen = 2;
            }

        }
        for (int k = 3; k <= len; k++) {
            for (int i = 0; i < len + 1 - k; i++) {
                int j = i + k - 1;
                if ((s.charAt(i) == s.charAt(j)) && pd[i + 1][j - 1]) {
                    pd[i][j] = true;
                    start = i;
                    maxLen = k;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }

    public static void main(String[] args) {
        String s1 = "babad";
        String s2 = "cbbd";
        String s3 = "abacab";
        System.out.println(longestPalindrome(s1));
        System.out.println(longestPalindrome(s2));
        System.out.println(longestPalindrome(s3));
    }
}
