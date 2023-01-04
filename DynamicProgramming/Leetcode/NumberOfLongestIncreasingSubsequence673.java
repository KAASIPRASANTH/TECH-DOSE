class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length,max=1;
        int[] LIS = new int[n];
        int[] count = new int[n];
        Arrays.fill(LIS,1);
        Arrays.fill(count,1);
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    if(LIS[j]>=LIS[i]){
                        ++LIS[i];
                        count[i] = count[j];
                    }else if(LIS[j]+1 == LIS[i]){
                        count[i]+=count[j];
                    }
                }
            }
            max = Math.max(max,LIS[i]);
        }
        int res=0;
        for(int i=0;i<n;i++){
            if(LIS[i]==max){
                res+=count[i];
            }
        }
        return res;
    }
}
