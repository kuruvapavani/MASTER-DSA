public class MiddleOfLL {
  public static Node middleOfLL(Node head){
      if(head == null) return null;
      Node slow = head;
      Node fast = head;
      while(fast!=null && fast.next!=null){
        slow = slow.next;
        fast = fast.next.next;
      }
      return slow;
  }
}

class Node {
    int val;
    Node next;
    Node(int val) {
        this.val = val;
    }
}