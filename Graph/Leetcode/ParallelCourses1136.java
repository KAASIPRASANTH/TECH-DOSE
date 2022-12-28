class Solution {
    public static int topo(List<List<Integer>> al,int[] inDeg,int n){
        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<=n;i++){
            if(inDeg[i]==0){
                q.add(i);
            }
        }
        List<Integer> res = new ArrayList<>();
        int semesterCount = 0;
        while(!q.isEmpty()){
            semesterCount++;
            int size = q.size();
            for(int i=0;i<size;i++){
                int prev = q.poll();
                res.add(prev);
                for(int j=0;j<al.get(prev).size();j++){
                    int next = al.get(prev).get(j);
                    if(--inDeg[next] == 0){
                        q.add(next);
                    }
                }
            }
        }
        System.out.println(res);
        return res.size()==n?semesterCount:-1;
    }
    public int minimumSemesters(int n, int[][] relations) {
        List<List<Integer>> al = new ArrayList<>();
        for(int i=0;i<=n;i++){
            al.add(new ArrayList<>());
        }
        int[] inDeg = new int[n+1];
        for(int[] con:relations){
            al.get(con[0]).add(con[1]);
            inDeg[con[1]]++;
        }
        return topo(al,inDeg,n);
    }
}
