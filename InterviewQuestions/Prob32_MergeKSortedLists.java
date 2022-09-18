public class Prob32_MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = new ListNode(0);
        ListNode temp = null;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < lists.length; i++) {
            temp = lists[i];
            while (temp != null) {
                q.add(temp.val);
                temp = temp.next;
            }
        }
        temp = res;
        while (!q.isEmpty()) {
            int val = q.poll();
            temp.next = new ListNode(val);
            temp = temp.next;
        }
        return res.next;
    }
}
