class Solution {
    public static Node DFS(Node node,Node[] copy){
        if(copy[node.val] != null){
            return copy[node.val];
        }
        copy[node.val] = new Node(node.val);
        for(Node adj:node.neighbors){
            copy[node.val].neighbors.add(DFS(adj,copy));
        }
        return copy[node.val];
    }
    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        Node[] copy = new Node[101];
        DFS(node,copy);
        return DFS(node,copy);
    }
}
