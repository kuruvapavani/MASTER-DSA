
public class SumNodes {
    public static int sumNodes(TreeNode root){
        if(root == null) return 0;
        return root.val + sumNodes(root.left) + sumNodes(root.right);
    }
}
