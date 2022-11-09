package Trees.LC;

public class CountGoodNodesInBinaryTree1448 {
    static int count;

    public static void solve(TreeNode root, int max) {
        if (root == null) {
            return;
        }
        if (root.val >= max) {
            count++;
        }
        solve(root.left, Math.max(root.val, max));
        solve(root.right, Math.max(root.val, max));
    }

    public int goodNodes(TreeNode root) {
        count = 0;
        solve(root, Integer.MIN_VALUE);
        return count;
    }
}
