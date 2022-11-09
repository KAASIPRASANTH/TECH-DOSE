package Trees.LC;

public class DiameterOfBinaryTree543 {
    static int res;

    public static int findLength(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = findLength(root.left);
        int right = findLength(root.right);
        res = Math.max(left + right, res);
        return Math.max(left, right) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        res = 0;
        findLength(root);
        return res;
    }
}
