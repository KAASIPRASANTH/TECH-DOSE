class Solution {
    public int longestPalindromeSubseq(String s1) {
        String s2 = new StringBuilder(s1).reverse().toString();
        int len = s1.length();
        int[][] dp = new int[len+1][len+1];
        for(int i=1;i<=len;i++){
            for(int j=1;j<=len;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return dp[len][len];
    }
}
