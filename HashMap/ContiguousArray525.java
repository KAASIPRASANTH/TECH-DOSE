import java.util.*;
public class ContiguousArray525 {
    public static int findMaxLength(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int sum = 0,max = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i] == 0? -1 : 1;
            if(map.containsKey(sum)){
                max = Math.max(max,i - map.get(sum));
            }else{
                map.put(sum,i);
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int[] nums = {0,1,0};
        System.out.println(findMaxLength(nums));
    }
}
