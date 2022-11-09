package Trees.LC;

public class BinaryTreeZigzagLevelOrderTraversal103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        int counter = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> al = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode temp = q.poll();
                al.add(temp.val);
                if (temp.left != null)
                    q.add(temp.left);
                if (temp.right != null)
                    q.add(temp.right);
            }
            if (counter % 2 == 0) {
                Collections.reverse(al);
            }
            res.add(al);
            ++counter;
        }
        return res;
    }
}
