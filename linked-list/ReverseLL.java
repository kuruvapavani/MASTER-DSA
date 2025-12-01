class ReverseLL {
    public static Node reverseLL(Node head) {
        Node prev = null;
        Node curr = head;
        
        while (curr != null) {
            Node next = curr.next; 
            curr.next = prev;      
            prev = curr;           
            curr = next;           
        }
        
        return prev;
    }
}

class Node {
    int val;
    Node next;
    Node(int val) {
        this.val = val;
    }
}
