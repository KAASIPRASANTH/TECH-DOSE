class Solution {
    public static int find(int vertex,int[] parent){
        if(parent[vertex]==-1){
            return vertex;
        }
        return parent[vertex] = find(parent[vertex],parent);
    }
    public static void union(int ap1,int ap2,int[] parent){
        parent[ap1] = ap2;
    }
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int[] parent = new int[n+1];
        int[] aliceParent = new int[n+1];
        int[] bobParent = new int[n+1];
        Arrays.sort(edges,(a,b)->{
            return b[0]-a[0];
        });
        Arrays.fill(parent,-1);
        Arrays.fill(aliceParent,-1);
        Arrays.fill(bobParent,-1);
            
        int aliceCount=0,bobCount=0,res=0;
        
        for(int[] con:edges){
            int type = con[0];
            int u = con[1];
            int v = con[2];
            if(type == 3){
                int AP1 = find(u,parent);
                int AP2 = find(v,parent);
                if(AP1 == AP2){
                    res++;
                }else{
                    union(AP1,AP2,parent);
                    union(AP1,AP2,aliceParent);
                    union(AP1,AP2,bobParent);
                    aliceCount++;
                    bobCount++;
                }
            }else if(type == 1){
                int AP1 = find(u,aliceParent);
                int AP2 = find(v,aliceParent);
                if(AP1 == AP2){
                    res++;
                }else{
                    union(AP1,AP2,aliceParent);
                    aliceCount++;
                }
            }else if(type == 2){
                int AP1 = find(u,bobParent);
                int AP2 = find(v,bobParent);
                if(AP1 == AP2){
                    res++;
                }else{
                    union(AP1,AP2,bobParent);
                    bobCount++;
                }
            }
        }
        if(aliceCount<n-1 || bobCount<n-1){
            return -1;
        }
        return res;
    }
}
