public class CountSubarraysWithFixedBounds2444 {
    public static long countSubarrays(int[] nums, int minK, int maxK) {
        long res=0,minIndex=-1,maxIndex=-1,wrongIndex=-1,n=nums.length;
        for(int i=0;i<n;++i){
            if(nums[i]<minK || nums[i]>maxK){
                wrongIndex = i;
            }
            if(nums[i] == minK){
                minIndex = i;
            }
            if(nums[i] == maxK){
                maxIndex = i;
            }
            if(minIndex>=0 && maxIndex>=0) res += Math.max(0L,Math.min(minIndex,maxIndex)-wrongIndex);
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums = {1,3,5,2,7,5};
        int minK = 1,maxK = 5;
        System.out.println(countSubarrays(nums,minK,maxK));
    }
}
