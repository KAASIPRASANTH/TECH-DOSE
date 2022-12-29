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
    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> al = new ArrayList<>();
        int n = isConnected.length;
        int m = isConnected[0].length;
        for(int i=0;i<n;i++){
            al.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i!=j && isConnected[i][j]==1) al.get(i).add(j);
            }
        }
        boolean[] visited = new boolean[n];
        int count = 0;
        for(int i=0;i<n;i++){
            if(visited[i]==false){
                count++;
                DFS(al,visited,i);
            }
        }
        return count;
    }
}
