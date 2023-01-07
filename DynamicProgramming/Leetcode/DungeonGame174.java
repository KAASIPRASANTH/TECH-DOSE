class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m][n];
        dp[m-1][n-1] = dungeon[m-1][n-1]>=0?0:dungeon[m-1][n-1];
        for(int j=n-2;j>=0;j--){
            int spend = dungeon[m-1][j]+dp[m-1][j+1];
            dp[m-1][j] = spend<0?spend:0;
        }
        for(int i=m-2;i>=0;i--){
            int spend = dungeon[i][n-1]+dp[i+1][n-1];
            dp[i][n-1] = spend<0?spend:0;
        }
        for(int i=m-2;i>=0;i--){
            for(int j=n-2;j>=0;j--){
                int spend = Math.max(dp[i+1][j],dp[i][j+1])+dungeon[i][j];
                dp[i][j] = spend<0?spend:0;
            }
        }
        return Math.abs(dp[0][0])+1;
    }
}
