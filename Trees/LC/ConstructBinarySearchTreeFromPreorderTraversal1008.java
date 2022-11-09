package Trees.LC;

public class ConstructBinarySearchTreeFromPreorderTraversal1008 {
    public static void insert(TreeNode root, int data) {
        if (root.val > data) {
            if (root.left == null) {
                root.left = new TreeNode(data);
                return;
            }
            insert(root.left, data);
        } else {
            if (root.right == null) {
                root.right = new TreeNode(data);
                return;
            }
            insert(root.right, data);
        }
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        int len = preorder.length;
        for (int i = 1; i < len; i++) {
            insert(root, preorder[i]);
        }
        return root;
    }
}
