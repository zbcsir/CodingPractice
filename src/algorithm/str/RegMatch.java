package algorithm.str;

// Leetcode 10 正则表达式匹配
public class RegMatch {
    private static boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        if (sLen == 0 && pLen == 0) return true;
        else if (sLen == 0 || pLen == 0) return false;
        boolean[][] match = new boolean[sLen+1][pLen+1];
        match[0][0] = true;
        for (int i = 0; i < pLen; i++) {
            if (p.charAt(i) == '*' && match[0][i-1]) {
                match[0][i+1] = true;
            }
        }
        for (int i = 0; i < sLen; i++) {
            for (int j = 0; j < pLen; j++) {
                if ((s.charAt(i) == p.charAt(j)) || (p.charAt(j) == '.'))
                    match[i+1][j+1] = match[i][j];
                if (p.charAt(j) == '*') {
                    if ((s.charAt(i) != p.charAt(j)) && (p.charAt(j) != '.'))
                        match[i+1][j+1] = match[i][j-1];
                    else
                        match[i+1][j+1] = (match[i+1][j] || match[i+1][j-1] || match[i][j+1]);
                }
            }
        }
        return match[sLen][pLen];
    }

    public static void main(String[] args) {
        String s = "aab";
        String p = "c*a*b";
        String s2 = "aa";
        String p2 = "a*";
        System.out.println(isMatch(s2, p2));
    }
}
