package LinkedList.LC;

public class ReverseLinkedList206 {
    public ListNode reverseList(ListNode head) {
        ListNode curr = head, prev = null;
        while (curr != null) {
            ListNode newNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = newNode;
        }
        return prev;
    }
}
