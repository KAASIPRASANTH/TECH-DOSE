public class Prob96_MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode(0);
        ListNode res = temp;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    res.next = new ListNode(l1.val);
                    l1 = l1.next;
                } else {
                    res.next = new ListNode(l2.val);
                    l2 = l2.next;
                }
                res = res.next;
            } else {
                if (l1 != null) {
                    res.next = l1;
                    l1 = null;
                } else {
                    res.next = l2;
                    l2 = null;
                }
            }
        }
        return temp.next;
    }
}
