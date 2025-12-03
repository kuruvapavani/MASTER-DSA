public class IsBalanced {

    public static boolean isBalanced(TreeNode root) {
        return check(root) != -1;
    }

    private static int check(TreeNode node) {
        if (node == null) return 0;

        int left = check(node.left);
        if (left == -1) return -1;

        int right = check(node.right);
        if (right == -1) return -1;

        if (Math.abs(left - right) > 1) return -1;

        return 1 + Math.max(left, right);
    }
}
