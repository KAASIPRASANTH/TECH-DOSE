package LinkedList.Assignments;

public class SortAnLinkedList {
    Node head;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void append(int data) {
        Node nn = new Node(data);
        if (head == null) {
            head = nn;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = nn;
        }
    }

    public void display() {
        Node temp = head;
        System.out.println("\nThe Elements in the LL:");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public Node merge(Node h1, Node h2) {
        Node res = new Node(-1);
        Node temp = res;
        while (h1 != null && h2 != null) {
            if (h1.data < h2.data) {
                temp.next = new Node(h1.data);
                h1 = h1.next;
            } else {
                temp.next = new Node(h2.data);
                h2 = h2.next;
            }
            temp = temp.next;
        }
        while (h1 != null) {
            temp.next = new Node(h1.data);
            h1 = h1.next;
            temp = temp.next;
        }
        while (h2 != null) {
            temp.next = new Node(h2.data);
            h2 = h2.next;
            temp = temp.next;
        }
        return res.next;
    }

    public Node findMid(Node head) {
        Node slowPtr = head, fastPtr = head.next;
        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        return slowPtr;
    }

    public Node mergeSort(Node head) {
        if (head.next == null) {
            return head;
        }
        Node mid = findMid(head);
        Node right = mid.next;
        mid.next = null;
        Node left = head;
        left = mergeSort(left);
        right = mergeSort(right);
        Node newHead = merge(left, right);
        return newHead;
    }

    public static void main(String[] args) {
        SortAnLinkedList list = new SortAnLinkedList();
        list.append(5);
        list.append(1);
        list.append(6);
        list.append(7);
        list.append(9);
        list.append(3);
        // list.append(-1);
        list.display();
        list.head = list.mergeSort(list.head);
        list.display();

    }
}
