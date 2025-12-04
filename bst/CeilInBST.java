public class CeilInBST {
  public static TreeNode ceilInBST(TreeNode root,int val){
    TreeNode ceil = null;
    while(root != null){
      if(root.val == val) return root;
      if(root.val > val){
        ceil = root;
        root = root.left;
      }else{
        root = root.right;
      }
    }
    return ceil;
  }
}
