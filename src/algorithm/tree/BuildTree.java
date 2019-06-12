package algorithm.tree;

public class BuildTree {
    // 根据先序和中序构造树
    private TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length != inorder.length) return null;
        if (preorder.length == 0) return null;
        if (preorder.length == 1) return new TreeNode(preorder[0]);
        int nNodes = preorder.length;
        return helper(preorder, 0, nNodes - 1, inorder, 0, nNodes - 1);
    }

    private TreeNode helper(int[] preorder, int pre_s, int pre_e, int[] inorder, int in_s, int in_e) {
        int rootVal = preorder[pre_s];
        TreeNode root = new TreeNode(rootVal);
        if (pre_s == pre_e) return root;
        int rootIn = in_s;
        for (int i = in_s; i <= in_e; i++) {
            if (inorder[i] == rootVal) {
                rootIn = i;
                break;
            }
        }
        int leftLen = rootIn - in_s;
        int lastLeftInPre = pre_s + leftLen;
        if (leftLen > 0)
            root.left = helper(preorder, pre_s + 1, lastLeftInPre, inorder, in_s, rootIn - 1);
        if (lastLeftInPre < pre_e)
            root.right = helper(preorder, lastLeftInPre + 1, pre_e, inorder, rootIn + 1, in_e);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode root = new BuildTree().buildTree(preorder, inorder);
        TreeUtils.traceTreePre(root);
    }
}
