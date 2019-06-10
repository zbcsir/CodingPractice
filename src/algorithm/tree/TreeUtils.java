package algorithm.tree;

// 树操作的工具类，用于存放一些公共方法
public class TreeUtils {
    // 建树
    public static TreeNode buildTree(Integer[] elements, int i) {
        if (elements.length == 0)
            return null;
        if (i > elements.length-1 || elements[i] == null)
            return null;
        TreeNode root = new TreeNode(elements[i]);
        root.left = buildTree(elements, i*2+1);
        root.right = buildTree(elements, i*2+2);
        return root;
    }
}
