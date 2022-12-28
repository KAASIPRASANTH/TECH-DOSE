class Solution {
    public static double BFS(List<List<Pair<Integer,Double>>> al,int n,int start,int end){
        double[] distance = new double[n+1];
        distance[start] = 1.0;
        PriorityQueue<Pair<Integer,Double>> pq = new  PriorityQueue<>((p1,p2)->{
            if(p1.getValue()>p2.getValue()){
                return -1;
            }
            if(p1.getValue()<p2.getValue()){
                return 1;
            }
            return 0;
        });
        pq.add(new Pair<>(start,distance[start]));
        while(pq.size()>0){
            Pair<Integer,Double> p = pq.poll();
            int vertex = p.getKey();
            double prob = p.getValue();
            if(vertex==end){
                break;
            }
            for(Pair<Integer,Double> pair:al.get(vertex)){
                int adj = pair.getKey();
                double dis = pair.getValue();
                if(prob*dis>distance[adj]){
                    distance[adj] = prob*dis;
                    pq.add(new Pair<>(adj,distance[adj]));
                }
            }
        }
        return distance[end];
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<List<Pair<Integer,Double>>> al = new ArrayList<>();
        for(int i=0;i<=n;i++){
            al.add(new ArrayList<>());
        }
        int index = 0;
        for(int[] con:edges){
            al.get(con[0]).add(new Pair<>(con[1],succProb[index]));
            al.get(con[1]).add(new Pair<>(con[0],succProb[index++]));
        }
        return BFS(al,n,start,end);
    }
}
