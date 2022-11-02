public class TreeTraversal {
    TreeNode root = null;

    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private static TreeTraversal.TreeNode levelBuild(int[] arr, int i) {
        TreeNode root = null;
        if (i < arr.length) {
            root = new TreeNode(arr[i]);
            root.left = levelBuild(arr, 2 * i);
            root.right = levelBuild(arr, 2 * i + 1);
        }
        return root;
    }

    public static void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }
    public static void preorder(TreeNode root) {
        if (root != null) {
            System.out.print(root.data+" ");
            preorder(root.left);
            preorder(root.right);
        }
    }
    public static void main(String[] args) {
        TreeTraversal tree = new TreeTraversal();
        int[] arr = { 0, 1, 2, 3, 4, 5, 6 };
        tree.root = levelBuild(arr, 1);
        inorder(tree.root);
        preorder(tree.root);
    }

}
