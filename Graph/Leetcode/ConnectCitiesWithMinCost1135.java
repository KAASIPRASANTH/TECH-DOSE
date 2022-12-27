class Solution {
    static int cost;
    public static void prims(List<List<Pair<Integer,Integer>>> al,int n){
        cost = 0;
        int[] distance = new int[n+1];
        boolean[] visited = new boolean[n+1];
        Arrays.fill(distance,Integer.MAX_VALUE);
        int vertex = 1;
        distance[vertex] = 0;
        int EdgesCount=0;
        while(vertex!=-1){
            ++EdgesCount;
            visited[vertex] = true;
            for(Pair<Integer,Integer> p:al.get(vertex)){
                int adj = p.getKey();
                int weight = p.getValue();
                if(visited[adj]==false && weight < distance[adj]){
                    distance[adj] = weight;
                } 
            }
            int minDistance = Integer.MAX_VALUE,minVertex = -1;
            for(int i=1;i<=n;i++){
                if(!visited[i] && distance[i]<minDistance){
                    minDistance = distance[i];
                    minVertex = i;
                }
            }
            vertex = minVertex;
            if(vertex!=-1){
                cost+=minDistance;
            }
        }
        if(EdgesCount!=n){
            cost = -1;
        }
    }
    public int minimumCost(int n, int[][] connections) {
        List<List<Pair<Integer,Integer>>> al = new ArrayList<>();
        for(int i=0;i<=n;i++){
            al.add(new ArrayList<>());
        }
        for(int[] con:connections){
            al.get(con[0]).add(new Pair<>(con[1],con[2]));
            al.get(con[1]).add(new Pair<>(con[0],con[2]));
        }
        prims(al,n);
        return cost;
    }
}
