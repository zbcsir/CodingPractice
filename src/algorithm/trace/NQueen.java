package algorithm.trace;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NQueen {
    private List<List<String>> res;
    private List<String> resOne;
    private List<Integer> colNoRes;
    private Set<Integer> xminusy, xplusy, cols;

    // LeetCode 51题，N皇后
    private List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        resOne = new ArrayList<>();
        colNoRes = new ArrayList<>();
        xminusy = new HashSet<>(2 * n);
        xplusy = new HashSet<>(2 * n);
        cols = new HashSet<>(n);
        search(n, 0, xminusy, xplusy, cols, colNoRes);
        return res;
    }

    private void search(int n, int row, Set<Integer> minus, Set<Integer> plus, Set<Integer> cols, List<Integer> colNo){
        if (row == n) {
            List<String> one = new ArrayList<>(n);
            for (int c : colNo) {
                StringBuilder tmp = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (j == c) {
                        tmp.append("Q");
                        continue;
                    }
                    tmp.append(".");
                }
                one.add(tmp.toString());
            }
            res.add(one);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (cols.contains(i) || minus.contains(row - i) || plus.contains(row + i)) {
                continue;
            }
            cols.add(i);
            minus.add(row - i);
            plus.add(row + i);
            colNo.add(i);

            search(n, row + 1, minus, plus, cols, colNo);

            cols.remove(i);
            minus.remove(row - i);
            plus.remove(row + i);
            colNo.remove(colNo.size()-1);
        }
    }


    // LeetCode 52题，N皇后问题2
    private int num = 0;
    private int totalNQueensOld(int n) {
        colNoRes = new ArrayList<>();
        xminusy = new HashSet<>(2 * n);
        xplusy = new HashSet<>(2 * n);
        cols = new HashSet<>(n);
        search2(n, 0, xminusy, xplusy, cols, colNoRes);
        System.out.println(num);
        return num;
    }

    private void search2(int n, int row, Set<Integer> minus, Set<Integer> plus, Set<Integer> cols, List<Integer> colNo){
        if (row == n) {
            num++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (cols.contains(i) || minus.contains(row - i) || plus.contains(row + i)) {
                continue;
            }
            cols.add(i);
            minus.add(row - i);
            plus.add(row + i);
            colNo.add(i);

            search2(n, row + 1, minus, plus, cols, colNo);

            cols.remove(i);
            minus.remove(row - i);
            plus.remove(row + i);
            colNo.remove(colNo.size()-1);
        }
    }

    // N皇后位运算求解
    private int count = 0;
    private void search3 (int n, int row, int col, int ld, int rd) {
        if (row >= n) {
            count += 1;
        }
        int ap = (~(col | ld | rd) & (1 << n) - 1);
        while (ap > 0) {
            int tp = ap & (-ap);
            search3(n, row + 1, (col | tp), (ld | tp) << 1, (rd | tp) >> 1);
            ap = ap & (ap - 1);
        }
    }

    private int totalNQueens(int n) {
        search3(n, 0, 0, 0, 0);
        System.out.println(count);
        return count;
    }

    public static void main(String[] args) {
        new NQueen().totalNQueens(4);
    }
}
