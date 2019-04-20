package algorithm.dp;

public class EditDistance {

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        if (m == 0 || n == 0) {
            return m > 0 ? m:n;
        }
        int[][] md = new int[m+1][n+1];

        for (int i = 0; i <= m; i++) {
            md[i][0] = i;
        }
        for (int i = 0; i <= n; i++) {
            md[0][i] = i;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    md[i][j] = md[i-1][j-1];
                } else {
                    int tmpmin = Math.min(md[i-1][j], md[i][j-1]);
                    md[i][j] = Math.min(md[i-1][j-1], tmpmin) + 1;
                }
            }
        }
        return md[m][n];
    }

    public static void main(String[] args) {
        String w1 = "horse";
        String w2 = "ros";
        int mindis = new EditDistance().minDistance(w1, w2);
        System.out.println(mindis);
    }
}
