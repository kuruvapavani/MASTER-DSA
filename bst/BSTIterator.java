import java.util.*;
public class BSTIterator {
    private Stack<TreeNode> st;

    public BSTIterator(TreeNode root) {
        st = new Stack<>();
        pushLeft(root);
    }

    public int next() {
        TreeNode curr = st.pop();
        if(curr.right != null){
            pushLeft(curr.right);
        }
        return curr.val;
    }

    public boolean hasNext() {
        return !st.isEmpty();
    }

    private void pushLeft(TreeNode node) {
        while(node != null){
            st.push(node);
            node = node.left;
        }
    }
}