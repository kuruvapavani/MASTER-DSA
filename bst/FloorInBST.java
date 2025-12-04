public class FloorInBST {
  public static TreeNode floorInBST(TreeNode root,int val){
    TreeNode floor = null;
    while(root != null){
      if(root.val == val) return root;
      if(root.val < val){
        floor = root;
        root = root.right;
      }else{
        root = root.left;
      }
    }
    return floor;
  }
}
