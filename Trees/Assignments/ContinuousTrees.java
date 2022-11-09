
public class ContinuousTrees {
    static TreeNode root;

    public static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static boolean isContinuousTree(TreeNode root) {
        System.out.print(root.data+" ");
        if (root.left != null && Math.abs(root.data - root.left.data) != 1) {
            System.out.println(root.data+".");
            return false;
        }
        if (root.right != null && Math.abs(root.data - root.right.data) != 1) {
            return false;
        }
        boolean left = true,right=true;
        if(root.left != null){
            left = isContinuousTree(root.left);
        }
        if(root.right != null){
            right = isContinuousTree(root.right);
        }
        return left & right;
    }

    public static void main(String[] args) {
        root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        root.right = new TreeNode(4);
        root.right.left = new TreeNode(5);

        System.out.println(isContinuousTree(root));
        System.out.println(root.data);
    }
}