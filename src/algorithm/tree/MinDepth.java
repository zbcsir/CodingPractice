package algorithm.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 求给定二叉树的最小深度。最小深度是指树的根结点到最近叶子结点的最短路径上结点的数量。
 */
public class MinDepth {
    private static int run(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int numLevel = 0;
        boolean haveLeaf = false;
        while (!queue.isEmpty()) {
            int cntNodes = queue.size();
            while (cntNodes > 0) {
                TreeNode first = queue.poll();
                if (first == null) {
                    break;
                }
                if (first.left == null && first.right == null) {
                    haveLeaf = true;
                    break;
                }
                if (first.left != null) {
                    queue.add(first.left);
                }
                if (first.right != null) {
                    queue.add(first.right);
                }
                -- cntNodes;
            }
            ++ numLevel;
            if (haveLeaf) {
                break;
            }

        }
        return numLevel;
    }

    public static void main(String[] args) {
        Integer[] nodeVals = {3,9,20, null, null, 15,7};
        TreeNode root = TreeUtils.buildTree(nodeVals, 0);
        System.out.println(run(root));
    }
}
