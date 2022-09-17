import java.util.*;
public class Prob25_LongestPalindromicSubstring {
    public static String longestPalindrome(String s) {
        int len=s.length();
		boolean[][] dp=new boolean[len][len];
		
		//for length 1
        int maxLength=1,index=0;
		for(int i=0;i<len;i++){
		    dp[i][i]=true;
		}
		
		//for length 2
		for(int i=0;i<len-1;i++){
		    if(s.charAt(i)==s.charAt(i+1)){
		        dp[i][i+1]=true;
                maxLength=2;
                index=i;
		    }
		}
		
		//for length greater than 2
		for(int k=3;k<=len;k++){
		    for(int i=0;i<=len-k;i++){
		        int start=i,end=i+k-1;
		        if(dp[start+1][end-1] && s.charAt(start)==s.charAt(end)){
		            dp[start][end]=true;
                    if(k>maxLength){
                        index=i;
                        maxLength=k;
                    }
		        }
		    }
		}
        return s.substring(index,index+maxLength);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        sc.close();
        System.out.println(longestPalindrome(str));
    }
}
