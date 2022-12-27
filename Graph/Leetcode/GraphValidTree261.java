class Solution {
    static int count;
    public static boolean DFS(List<List<Integer>> al,boolean[] visited,int curr,int parent){
        visited[curr] = true;
        count++;
        for(int i=0;i<al.get(curr).size();i++){
            int adj = al.get(curr).get(i);
            if(visited[adj]==false){
                if(DFS(al,visited,adj,curr)){
                    return true;
                }
            }else if(adj != parent){
                return true;
            }
        }
        visited[curr] = false;
        return false;
    }
    public boolean validTree(int n, int[][] edges) {
        count=0;
        List<List<Integer>> al = new ArrayList<>();
        if(edges.length<n-1){
            return false;
        }
        for(int i=0;i<n;i++){
            al.add(new ArrayList<>());
        }
        for(int[] con:edges){
            al.get(con[0]).add(con[1]);
            al.get(con[1]).add(con[0]);
        }
        boolean[] visited = new boolean[n];
        for(int i=0;i<n;i++){
            if(visited[i]==false && DFS(al,visited,i,-1)){
                return false;
            }
        }
        return true;
    }
}
