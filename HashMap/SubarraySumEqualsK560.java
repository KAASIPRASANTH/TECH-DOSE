import java.util.*;
public class SubarraySumEqualsK560 {
    public static int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int sum = 0,cnt=0;
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            if(map.containsKey(sum-k)){
                 cnt+=map.get(sum-k);
                 map.put(sum,map.getOrDefault(sum,0)+1);
            }else{
                 map.put(sum,map.getOrDefault(sum,0)+1);
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        int[] nums = {1,1,1};
        int k = 2;
        System.out.println(subarraySum(nums, k));
    }
}
