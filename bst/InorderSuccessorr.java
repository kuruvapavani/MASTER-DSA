public class InorderSuccessorr {
  public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
      TreeNode successor = null;
      while(root != null){
        if(p.val < root.val){
          successor = root;
          root = root.left;
        }else{
          root = root.right;
        }
      }
      return successor;
  }
}
