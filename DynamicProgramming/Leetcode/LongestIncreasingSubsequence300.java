class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length,res = 1;
        int[] LIS = new int[n];
        Arrays.fill(LIS,1);
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                if(nums[j]<nums[i] && LIS[j]>=LIS[i]){
                    ++LIS[i];
                    res = Math.max(res,LIS[i]);
                }
            }
        }
        return res;
    }
}
