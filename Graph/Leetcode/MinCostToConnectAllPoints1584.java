class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length,cost=0;
        boolean[] visited = new boolean[n];
        int[] distance = new int[n];
        Arrays.fill(distance,Integer.MAX_VALUE);
        List<int[]> al = new ArrayList<>();
        for(int[]  con:points){
            al.add(new int[]{con[0],con[1]});
        }
        int vertex = 0;
        while(vertex!=-1){
            visited[vertex] = true;
            int x1 = al.get(vertex)[0];
            int y1 = al.get(vertex)[1];
            for(int i=0;i<n;i++){
                int x2 = al.get(i)[0];
                int y2 = al.get(i)[1];
                int dis = Math.abs(x1-x2)+Math.abs(y1-y2);
                if(visited[i]==false && distance[i]>dis){
                    distance[i] = dis;
                }
            }
            int minDis=Integer.MAX_VALUE,minDisVertex=-1;
            for(int i=0;i<n;i++){
                if(visited[i]==false && distance[i]<minDis){
                    minDis = distance[i];
                    minDisVertex = i;
                }
            }
            if(minDis != Integer.MAX_VALUE){
                cost+=minDis;
            }
            vertex = minDisVertex;
        }
        return cost;
    }
}
