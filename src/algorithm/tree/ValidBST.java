package algorithm.tree;

import java.util.ArrayList;
import java.util.List;

public class ValidBST {

  static List<Integer> res = new ArrayList<>();
  public static List<Integer> inorderTraversal(TreeNode root) {  
    if(root == null)
      return res;
    if(root.left != null)
      inorderTraversal(root.left);
    res.add(root.val);
    if(root.right != null)
      inorderTraversal(root.right);
    return res;
  }
  
  public static boolean isValidBST1(TreeNode root) {
    boolean VBST = true;
    if(root == null)
      VBST = true;
    else {
      List<Integer> mid = inorderTraversal(root);
      for(int i : mid)
        System.out.print(i + "\t");
      System.out.println();
      if(mid.size() == 1) {
        VBST = true;
      }else if(mid.size() > 1) {
        for(int i=0; i<mid.size()-1; i++) {
          System.out.println(mid.get(i) + "\t" + mid.get(i+1));
          if(mid.get(i) >= mid.get(i+1)) {
            VBST = false;
            break;
          }
        }
      }    
    }
    
    return VBST;
  }
  
  public static boolean isValidBST(TreeNode root) {
    if(root == null) return true;
    return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
  }
  
  public static boolean isValid(TreeNode root, long min, long max) {
    if(root == null)
      return true;
    if((root.val <= min) || (root.val >= max))
      return false;
    return isValid(root.left, min, root.val) && isValid(root.right, 
        root.val, max);
  }
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub
//    TreeNode root = new TreeNode(1);
//    root.left = null;
//    TreeNode r = new TreeNode(3);
//    TreeNode rl = new TreeNode(2);
//    r.left = rl;
//    root.right = r;
//    List<Integer> res = inorderTraversal(root);
//    for(int i : res)
//      System.out.print(i + "\t");
//    System.out.println();

    TreeNode root = new TreeNode(2);
    TreeNode r = new TreeNode(2);
    TreeNode l = new TreeNode(1);
    root.left = l;
    root.right = r;
    System.out.println(isValidBST(root));
    System.out.println(Integer.MAX_VALUE);
  }

}
