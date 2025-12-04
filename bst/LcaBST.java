public class LcaBST {
    public static TreeNode lcaBST(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        if (p.val < root.val && q.val < root.val) {
            return lcaBST(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            return lcaBST(root.right, p, q);
        } else {
            return root;
        }
    }
}
