package Trees.LC;

public class SymmetricTree106 {
    public static boolean solve(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if ((p == null && q != null) || (p != null && q == null)) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return solve(p.left, q.right) && solve(p.right, q.left);
    }

    public boolean isSymmetric(TreeNode root) {
        return solve(root.left, root.right);
    }
}
