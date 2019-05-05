package algorithm.str;

import java.util.ArrayList;
import java.util.List;

public class WordSearch {
    // Leetcode 79 单词搜索
    // 给定一个二维网格和一个单词，找出该单词是否存在于网格中
    private int row = 0;
    private int col = 0;
    private boolean[][] found;
    public boolean existV1(char[][] board, String word) {
        boolean exist = false;
        row = board.length;
        col = board[0].length;
        found = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == word.charAt(0)) {
                    found[i][j] = true;
                    if (searchV1(board, i, j, word, 1)) {
                        return true;
                    }
                    found[i][j] = false;
                }
            }
        }
        return exist;
    }

    private boolean searchV1(char[][] board, int r, int c, String s, int idx) {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {-1, 1, 0, 0};
        if (idx == s.length()) {
            return true;
        }
        for (int i = 0; i < dx.length; i++) {
            int newr = r + dx[i];
            int newc = c + dy[i];
            if (valid(newr, newc) && (s.charAt(idx) == board[newr][newc])) {
                found[newr][newc] = true;
                if (searchV1(board, newr, newc, s, idx + 1))
                    return true;
                found[newr][newc] = false;
            }
        }
        return false;
    }

    // 优化
    private boolean exist(char[][] board, String word) {
        row = board.length;
        col = board[0].length;
        found = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (search(board, i, j, word, 0))
                    return true;
            }
        }
        return false;
    }

    private boolean search(char[][] board, int r, int c, String s, int idx) {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {-1, 1, 0, 0};
        if (idx == s.length()) {
            return true;
        }
        if (!valid(r, c))
            return false;
        if (board[r][c] != s.charAt(idx))
            return false;
        found[r][c] = true;
        if (search(board, r + dx[0], c + dy[0], s, idx+1) ||
                search(board, r + dx[1], c + dy[1], s, idx+1) ||
                search(board, r + dx[2], c + dy[2], s, idx+1) ||
                search(board, r + dx[3], c + dy[3], s, idx+1))
            return true;
        else {
            found[r][c] = false;
            return false;
        }
    }

    private boolean valid(int r, int c) {
        return !((r >= row) || (r < 0) || (c >= col) || (c < 0) || (found[r][c]));
    }

    // Leetcode 212 单词搜索2
    // TODO
    public List<String> findWords(char[][] board, String[] words) {
        List<String> wordsExist = new ArrayList<>();

        return wordsExist;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        String word1 = "ABCCED";
        String word2 = "SEE";
        String word3 = "ABCB";
        WordSearch wordSearch = new WordSearch();
        System.out.println(wordSearch.exist(board, word1));
        System.out.println(wordSearch.exist(board, word2));
        System.out.println(wordSearch.exist(board, word3));
    }
}
