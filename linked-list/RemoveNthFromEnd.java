
public class RemoveNthFromEnd {

    public static Node removeNthFromEnd(Node head, int n) {
        Node slow = head;
        Node fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if (fast == null) {
            return head.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }

}

class Node {

    int val;
    Node next;

    Node(int val) {
        this.val = val;
    }
}
