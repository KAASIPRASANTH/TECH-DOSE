package LinkedList.LC;

public class RemoveDuplicatesfromSortedListII82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode res = new ListNode(0, head);
        ListNode temp = res;
        while (head != null) {
            if (head.next != null && head.val == head.next.val) {
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                temp.next = head.next;
            } else {
                temp = temp.next;
            }
            head = head.next;
        }
        return res.next;
    }
}
