
import java.util.Stack;

public class FindKMax {

    public static TreeNode findKMax(TreeNode root, int k) {
        if (root == null) {
            return null;
        }

        TreeNode curr = root;
        int count = 0;
        Stack<TreeNode> st = new Stack<>();

        while (curr != null || !st.isEmpty()) {

            while (curr != null) {
                st.push(curr);
                curr = curr.right;
            }

            curr = st.pop();
            count++;

            if (count == k) {
                return curr;
            }

            curr = curr.left;
        }
        return null;
    }
}
