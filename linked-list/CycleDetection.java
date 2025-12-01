public class CycleDetection {
  public static boolean cycleDetection(Node head) {
    if (head == null || head.next == null) return false;

    Node slow = head;
    Node fast = head;

    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;

        if (slow == fast) return true;
    }
    return false;
}

}

class Node {
    int val;
    Node next;
    Node(int val) {
        this.val = val;
    }
}
