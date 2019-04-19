package algorithm.trace;

import java.util.HashSet;
import java.util.Set;

//  ˝∂¿Œ Ã‚ 36 and 37
public class Sudoku {

    public boolean isValidSudoku(char[][] board) {
        boolean valid = true;
        for (int i = 0; i < 9; i++) {
            char[] row = board[i];
            if (checkRepeat(row)) {
                valid = false;
//                System.out.println("row break");
                break;
            }
        }
        if (valid) {
            for (int i = 0; i < 9; i++) {
                char[] col = new char[9];
                for (int j = 0; j < 9; j++) {
                    col[j] = board[j][i];
                }
                if (checkRepeat(col)) {
                    valid = false;
//                    System.out.println("col break");
                    break;
                }
            }
        }
        int blockNum = 0;
        if (valid) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    char[][] block = new char[3][3];
                    int t = 0;
                    int numNu = 0;
                    Set<Character> aset = new HashSet<>(9);
                    for (int k = 0; k < 3; k++) {
                        for (int x = 0; x < 3; x++) {
//                            System.out.println("board j : " + (i*3 + j));
//                            System.out.println("board k : " + (i*3 + k));
                            block[k][x] = board[i*3 + k][j*3 + x];
                            if (block[k][x] != '.') {
                                numNu++;
                                aset.add(block[i][j]);
                            }
                        }
                    }
                    if (aset.size() < numNu) {
                        valid = false;
                        break;
                    }
//                    blockNum ++;
//                    System.out.println(t);
//                    if (checkRepeatBlock(block)) {
//                        valid = false;
////                    System.out.println("block break");
//                        break;
//                    }
                }
            }
//            System.out.println("blockNum : " + blockNum);
        }
        return valid;
    }

    public boolean checkRepeat (char[] row) {
        boolean repeat = false;
        Set<Character> aset = new HashSet<>();
        int numNu = 0;
        for (char e : row) {
            if (e != '.') {
                numNu++;
                aset.add(e);
            }
        }
        if (aset.size() < numNu) {
            repeat = true;
        }
        return repeat;
    }

    public boolean checkRepeatBlock (char[][] block) {
        boolean repeat = false;
        int n = block.length;
        Set<Character> aset = new HashSet<>();
        int numNu = 0;
        for (int i = 0; i < n; i++) {
            char[] row = block[i];
            for (int j = 0; j < n; j++) {
                if (block[i][j] != '.') {
                    numNu++;
                    aset.add(block[i][j]);
                }
            }
        }
        if (aset.size() < numNu) {
            repeat = true;
        }
        return repeat;
    }

    public void solveSudokuOld(char[][] board) {
        int num = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    num++;
                }
            }
        }
        System.out.println("num : " + num);
        solve(board, num);
    }

    boolean solve(char[][] board, int n) {
        if (n >= 81){
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(board[i][j] + "\t");
                }
                System.out.println();
            }
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char k = '1'; k < '9'; k++) {
                        if (checkValid(board, i, j, k)) {
                            board[i][j] = k;
                            if (solve(board, n)) {
                                n++;
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    boolean checkValid(char[][] board, int row, int col, char c) {
        boolean valid = true;
        board[row][col] = c;
        Set<Character> a = new HashSet<>();
        int numNu = 0;
        for (int i = 0; i < 9; i++) {
            if (board[row][i] != '.') {
                numNu++;
                a.add(board[row][i]);
            }
        }
        if (a.size() < numNu) {
            valid = false;
        } else {
            numNu = 0;
            a.clear();
            for (int i = 0; i < 9; i++) {
                if (board[row][i] != '.') {
                    numNu++;
                    a.add(board[row][i]);
                }
            }
            if (a.size() < numNu) {
                valid = false;
            } else {
                numNu = 0;
                a.clear();
                int x = row/3, y = col/3;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (board[x + i][y + j] != '.') {
                            a.add(board[x + i][y + j]);
                            numNu++;
                        }
                    }
                }
                if (a.size() < numNu) {
                    valid = false;
                }
            }
        }
        return valid;
    }

    public void solveSudoku(char[][] board) {
        boolean[][] isrowSet = new boolean[9][10];
        boolean[][] iscolSet = new boolean[9][10];
        boolean[][] isblockSet = new boolean[9][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int idx = board[i][j] - '0';
                    int blockIdx = i / 3 * 3 + j / 3;
                    isrowSet[i][idx] = true;
                    iscolSet[j][idx] = true;
                    isblockSet[blockIdx][idx] = true;
                }
            }
        }
        search(board, isrowSet, iscolSet, isblockSet, 0, 0);
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                System.out.print(board[x][y] + "\t");
            }
            System.out.println();
        }
    }

    boolean search(char[][] board, boolean[][] row, boolean[][] col, boolean[][] block, int i, int j) {
        while (board[i][j] != '.') {
            j++;
            if (j > 8) {
                i++;
                j = 0;
            }
            if(i > 8) {
                return true;
            }
        }
        int blockNo = i / 3 * 3 + j / 3;
        for (int k = 1; k <= 9; k++) {
            if (!row[i][k] && !col[j][k] && !block[blockNo][k]) {
                char c = (char)('0' + k);
                board[i][j] = c;
                row[i][k] = true;
                col[j][k] = true;
                block[blockNo][k] = true;
                if (search(board, row, col, block, i, j)) {
                    return true;
                } else {
                    board[i][j] = '.';
                    row[i][k] = false;
                    col[j][k] = false;
                    block[blockNo][k] = false;
                }
            }
        }
        return false;
    }

    private void printBoard(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    void test(int a){
        a = a - 1;
    }
    void test(char[][] board) {
        char c = '0';
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.')
                    board[i][j] = c;
            }
        }
    }

    public static void main(String[] args) {
//        int[][] test = new int[3][3];
//        int x = 0;
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                test[i][j] = (++x);
//            }
//        }
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                System.out.print(test[j][i] + "\t");
//            }
//            System.out.println();
//        }

        char[][] board = {
                {'5','4','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
//        System.out.println(new Sudoku().isValidSudoku(board));
        Sudoku sudoku = new Sudoku();
//        sudoku.test(board);
        sudoku.solveSudoku(board);
        sudoku.printBoard(board);
//        int a = 6;
//        new Sudoku().test(a);
//        System.out.println(a);
    }
}
