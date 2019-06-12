package algorithm.tree;

import java.util.List;

// 给定一个二叉树，原地将它展开为链表
public class Flatten {
    private static void flatten(TreeNode root) {
        if (root == null) return;
        if (root.left != null) flatten(root.left);
        if (root.right != null) flatten(root.right);
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = null;
        while (root.right != null)
            root = root.right;
        root.right = tmp;
    }

    public static void main(String[] args) {
        Integer[] nodeVals = {1, 2, 5, 3, 4, null, 6};
        TreeNode root = TreeUtils.buildTree(nodeVals, 0);
        flatten(root);
        TreeUtils.traceTreePre(root);
        List<List<Integer>> levels = TraceInLevel.levelOrderRecur(root);
        System.out.println();
        for (List<Integer> level : levels) {
            for (int node : level) {
                System.out.print(node + " -> ");
            }
            System.out.println();
        }
    }
}
