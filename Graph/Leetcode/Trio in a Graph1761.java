class Solution {
    public int minTrioDegree(int n, int[][] edges) {
        boolean[][] graph = new boolean[n][n];
        int[] inDeg = new int[n];
        for(int[] edge:edges){
            graph[edge[0]-1][edge[1]-1]=true;
            graph[edge[1]-1][edge[0]-1]=true;
            inDeg[edge[0]-1]++;
            inDeg[edge[1]-1]++;
        }
        int res = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    if(graph[i][j] && graph[j][k] && graph[k][i]){
                        res = Math.min(res,inDeg[i]+inDeg[j]+inDeg[k]-6);
                    }
                }
            }
        }
        return res==Integer.MAX_VALUE?-1:res;
    }
}
