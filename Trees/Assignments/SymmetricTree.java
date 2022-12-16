public class SymmetricTree {
    static TreeNode root;
    public static class TreeNode{
        int data;
        TreeNode left,right;
        TreeNode(int data){
            this.data = data;
        }
    }
    public static boolean isSymmetric(TreeNode root1,TreeNode root2){
        if(root1==null && root2==null){
            return true;
        }
        if(root1==null || root2==null){
            return false;
        }
        return root1.data == root2.data && isSymmetric(root1.left,root2.right) && isSymmetric(root1.right, root2.left); 
    }
    public static void main(String[] args) {
        root  = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        System.out.println(isSymmetric(root.left,root.right));
    }
}
