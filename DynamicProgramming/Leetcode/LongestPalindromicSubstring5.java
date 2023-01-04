class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        int startPos=0,maxLen=1;
        boolean[][] dp = new boolean[len][len];
        
        //for length = 1
        for(int i=0;i<len;i++){
            dp[i][i] = true;
        }
        
        //for length = 2
        for(int i=0;i<len-1;i++){
            if(s.charAt(i) == s.charAt(i+1)){
                dp[i][i+1]= true;
                startPos = i;
                maxLen = 2;
            }
        }
        
        //for length>=3
        for(int k=3;k<=len;k++){
            for(int i=0;i<=len-k;i++){
                int start = i,end = i+k-1;
                if(dp[start+1][end-1] && s.charAt(start) == s.charAt(end)){
                    dp[start][end] = true;
                    if(maxLen<k){
                        maxLen = k;
                        startPos=start;
                    }
                }
            }
        }
        return s.substring(startPos,startPos+maxLen);
    }
}
