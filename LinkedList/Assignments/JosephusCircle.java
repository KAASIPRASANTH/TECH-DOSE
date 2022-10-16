package LinkedList.Assignments;

import java.util.Scanner;

public class JosephusCircle {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static int getJosephusPosition(int n, int k) {
        Node list = new Node(1);
        Node temp = list;
        for (int i = 2; i <= n; i++) {
            temp.next = new Node(i);
            temp = temp.next;
        }
        // making last nodes next part as 1st nodes address
        temp.next = list;

        Node ptr1 = list, ptr2 = list;
        while (ptr1 != ptr1.next) {
            int count = 1;
            while (count != k) {
                ptr2 = ptr1;
                ptr1 = ptr1.next;
                count++;
            }
            ptr2.next = ptr1.next;
            ptr1 = ptr2.next;
        }
        return ptr1.data;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.close();
        System.out.println(getJosephusPosition(n, k));
    }
}
