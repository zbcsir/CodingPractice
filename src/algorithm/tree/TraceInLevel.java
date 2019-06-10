package algorithm.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

// 二叉树按层遍历
public class TraceInLevel {
    // 基于队列
    private static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> perLevel = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode t = queue.poll();
                if (t != null) {
                    perLevel.add(t.val);
                    if (t.left != null) {
                        queue.add(t.left);
                    }
                    if (t.right != null) {
                        queue.add(t.right);
                    }
                }
            }
            res.add(perLevel);
        }
        return res;
    }

    // 基于递归
    private static List<List<Integer>> levelOrderRecur(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> rootVal = new ArrayList<>(1);
        rootVal.add(root.val);
        res.add(rootVal);
        trace(root, 1, res);
        res.remove(res.size()-1);
        return res;
    }

    private static void trace(TreeNode node, int level, List<List<Integer>> res) {
        if (node == null)
            return;
        if (res.size() == level)
            res.add(new ArrayList<>());
        if (node.left != null)
            res.get(level).add(node.left.val);
        if (node.right != null)
            res.get(level).add(node.right.val);
        trace(node.left, level+1, res);
        trace(node.right, level+1, res);
    }

    private static TreeNode buildTree(Integer[] elements, int i) {
        if (elements.length == 0)
            return null;
        if (i > elements.length-1 || elements[i] == null)
            return null;
        TreeNode root = new TreeNode(elements[i]);
        root.left = buildTree(elements, i*2+1);
        root.right = buildTree(elements, i*2+2);
        return root;
    }

    public static void main(String[] args) {
        Integer[] nodeVals = {3,9,20, null, null, 15,7};
        TreeNode root = buildTree(nodeVals, 0);
        List<List<Integer>> res = levelOrder(root);
        for (List<Integer> level : res) {
            for (Integer node : level) {
                System.out.print(node + " -> ");
            }
            System.out.println();
        }
        List<List<Integer>> res2 = levelOrderRecur(root);
        for (List<Integer> level : res2) {
            for (Integer node : level) {
                System.out.print(node + " -> ");
            }
            System.out.println();
        }
    }
}
