import java.util.*;

public class InorderWithStack {
    static TreeNode root;

    public static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    public static void inorder(TreeNode root) {
        Stack<TreeNode> stk = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stk.isEmpty()) {
            while (curr != null) {
                stk.push(curr);
                curr = curr.left;
            }
            curr = stk.pop();
            System.out.print(curr.data + " ");
            curr = curr.right;
        }
    }

    public static void main(String[] args) {
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        root.left.right.right = new TreeNode(7);
        root.left.right.right.right = new TreeNode(8);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(9);

        inorder(root);
    }
}


/*
  Time Complexity = O(N)
  Space Complexity = O(N)

 STACK VISUALIZATION on each loop
 1) Empty
 2) [1,2,4]
     print = 4
     [1,2]

3) [1,2]
   print = 2

4) [1,5,6]
   print = 6
   [1,5]

5) [1,5]
   print = 5
   [1]

6) [1,7]
   print= 7
   [1]

7) [1,8]
   print = 8
   [1]

8) [1]
   print = 1
   []

9) [3]
   print = 3
   []

10) [9]
    print = 9
    []
 */