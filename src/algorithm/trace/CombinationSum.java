package algorithm.trace;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target
 * 找出 candidates 中所有可以使数字和为 target 的组合。
 */
public class CombinationSum {
    private static List<List<Integer>> set = new ArrayList<>();
    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> sol = new ArrayList<>();
        trace(0, candidates, target, sol);
        return set;
    }

    private static void trace(int st, int[] candidates, int target, List<Integer> sol) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            set.add(new ArrayList<>(sol));
        }
        // i从st开始用于去除重复组合
        for (int i = st; i < candidates.length; i++) {
            sol.add(candidates[i]);
            // candidates可以无限使用，故st从i开始
            trace(i, candidates, target-candidates[i], sol);
            sol.remove(sol.size()-1);
        }
    }

    private static void printSet(List<List<Integer>> set) {
        for (List<Integer> sol : set) {
            for (int i : sol) {
                System.out.print(i + " , ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2,3,5};
        int target = 8;
        printSet(combinationSum(candidates, target));
    }
}
