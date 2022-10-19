package LinkedList.LC;

public class SortList148 {
    public ListNode merge(ListNode h1,ListNode h2){
        ListNode nn = new ListNode(-1);
        ListNode temp = nn;
        while(h1!=null && h2!=null){
            if(h1.val > h2.val){
                temp.next = new ListNode(h2.val);
                h2 = h2.next;
            }else{
                temp.next = new ListNode(h1.val);
                h1 = h1.next;
            }
            temp = temp.next;
        }
        while(h1!=null){
            temp.next = new ListNode(h1.val);
            h1 = h1.next;
            temp = temp.next;
        }
        while(h2!=null){
            temp.next = new ListNode(h2.val);
            h2 = h2.next;
            temp = temp.next;
        }
        return nn.next;
    }
    public ListNode findMid(ListNode head){
        ListNode slow = head,fast = head.next;
        while(fast != null &&  fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public ListNode mergeSort(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode mid = findMid(head);
        ListNode right = mid.next;
        mid.next = null;
        ListNode left = head;
        left = mergeSort(left);
        right = mergeSort(right);
        return merge(left,right);
    }
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }
    public static void main(String[] args) {
        /*
        Input: head = [4,2,1,3]
        Output: [1,2,3,4]
        */
    }
}
