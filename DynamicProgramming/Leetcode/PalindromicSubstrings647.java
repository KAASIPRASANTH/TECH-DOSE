class Solution {
    public int countSubstrings(String s) {
        int len = s.length(), count = 0;
        boolean[][] dp = new boolean[len][len];
        
        //for length = 1 palindrom
        for(int i=0;i<len;i++){
            dp[i][i] = true;
            ++count;
        }
        
        //for length = 2 palindrom
        for(int i=0;i<len-1;i++){
            if(s.charAt(i) == s.charAt(i+1)){
                dp[i][i+1] = true;
                ++count;
            }
        }
        
        //for length>=3 palindrom
        for(int k=3;k<=len;k++){
            for(int i=0;i<=len-k;i++){
                int start = i, end = i+k-1;
                if(dp[start+1][end-1] && s.charAt(start) == s.charAt(end)){
                    ++count;
                    dp[start][end] = true;
                }
            }
        }
        return count;
    }
}
