class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int totSize = n+2;
        int[] arr = new int[totSize];
        for(int i=0;i<n;i++){
            arr[i+1] = nums[i];
        }
        arr[0]=1;arr[totSize-1]=1;
        int[][] dp = new int[totSize][totSize];
        for(int size=1;size<=n;size++){
            for(int left=1;left<=(n-size)+1;left++){
                int right = left+size-1;
                int res = 0;
                for(int k=left;k<=right;k++){
                    res = Math.max(res,dp[left][k-1]+dp[k+1][right]+(arr[left-1]*arr[k]*arr[right+1]));
                }
                dp[left][right] = Math.max(dp[left][right],res);
            }
        }
        return dp[1][n];
    }
}
