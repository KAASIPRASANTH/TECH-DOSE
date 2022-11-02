import java.util.*;

public class BinaryTree {
    static TreeNode root;

    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    public static void insert(TreeNode root, int data) {
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode nn = new TreeNode(data);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            if (temp.left == null) {
                temp.left = nn;
                break;
            }
            if (temp.right == null) {
                temp.right = nn;
                break;
            }
            if (temp.left.data != -1) {
                q.add(temp.left);
            }
            if (temp.right.data != -1) {
                q.add(temp.right);
            }
        }
    }

    public static void inorder(TreeNode root) {
        if (root != null && root.data != -1) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    public static void preorder(TreeNode root) {
        if (root != null && root.data != -1) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    public static void postorder(TreeNode root) {
        if (root != null && root.data != -1) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }

    public static void main(String[] args) {
        int[] list = { 1, 2, 3, -1, 4, 5, 6 };
        root = new TreeNode(1);
        for (int i = 1; i < list.length; i++) {
            insert(root, list[i]);
        }
        System.out.println("Inorder:");
        inorder(root);
        System.out.println("\nPreorder:");
        preorder(root);
        System.out.println("\nPostorder");
        postorder(root);
    }
}