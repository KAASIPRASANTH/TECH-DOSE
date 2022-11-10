public class InorderSuccessorInBST285 {
    static TreeNode root;
    static TreeNode res;

    public static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    public static void inorderSuccessor(TreeNode root, TreeNode p) {
        if (root != null && res == null) {
            inorderSuccessor(root.left, p);
            if (root.data > p.data) {
                res = root;
                return;
            }
            inorderSuccessor(root.right, p);
        }
    }

    public static void main(String[] args) {
        root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(6);
        res = null;
        inorderSuccessor(root, root.left.right);
        System.out.println(res.data + " ");
        res = null;
        inorderSuccessor(root, root.right);
        if(res == null){
            System.out.println("null");
        }else{
            System.out.println(res.data);
        }
    }
}