public class MergeKSortedLists23{
    /*public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((temp1,temp2)->{
            return temp1.val - temp2.val;
        });
        for(int i=0;i<lists.length;i++){
            ListNode temp = lists[i];
            while(temp!=null){
                pq.add(temp);
                temp = temp.next;
            }
        }
        ListNode res = new ListNode(-1);
        ListNode temp = res;
        while(!pq.isEmpty()){
            temp.next = new ListNode(pq.poll().val);
            temp = temp.next;
        }
        return res.next;
    }*/
}