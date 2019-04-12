package algorithm;

import java.util.ArrayList;
import java.util.List;

// Leetcode 120题，采用动态规划
public class MinDisTriangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        for (int i = row - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                int md = Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1)) + triangle.get(i).get(j);
                triangle.get(i).set(j, md);
            }
        }
        return triangle.get(0).get(0);
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        row.add(2);
        triangle.add(row);
        row.clear();
        row.add(3);
        row.add(4);
        triangle.add(row);
        row.clear();
        row.add(6);
        row.add(5);
        row.add(7);
        triangle.add(row);
        row.clear();
        row.add(4);
        row.add(1);
        row.add(8);
        row.add(3);
        triangle.add(row);
        int sum = new MinDisTriangle().minimumTotal(triangle);
        System.out.println(sum);
    }
}
