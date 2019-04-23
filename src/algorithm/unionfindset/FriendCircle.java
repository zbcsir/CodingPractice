package algorithm.unionfindset;

public class FriendCircle {
    private int num;
    private int[] roots;
    private int m;
    private boolean[] isfriend;

    // 基于搜索
    boolean[] inFriendCircle;
    // 一个疑问：为什么int count = 0放在这就结果不一样？
    public int findCircleNum(int[][] M) {
        m = M.length;
        int count = 0;
        inFriendCircle = new boolean[m];
        for (int i = 0; i < m; i++) {
            if (!inFriendCircle[i]) {
                inFriendCircle[i] = true;
                findFriend(M, i);
                count++;
            }
        }
        return count;
    }

    private void findFriend(int[][] M, int i) {
        for (int j = 0; j < m; j++) {
            if (!inFriendCircle[j] && M[i][j] == 1) {
                inFriendCircle[j] = true;
                findFriend(M, j);
            }
        }
    }

    // 并查集版本
    public int findCircleNum2(int[][] M) {
        if (M.length == 0)
            return 0;
        int num = 0;
        this.m = M.length;
        roots = new int[m];
        for (int i = 0; i < m; i++) {
            roots[i] = i;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (M[i][j] == 1) {
                    union(i, j);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            if (roots[i] == i)
                ++ num;
        }
        return num;
    }

    private void union(int p, int q) {
        int rootp = findRoot(p);
        int rootq = findRoot(q);
        if (rootp != rootq)
            roots[rootp] = rootq;
    }

    private int findRoot(int p) {
        int root = p;
        while (roots[root] != root) {
            root = roots[root];
        }
        while (roots[p] != p) {
            int tmp = roots[p];
            roots[p] = root;
            p = tmp;
        }
        return root;
    }

    public static void main(String[] args) {
        FriendCircle fc = new FriendCircle();
        int[][] grid1 = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int[][] grid2 = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        int[][] grid3 = {{1, 0, 0, 1},
                         {0, 1, 1, 0},
                         {0, 1, 1, 1},
                         {1, 0, 1, 1}};
        System.out.println(fc.findCircleNum2(grid1));
        System.out.println(fc.findCircleNum2(grid2));
//        System.out.println();
        System.out.println(fc.findCircleNum2(grid3));
    }
}
