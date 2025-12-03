public class MinValue {
  public static TreeNode minValue(TreeNode root){
    if(root == null) return null;
    while(root.left != null){
      root = root.left;
    }
    return root;
  }
}
