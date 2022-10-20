import  java.util.*;
public class Subsets78 {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        for(int i=0;i<(1<<n);i++){
            List<Integer> al = new ArrayList<>();
            for(int j=0;j<n;j++){
                if((i&(1<<j)) > 0){
                    al.add(nums[j]);
                }
            }
            res.add(al);
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(subsets(nums));
    }
}
