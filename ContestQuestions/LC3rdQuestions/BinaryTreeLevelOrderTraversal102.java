public class BinaryTreeLevelOrderTraversal102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> al = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode temp = q.poll();
                al.add(temp.val);
                if(temp.left != null) q.add(temp.left);
                if(temp.right != null) q.add(temp.right);
            }
            res.add(al);
        }
        return res;
    }
}
