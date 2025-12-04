public class SortedListToBST {

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        return buildTree(head, null);
    }

    private TreeNode buildTree(ListNode head, ListNode tail) {
        if (head == tail) return null;

        ListNode slow = head;
        ListNode fast = head;

        // find middle node
        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }

        TreeNode root = new TreeNode(slow.val);

        // left half: head → slow
        root.left = buildTree(head, slow);

        // right half: slow.next → tail
        root.right = buildTree(slow.next, tail);

        return root;
    }
}
