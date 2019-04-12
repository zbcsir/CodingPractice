package algorithm.tree;

public class LowestCommonAncestor {

    private TreeNode buildTree(Integer[] elements, int i) {
        if (elements.length == 0)
            return null;
        if (i > elements.length-1 || elements[i] == null)
            return null;
        TreeNode root = new TreeNode(elements[i]);
        root.left = buildTree(elements, i*2+1);
        root.right = buildTree(elements, i*2+2);
        return root;
    }

    int getDepth(Integer[] nums) {
        int size = nums.length;
        int depth = (int)(Math.ceil(Math.log(size) / Math.log(2)));
        return depth;
    }

    public TreeNode lowestCommonAncestorOld(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }else if (left == null) {
            return right;
        } else if (right == null)
            return left;
        return null;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }else if (left == null) {
            return right;
        } else
            return left;
    }

    public TreeNode lowestCommonAncestorForBST(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return root;
        if ((p.val-root.val) * (q.val - root.val) <= 0) {
            return root;
        } else if (p.val > root.val) {
            return lowestCommonAncestorForBST(root.right, p, q);
        } else
            return lowestCommonAncestorForBST(root.left, p, q);
    }

    public static void main(String[] args) {
        Integer[] elements = {6,2,8,0,4,7,9,null,null,3,5};
        Integer[] elements2 = {3,5,1,6,2,0,8,null,null,7,4};
        LowestCommonAncestor lca = new LowestCommonAncestor();
        TreeNode root = lca.buildTree(elements2, 0);
//        System.out.println(root.left.left.val);
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(1);
//        System.out.println(p.val);
        TreeNode t = lca.lowestCommonAncestor(root, p, q);
        System.out.println(t.equals(null));
        System.out.println(t.val);
//        System.out.println(lca.lowestCommonAncestor(root, new TreeNode(5), new TreeNode(1)).val);
    }
}
