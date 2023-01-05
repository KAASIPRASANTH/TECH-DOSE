class Solution {
    static Node head,tail;
    public static void inorder(Node root){
        if(root==null) return;
        inorder(root.left);
        if(head == null){
            head = root;
        }else{
            tail.right = root;
            root.left = tail;
        }
        tail = root;
        inorder(root.right);
    }
    public Node treeToDoublyList(Node root) {
        if(root == null) return root;
        head = null;tail = null;
        inorder(root);
        tail.right = head;
        head.left = tail;
        return head;
    }
}
