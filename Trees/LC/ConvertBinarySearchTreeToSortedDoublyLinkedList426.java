import java.util.*;

public class ConvertBinarySearchTreeToSortedDoublyLinkedList426 {
    static TreeNode treeroot;
    static List<Integer> res;

    public static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    static Node head;

    public static class Node {
        int data;
        Node next, prev;

        Node(int data) {
            this.data = data;
        }
    }

    public static void inorder(TreeNode treerroot) {
        if (treerroot != null) {
            inorder(treerroot.left);
            Node nn = new Node(treerroot.data);
            if (head == null) {
                head = nn;
                head.next = nn;
                head.prev = nn;
            } else {
                Node temp = head;
                while (temp.next != head) {
                    temp = temp.next;
                }
                temp.next = nn;
                nn.prev = temp;
                nn.next = head;
                head.prev = nn;
            }
            inorder(treerroot.right);
        }
    }

    public static void display() {
        Node temp = head;
        res = new ArrayList<>();
        while (temp.next != head) {
            res.add(temp.data);
            temp = temp.next;
        }
        res.add(temp.data);
    }

    public static void main(String[] args) {
        treeroot = new TreeNode(4);
        treeroot.left = new TreeNode(2);
        treeroot.left.left = new TreeNode(1);
        treeroot.left.right = new TreeNode(3);
        treeroot.right = new TreeNode(5);
        inorder(treeroot);
        display();
        System.out.println(res);
    }
}
