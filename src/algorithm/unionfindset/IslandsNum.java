package algorithm.unionfindset;

// leetcode 200
// 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。
// 一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。
// 你可以假设网格的四个边均被水包围。
public class IslandsNum {
    private int m, n;
    private int[] roots;
    int num;

    // 基于并查集
    public int numIslands(char[][] grid) {
        if (grid.length == 0)
            return 0;
        num = 0;
        this.m = grid.length;
        this.n = grid[0].length;
        roots = new int[m*n];
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    roots[i*n+j] = i*n + j;
                    num++;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') continue;
                for (int k = 0; k < 4; k++) {
                    if (isValid(grid, i + dx[k], j + dy[k])) {
                        union(i*n+j, (i+dx[k])*n + j+dy[k]);
                    }
                }
            }
        }

        return num;
    }

    // 基于染色
    public int numIslands2(char[][] grid) {
        if (grid.length == 0)
            return 0;
        int num = 0;
        this.m = grid.length;
        this.n = grid[0].length;
        roots = new int[m*n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    num++;
                    search(grid, i, j);
                }
            }
        }

        return num;
    }

    private void search(char[][] grid, int i, int j) {
        grid[i][j] = '0';
        int[] dx = {0, 0, 1, -1};
        int[] dy = {-1, 1, 0, 0};
        for (int k = 0; k < 4; k++) {
            if (isValid(grid, i + dx[k], j + dy[k])) {
                search(grid, i + dx[k], j + dy[k]);
            }
        }
    }

    private boolean isValid(char[][] grid, int i, int j) {
        return ((i < m) && (i >= 0) && (j < n) && (j >= 0) && grid[i][j] == '1');
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

    public void union(int p, int q) {
        int rootp = findRoot(p);
        int rootq = findRoot(q);
        if (rootp != rootq){
            roots[rootq] = rootp;
            this.num--;
        }

    }

    public static void main(String[] args) {
        IslandsNum islandsNum = new IslandsNum();
        char[][] grid = {{'1', '1','0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};

        char[][] grid2 = {{'1', '1','1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};
        System.out.println(islandsNum.numIslands(grid));
        System.out.println(islandsNum.numIslands(grid2));
    }
}
