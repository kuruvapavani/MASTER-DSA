
public class IntersectionOfLL {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int m = getLength(headA);
        int n = getLength(headB);
        if (m > n) {
            return getIntersectionNode(headB, headA);
        }
        for (int i = 0; i < n - m; i++) {
            headB = headB.next;
        }
        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    private int getLength(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }
}
