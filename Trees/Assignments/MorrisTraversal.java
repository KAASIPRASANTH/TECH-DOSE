public class MorrisTraversal {
    static TreeNode root;

    public static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    public static void morrisTraversal(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            // just print you are in left most side
            if (curr.left == null) {
                System.out.print(curr.data + " ");
                curr = curr.right;
            } else {
                TreeNode predicessor = curr.left;

                // finding an predicessor of curr node and setting right part as curr
                while (predicessor.right != null && predicessor.right != curr) {
                    predicessor = predicessor.right;
                }

                // if we visiting first time then assign predicessor right as curr
                if (predicessor.right == null) {
                    predicessor.right = curr;
                    curr = curr.left;
                } else { // if we already assigned predicessor right as curr the we should make right as
                         // null
                    predicessor.right = null;
                    System.out.print(curr.data + " ");
                    // we just moving to the right subtree
                    curr = curr.right;
                }
            }
        }
    }

    public static void main(String[] args) {
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(6);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(7);

        morrisTraversal(root);
    }
}