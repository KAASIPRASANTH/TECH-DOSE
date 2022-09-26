import java.util.*;

public class ClosestSubsequenceSum1755 {
    public static int closestSubSum(List<Integer> s1, List<Integer> s2, int target) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, len1 = s1.size(), len2 = s2.size();
        for (int i = 0; i < len1; i++) {
            int x = s1.get(i), low = 0, high = len2 - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                int sum = x + s2.get(mid);
                if (sum == target) {
                    return 0;
                }
                if (sum > target) {
                    min = Math.min(min, sum);
                    high = mid - 1;
                } else {
                    max = Math.max(max, sum);
                    low = mid + 1;
                }
            }
        }
        int res = Math.min(Math.abs(max - target), Math.abs(min - target));
        return res;
    }

    public static List<Integer> possibleSum(int[] nums, int low, int high, int n) {
        List<Integer> res = new ArrayList<>();
        int totEle = (high - low) + 1, index = 0;
        int[] arr = new int[totEle];
        for (int i = low; i <= high; i++) {
            arr[index++] = nums[i];
        }
        for (int i = 0; i < (1 << totEle); i++) {
            int sum = 0;
            for (int j = 0; j < totEle; j++) {
                if ((i & (1 << j)) > 0) {
                    sum += arr[j];
                }
            }
            res.add(sum);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        sc.close();
        int mid = (n - 1) / 2;
        List<Integer> s1 = possibleSum(nums, 0, mid, n);
        List<Integer> s2 = possibleSum(nums, mid + 1, n - 1, n);
        Collections.sort(s2);
        System.out.println(closestSubSum(s1, s2, target));
    }
}
