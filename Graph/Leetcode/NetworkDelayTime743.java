class Solution {
    static int cost;
    public static int BFS(List<List<Pair<Integer,Integer>>> al,int n,int k){
        cost = 0;
        Queue<Integer> q = new LinkedList<>();
        int[] distance = new int[n+1];
        Arrays.fill(distance,Integer.MAX_VALUE);
        q.add(k);
        distance[k] = 0;
        while(!q.isEmpty()){
            int poll = q.poll();
            for(Pair<Integer,Integer> p:al.get(poll)){
                int adj = p.getKey();
                int weight = p.getValue();
                if(distance[poll]+weight < distance[adj]){
                    distance[adj] = distance[poll]+weight;
                    q.add(adj);
                }
            }
        }
        for(int i=1;i<=n;i++){
            if(distance[i]==Integer.MAX_VALUE){
                return -1;
            }
            cost = Math.max(cost,distance[i]);
        }
        return cost;
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair<Integer,Integer>>> al = new ArrayList<>();
        for(int i=0;i<=n;i++){
            al.add(new ArrayList<>());
        }
        for(int[] con:times){
            al.get(con[0]).add(new Pair<>(con[1],con[2]));
        }
        return BFS(al,n,k);
    }
}
