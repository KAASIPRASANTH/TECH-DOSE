class Solution {
    public static void DFS(List<List<Integer>> al,boolean[] visited,int curr){
        visited[curr] = true;
        for(int i=0;i<al.get(curr).size();i++){
            int adj = al.get(curr).get(i);
            if(visited[adj]==false){
                DFS(al,visited,adj);
            }
        }
    }
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> al = new ArrayList<>();
        for(int i=0;i<n;i++){
            al.add(new ArrayList<>());
        }
        for(int[] con:edges){
            al.get(con[0]).add(con[1]);
            al.get(con[1]).add(con[0]);
        }
        boolean[] visited = new boolean[n];
        int count=0;
        for(int i=0;i<n;i++){
            if(visited[i] == false){
                count++;
                DFS(al,visited,i);
            }
        }
        return count;
    }
}
