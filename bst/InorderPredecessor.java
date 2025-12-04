public class InorderPredecessor {
    public static TreeNode inorderPredecessor(TreeNode root, TreeNode p) {
        TreeNode predecessor = null;

        while (root != null) {
            if (p.val > root.val) {
                predecessor = root;
                root = root.right;
            } else {
                root = root.left;
            }
        }

        return predecessor;
    }
}
