package Trees.LC;

public class BinaryTrMaximumPathSum124 {
    static int res;

    public static int postOrder(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = postOrder(root.left);
        int right = postOrder(root.right);
        int case1 = Math.max(Math.max(left, right) + root.val, root.val);
        int case2 = Math.max(left + root.val + right, case1);
        res = Math.max(res, case2);
        return case1;
    }

    public int maxPathSum(TreeNode root) {
        res = Integer.MIN_VALUE;
        if (root == null)
            return 0;
        int val = postOrder(root);
        return res;
    }
}
