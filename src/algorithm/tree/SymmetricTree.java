package algorithm.tree;

/**
 * ¶Ô³Æ¶þ²æÊ÷
 */
public class SymmetricTree {
    private static boolean isSymmetric(TreeNode root) {
        return judge(root, root);
    }

    private static boolean judge(TreeNode t1, TreeNode t2) {
        if ((t1 == null) && (t2 == null)) {
            return true;
        }
        if ((t1 == null) || (t2 == null)) {
            return false;
        }
        return ((t1.val == t2.val) && judge(t1.left, t2.right) && judge(t2.left, t1.right));
    }

    public static void main(String[] args) {
        Integer[] nums = {1,2,2,3,4,4,3};
        Integer[] nums2 = {1,2,2,null,3,null,3};
        TreeNode tree = TreeUtils.buildTree(nums, 0);
        TreeNode tree2 = TreeUtils.buildTree(nums2, 0);
        System.out.println(isSymmetric(tree));
        System.out.println(isSymmetric(tree2));
    }
}
