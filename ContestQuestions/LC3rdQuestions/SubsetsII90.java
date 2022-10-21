import java.util.*;
public class SubsetsII90 {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        int n = nums.length;
        Set<List<Integer>> set = new HashSet<>();
        for(int i=0;i<(1<<n);i++){
            List<Integer> al = new ArrayList<>();
            for(int j=0;j<n;j++){
                if((i&(1<<j)) > 0){
                    al.add(nums[j]);
                }
            }
            Collections.sort(al);
            set.add(al);
        }
        return new ArrayList<>(set);
    }
    public static void main(String[] args) {
        int[] nums = {1,2,2};
        System.out.println(subsetsWithDup(nums));
    }
}
