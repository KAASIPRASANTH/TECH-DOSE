package LinkedList.LC;

public class LinkedListCycleII142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null)
            return null;
        ListNode slowPtr = head, fastPtr = head;
        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if (slowPtr == fastPtr) {
                while (head != fastPtr) {
                    head = head.next;
                    fastPtr = fastPtr.next;
                }
                return head;
            }
        }
        return null;
    }
}
