class Solution {
    static Map<Integer,Set<Integer>> map;
    public static void topo(List<List<Integer>> al,int[] inDeg,int n){
        map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(i,new HashSet<>());
        }
        Queue<Integer> q = new LinkedList<>();
        int count=0;
        for(int i=0;i<n;i++){
            if(inDeg[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int prev = q.poll();
            for(int i=0;i<al.get(prev).size();i++){
                int next = al.get(prev).get(i);
                map.get(next).add(prev);
                map.get(next).addAll(map.get(prev));
                if(--inDeg[next] == 0){
                    q.add(next);
                }
            }
        }
    }
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        List<List<Integer>> al = new ArrayList<>();
        for(int i=0;i<n;i++){
            al.add(new ArrayList<>());
        }
        int[] inDeg = new int[n];
        for(int[] con:prerequisites){
            if(!al.get(con[0]).contains(con[1])){
                al.get(con[0]).add(con[1]);
            }
            inDeg[con[1]]++;
        }
        topo(al,inDeg,n);
        List<Boolean> res = new ArrayList<>();
        for(int[] q:queries){
            if(map.get(q[1]).contains(q[0])){
                res.add(true);
            }else{
                res.add(false);
            }
        }
        return res;
    }
}
