package algorithm.tree;

// 给定一个非空二叉树，返回其最大路径和
public class MaxPathSum {
    private static int res = Integer.MIN_VALUE;
    private static int maxPathSum(TreeNode root) {
        helper2(root);
        return res;
    }

    private static int helper(TreeNode node) {
        if (node == null)
            return 0;
        int leftVal = helper(node.left);
        int rightVal = helper(node.right);
        int max = Math.max(node.val + Math.max(leftVal, rightVal), 0);
        res = Math.max(res, node.val + leftVal + rightVal);
        return max;
    }

    private static int helper2(TreeNode node) {
        if (node == null)
            return 0;
        int leftVal = Math.max(helper2(node.left), 0);
        int rightVal = Math.max(0, helper2(node.right));
        int max = node.val + Math.max(leftVal, rightVal);
        res = Math.max(res, node.val + leftVal + rightVal);
        return max;
    }

    public static void main(String[] args) {
        Integer[] vals = {-10,9,20,null,null,15,7};
        TreeNode root = TreeUtils.buildTree(vals, 0);
        System.out.println(maxPathSum(root));
    }
}
