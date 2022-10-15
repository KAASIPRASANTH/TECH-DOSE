package LinkedList.LC;

public class PalindromeLinkedList234 {
    public boolean isPalindrome(ListNode head) {
        List<Integer> al = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            al.add(temp.val);
            temp = temp.next;
        }
        int size = al.size();
        for (int i = 0, j = size - 1; i <= j; i++, j--) {
            if (al.get(i) != al.get(j)) {
                return false;
            }
        }
        return true;
    }
}
