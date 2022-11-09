package Trees.LC;

public class CousinsInBinaryTree993 {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean xFind = false, yFind = false;
        int xParent = -1, yParent = -1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = q.poll();
                if (temp.left != null) {
                    q.add(temp.left);
                    if (temp.left.val == x) {
                        xFind = true;
                        xParent = temp.val;
                    }
                    if (temp.left.val == y) {
                        yFind = true;
                        yParent = temp.val;
                    }
                }
                if (temp.right != null) {
                    q.add(temp.right);
                    if (temp.right.val == x) {
                        xFind = true;
                        xParent = temp.val;
                    }
                    if (temp.right.val == y) {
                        yFind = true;
                        yParent = temp.val;
                    }
                }
            }
            if (xFind || yFind) {
                if (xParent == yParent || xParent == -1 || yParent == -1) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }
}
