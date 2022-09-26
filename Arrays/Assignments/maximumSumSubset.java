import java.util.*;

public class maximumSumSubset {
    public static int maxSumSubset(List<Integer> s1, List<Integer> s2, int target) {
        System.out.println(s1 + " " + s2);
        int max = Integer.MIN_VALUE, len1 = s1.size(), len2 = s2.size();
        Collections.sort(s2);
        for (int i = 0; i < len1; i++) {
            int x = s1.get(i), low = 0, high = len2 - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                int sum = x + s2.get(mid);
                if (sum > target) {
                    high = mid - 1;
                } else {
                    if (max < sum)
                        max = sum;
                    low = mid + 1;
                }
            }
        }
        return max;
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
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int sum = sc.nextInt();
        int mid = (n - 1) / 2;
        List<Integer> s1 = possibleSum(arr, 0, mid, n);
        List<Integer> s2 = possibleSum(arr, mid + 1, n - 1, n);
        System.out.println(maxSumSubset(s1, s2, sum) + "");
        sc.close();
    }
}
