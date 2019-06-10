package algorithm.tree;

// �������Ĺ����࣬���ڴ��һЩ��������
public class TreeUtils {
    // ����
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
