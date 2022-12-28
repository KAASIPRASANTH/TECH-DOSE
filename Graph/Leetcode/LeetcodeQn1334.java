class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] arr = new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(arr[i],Integer.MAX_VALUE);
            arr[i][i]=0;
        }
        for(int[] con:edges){
            arr[con[0]][con[1]] = con[2];
            arr[con[1]][con[0]] = con[2];
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    if(j!=k && j!=i && k!=i){
                        if(arr[j][i]!=Integer.MAX_VALUE && arr[i][k]!=Integer.MAX_VALUE){
                            arr[j][k] = Math.min(arr[j][k],arr[j][i]+arr[i][k]);
                        }
                    }
                }
            }
        }
        int[] smallNumNeighbors = new int[n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]>0 && arr[i][j]<=distanceThreshold){
                    smallNumNeighbors[i]++;
                }
            }
        }
        int vertex = -1,neighborsCount=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(neighborsCount>=smallNumNeighbors[i]){
                neighborsCount = smallNumNeighbors[i];
                vertex = i;
            }
        }
        return vertex;
    }
}
