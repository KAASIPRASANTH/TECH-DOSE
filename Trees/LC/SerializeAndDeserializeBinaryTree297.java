package Trees.LC;

public class SerializeAndDeserializeBinaryTree297 {
    public static TreeNode toNode(String[] nodes, int index) {
        if (index >= nodes.length || "null".equals(nodes[index]) || "".equals(nodes[index])) {
            return null;
        }
        return new TreeNode(Integer.parseInt(nodes[index]));
    }

    public static TreeNode decode(String data) {
        String[] nodes = data.split(" ");
        Queue<TreeNode> q = new LinkedList<>();
        int index = 0;
        TreeNode root = toNode(nodes, index++);
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size && index < nodes.length; i++) {
                TreeNode temp = q.poll();
                temp.left = toNode(nodes, index++);
                temp.right = toNode(nodes, index++);
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
        }
        return root;
    }

    public static String encode(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder(" ");
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = q.poll();
                if (temp != null) {
                    sb.append(temp.val);
                    sb.append(" ");

                    q.add(temp.left);
                    q.add(temp.right);
                } else {
                    sb.append("null");
                    sb.append(" ");
                }
            }
        }
        // System.out.println(sb.toString());
        return sb.toString().trim();
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "null";
        return encode(root);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if ("null".equals(data))
            return null;
        return decode(data);
    }
}
