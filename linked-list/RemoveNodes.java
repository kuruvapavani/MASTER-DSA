
import java.util.Stack;

public class RemoveNodes {

    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> st = new Stack<>();
        ListNode ptr = head;
        while (ptr != null) {
            while (!st.isEmpty() && st.peek().val < ptr.val) {
                st.pop();
            }
            st.push(ptr);
            ptr = ptr.next;
        }
        ListNode newHead = null;
        while (!st.isEmpty()) {
            ListNode curr = st.pop();
            curr.next = newHead;
            newHead = curr;
        }
        return newHead;
    }
}
