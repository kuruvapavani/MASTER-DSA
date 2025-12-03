import java.util.*;
public class FindKMin {

    public static TreeNode findKMin(TreeNode root, int k) {
        if (root == null) return null;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        int count = 0;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            count++;

            if (count == k) {
                return curr;
            }

            curr = curr.right;
        }

        return null;
    }
}
