package LinkedList.Assignments;

import java.util.*;

public class LinkedListOperations {
    Node head;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // insertion part
    public void insertAtEnd(int data) {
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

    public void insertAtBeginning(int data) {
        Node nn = new Node(data);

        if (head == null) {
            head = nn;
        } else {
            nn.next = head;
            head = nn;
        }
    }

    public void insertAtParticularPosition(int data, int pos) {
        Node nn = new Node(data);

        if (pos == 1) {
            nn.next = head;
            head = nn;
        } else {
            Node temp = head;
            int index = 1;
            while (index < pos - 1) {
                temp = temp.next;
                index++;
            }
            nn.next = temp.next;
            temp.next = nn;
        }
    }

    // deletion part
    public void deleteAtBegining() {
        if (head != null) {
            head = head.next;
        } else {
            System.out.println("\nlist was empty!");
        }
    }

    public void deleteAtEnd() {
        if (head == null) {
            System.out.println("\nList was Empty!");
        } else if (head.next == null) {
            head = null;
        } else {
            Node temp = head;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;
        }
    }

    public void deleteAtParticularPosition(int pos) {
        if (pos == 1) {
            head = head.next;
        } else {
            int index = 1;
            Node temp = head;
            while (index < pos - 1) {
                temp = temp.next;
                index++;
            }
            temp.next = temp.next.next;
        }
    }

    public void display() {
        System.out.println("\nElements in the linked list are:");
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public Node reverseInterative() {
        Node curr = head;
        Node prev = null;
        while (curr != null) {
            Node nextPart = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextPart;
        }
        return prev;
    }

    public Node reverseRecursive(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node newHead = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    public Node reverseInBlockOfSizeK(Node head, int k) {
        Node curr = head, nextPart = null, prev = null;
        int count = 0;
        while (count < k && curr != null) {
            nextPart = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextPart;
            count++;
        }
        if (nextPart != null) {
            head.next = reverseInBlockOfSizeK(nextPart, k);
        }
        return prev;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedListOperations list = new LinkedListOperations();
        list.insertAtEnd(1);
        list.insertAtEnd(2);
        list.insertAtEnd(3);
        list.insertAtEnd(4);
        list.insertAtEnd(5);
        list.display();

        list.head = list.reverseInterative();
        list.display();
        list.head = list.reverseRecursive(list.head);
        list.display();
        list.head = list.reverseInBlockOfSizeK(list.head, 3);
        list.display();

        sc.close();
    }
}
