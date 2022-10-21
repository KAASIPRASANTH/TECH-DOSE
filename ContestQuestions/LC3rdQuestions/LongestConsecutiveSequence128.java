import  java.util.*;
public class LongestConsecutiveSequence128 {
    public static int longestConsecutive(int[] nums) {
        int n = nums.length,max = 0;
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++) set.add(nums[i]);
        for(int num : set){
            if(!set.contains(num-1)){ // identifying first value
                int currLen = 1;
                int currNum = num+1;
                while(set.contains(currNum)){
                    ++currNum;
                    ++currLen;
                }
                max = Math.max(max,currLen);
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        System.out.println(longestConsecutive(nums));
    }
}
