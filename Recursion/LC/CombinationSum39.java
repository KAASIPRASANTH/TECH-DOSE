import java.util.*;

public class CombinationSum39 {
    static Set<List<Integer>> set;
    static List<List<Integer>> res;
    static List<Integer> temp;
    static int n;

    public static void solve(int[] nums, int target, int sum) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            List<Integer> al = new ArrayList<>(temp);
            Collections.sort(al);
            if (set.add(al)) {
                res.add(new ArrayList<>(temp));
            }
            return;
        }
        for (int i = 0; i < n; i++) {
            temp.add(nums[i]);
            solve(nums, target, sum + nums[i]);
            temp.remove(temp.size() - 1);
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        set = new HashSet<>();
        res = new ArrayList<>();
        temp = new ArrayList<>();
        n = candidates.length;
        solve(candidates, target, 0);
        return res;
    }

    public static void main(String[] args) {
        int[] candidates = { 2, 3, 6, 7 };
        int target = 7;
        System.out.println(combinationSum(candidates, target));
    }
}
