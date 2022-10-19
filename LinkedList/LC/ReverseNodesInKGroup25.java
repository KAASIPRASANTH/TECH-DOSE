package LinkedList.LC;

public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr=head,prev=null,Next=null;
        int cnt=0;
        ListNode temp = head;
        while(cnt<k && temp!=null){
            temp = temp.next;
            cnt++;
        }
        if(cnt != k){
            return head;
        }
        cnt = 0;
        while(cnt<k && curr != null){
            Next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = Next;
            ++cnt;
        }
        if(curr != null){
            head.next = reverseKGroup(Next,k);
        }
        return prev;
    }
    public static void main(String[] args) {
        /*
        k = 3
        Input: 1->2->3->4->5
        Output: 3->2->1->4->5
         */
    }
}
