class Solution {
    public static String findLCS(String s1,String s2){
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        String LCS="";
        while(m!=0 && n!=0){
            if(s1.charAt(m-1) == s2.charAt(n-1)){
                LCS=s1.charAt(m-1)+LCS;
                m--;n--;
            }else{
                if(dp[m][n-1]>dp[m-1][n]){
                    n--;
                }else{
                    m--;
                }
            }
        }
        return LCS;
    }
    public String shortestCommonSupersequence(String str1, String str2) {
        String LCS = findLCS(str1,str2),SCS="";
        int index1=0,index2=0;
        for(char ch:LCS.toCharArray()){
            while(index1<str1.length() && str1.charAt(index1) != ch){
                SCS+=str1.charAt(index1)+"";
                ++index1;
            }
            while(index2<str2.length() && str2.charAt(index2) != ch){
                SCS+=str2.charAt(index2)+"";
                ++index2;
            }
            SCS+=ch+"";
            ++index1;++index2;
        }
        while(index1<str1.length()){
            SCS+=str1.charAt(index1)+"";
            ++index1;
        }
        while(index2<str2.length()){
            SCS+=str2.charAt(index2)+"";
            ++index2;
        }
        return SCS;
    }
}
