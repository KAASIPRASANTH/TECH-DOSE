class Solution {
    static List<List<Integer>> res;
    static List<Integer> temp;
    public static void DFS(List<List<Integer>> al,boolean[] visited,int curr,int des){
        temp.add(curr);
        if(curr == des){
            res.add(new ArrayList<>(temp));
            temp.remove(temp.size()-1);
            return;
        }
        visited[curr] = true;
        for(int i=0;i<al.get(curr).size();i++){
            int adj = al.get(curr).get(i);
            if(visited[adj] == false){
                DFS(al,visited,adj,des);
            }
        }
        temp.remove(temp.size()-1);
        visited[curr] = false;
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> al = new ArrayList<>();
        res = new ArrayList<>();
        temp = new ArrayList<>();
        int n = graph.length;
        for(int i=0;i<n;i++){
            al.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<graph[i].length;j++){
                al.get(i).add(graph[i][j]);
            }
        }
        DFS(al,new boolean[n],0,n-1);
        return res;
    }
}
