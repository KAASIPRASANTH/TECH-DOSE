package LinkedList.Assignments;

public class MultiplicationOfTwoLinkedList {
    Node head;

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static int multiply(Node l1, Node l2) {
        int num1 = 0, num2 = 0;
        while (l1 != null) {
            num1 = num1 * 10 + (l1.data);
            l1 = l1.next;
        }
        while (l2 != null) {
            num2 = num2 * 10 + (l2.data);
            l2 = l2.next;
        }
        return (num1 * num2);
    }

    public static void main(String[] args) {
        // first list
        Node list1 = new Node(1);
        list1.next = new Node(2);

        // second list
        Node list2 = new Node(1);
        list2.next = new Node(0);

        System.out.println(multiply(list1, list2));
    }
}
