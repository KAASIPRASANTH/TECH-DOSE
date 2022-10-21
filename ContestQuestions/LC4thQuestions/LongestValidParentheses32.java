import java.util.*;

public class LongestValidParentheses32 {
    public static int longestValidParentheses(String s) {
        int len = s.length();
        int[] dp = new int[len];
        int max = 0;
        for(int i=1;i<len;i++){
            if(s.charAt(i) == ')'){
                if(s.charAt(i-1) == '('){
                    dp[i] = (i>=2?dp[i-2]:0)+2;
                }else if((i-dp[i-1])>0 && s.charAt(i-dp[i-1]-1) == '('){
                    dp[i] = dp[i-1]+(i-dp[i-1]>=2?dp[i-dp[i-1]-2]:0)+2;
                }
                max = Math.max(max,dp[i]);
            }
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        sc.close();
        System.out.println(longestValidParentheses(s));
    }
}
