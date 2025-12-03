public class ValidateBST {
  public static boolean isValidBST(TreeNode root){
    return isValid(root,Long.MIN_VALUE,Long.MAX_VALUE);
  }

  public static boolean isValid(TreeNode node,long min,long max){
    if(node == null) return true;
    if(node.val <= min || node.val >= max) return false;
    return isValid(node.left, min, node.val) && isValid(node.right, node.val, max);
  }
}
