class Solution {
    static int[] disc,low,parent;
    static List<List<Integer>> res;
    static int time;
    public static void DFS(List<List<Integer>> al,int u){
        disc[u]=low[u]=time++;
        for(int i=0;i<al.get(u).size();i++){
            int v = al.get(u).get(i);
            if(disc[v] == -1){
                parent[v] = u;
                DFS(al,v);
                low[u] = Math.min(low[u],low[v]);
                if(low[v]>disc[u]){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(u);
                    temp.add(v);
                    res.add(temp);
                }
            }else if(parent[u]!=v){
                low[u] = Math.min(low[u],disc[v]);
            }
        }
    }
    public static void findBridge(List<List<Integer>> al,int n){
        time = 0;
        parent = new int[n];
        disc = new int[n];
        low = new int[n];
        Arrays.fill(parent,-1);
        Arrays.fill(disc,-1);
        Arrays.fill(low,-1);
        for(int i=0;i<n;i++){
            if(disc[i]==-1){
                DFS(al,i);
            }
        }    
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> al = new ArrayList<>();
        res = new ArrayList<>();
        for(int i=0;i<n;i++){
            al.add(new ArrayList<>());
        }
        for(List<Integer> con:connections){
            al.get(con.get(0)).add(con.get(1));
            al.get(con.get(1)).add(con.get(0));
        }
        findBridge(al,n);
        return res;
    }
}
