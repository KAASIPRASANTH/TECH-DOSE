

import java.util.*;

public class NumberOfSubarraysWithBoundedMaximum795 {
    public static int numSubarrayBoundedMax(int[] nums, int l, int r) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(left, -1);
        Arrays.fill(right, n);
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && nums[s.peek()] <= nums[i]) {
                s.pop();
            }
            if (!s.isEmpty()) {
                left[i] = s.peek();
            }
            s.push(i);
        }
        s.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && nums[s.peek()] < nums[i]) {
                s.pop();
            }
            if (!s.isEmpty()) {
                right[i] = s.peek();
            }
            s.push(i);
        }
        int numOfSubArrays = 0;
        for (int i = 0; i < n; i++) {
            // System.out.println(nums[i]+" "+left[i]+" "+right[i]);
            int leftSide = i - left[i];
            int rightSide = right[i] - i;
            if (nums[i] >= l && nums[i] <= r)
                numOfSubArrays += (leftSide * rightSide);
        }
        return numOfSubArrays;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int left = sc.nextInt();
        int right = sc.nextInt();
        sc.close();
        System.out.println(numSubarrayBoundedMax(nums, left, right));
    }
}
