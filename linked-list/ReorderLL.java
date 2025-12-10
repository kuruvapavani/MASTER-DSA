
public class ReorderLL {

    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secHalf = slow.next;
        ListNode prev = null;
        slow.next = null;
        while (secHalf != null) {
            ListNode next = secHalf.next;
            secHalf.next = prev;
            prev = secHalf;
            secHalf = next;
        }
        ListNode firstHalf = head;
        secHalf = prev;
        while (secHalf != null) {
            ListNode t1 = firstHalf.next;
            ListNode t2 = secHalf.next;
            firstHalf.next = secHalf;
            secHalf.next = t1;
            firstHalf = t1;
            secHalf = t2;
        }
    }
}
