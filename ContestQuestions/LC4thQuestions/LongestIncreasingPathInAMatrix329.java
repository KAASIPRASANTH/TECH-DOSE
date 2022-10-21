public class LongestIncreasingPathInAMatrix329 {
    static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    public static int DFS(int[][] matrix,int m,int n,int i,int j,int[][] dp){
        int max = 0;
        if(dp[i][j]>0){
            return dp[i][j];
        }
        for(int[] d:dir){
            int x = i+d[0];
            int y = j+d[1];
            if(x>=0 && y>=0 && x<m && y<n && matrix[i][j]<matrix[x][y]){
                max = Math.max(max,DFS(matrix,m,n,x,y,dp));
            }
        }
        dp[i][j] = max+1;
        return max+1;
    }
    public static int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        if(m == 0) return 0;
        int res = 0;
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                res = Math.max(res,DFS(matrix,m,n,i,j,dp));
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[][] matrix = {
                {9,9,4},
                {6,6,8},
                {2,1,1}
        };
        System.out.println(longestIncreasingPath(matrix));
    }
}
