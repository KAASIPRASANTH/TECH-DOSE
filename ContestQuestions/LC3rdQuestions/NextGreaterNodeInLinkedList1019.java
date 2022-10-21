public class NextGreaterNodeInLinkedList1019 {
    public int[] nextLargerNodes(ListNode head) {
        ListNode temp = head;
        Stack<Integer> stk = new Stack<>();
        List<Integer> al = new ArrayList<>();
        while(temp != null){
            al.add(temp.val);
            temp = temp.next;
        }
        int[] right = new int[al.size()];
        for(int i=al.size()-1;i>=0;i--){
            while(!stk.isEmpty() && al.get(stk.peek()) <= al.get(i)){
                stk.pop();
            }
            right[i] = stk.isEmpty()?0:al.get(stk.peek());
            stk.push(i);
        }
        return right;
    }
}
