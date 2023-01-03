// Interview Bit https://www.interviewbit.com/problems/minimum-difference-subsets/
public class Solution {
    public int solve(int[] A) {
        int n = A.length,sum=0;
        for(int val:A){
            sum+=val;
        }
        int s1 = sum/2;
        boolean[][] dp = new boolean[n+1][s1+1];
        dp[0][0] = true;
        for(int i=1;i<=n;i++){
            for(int j=0;j<=s1;j++){
                if(A[i-1]>j){
                    dp[i][j]  =dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j]||dp[i-1][j-A[i-1]];
                }
            }
        }
        int sum1=0;
        for(int j=0;j<=s1;j++){
            if(dp[n][j]){
                sum1=j;
            }
        }
        int sum2 = sum-sum1;
        return Math.abs(sum1-sum2);
    }
}
