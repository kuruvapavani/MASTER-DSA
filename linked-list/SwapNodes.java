
public class SwapNodes {

    public ListNode swapNodes(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode ptr = head;
        for (int i = 1; i < k; i++) {
            fast = fast.next;
            ptr = ptr.next;
        }
        fast = fast.next;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        int temp = ptr.val;
        ptr.val = slow.val;
        slow.val = temp;
        return head;
    }
}
