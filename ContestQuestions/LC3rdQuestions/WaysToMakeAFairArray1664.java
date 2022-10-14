

import java.util.*;

public class WaysToMakeAFairArray1664 {
    public static int waysToMakeFair(int[] nums) {
        int n = nums.length;
        int[] evenPrefix = new int[n];
        int[] oddPrefix = new int[n];
        int oddSum = 0, evenSum = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 1) {
                oddSum += nums[i];
            } else {
                evenSum += nums[i];
            }
            evenPrefix[i] = evenSum;
            oddPrefix[i] = oddSum;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            int odd = 0, even = 0;
            if (i == 0) {
                odd = evenPrefix[n - 1] - evenPrefix[i];
                even = oddPrefix[n - 1] - oddPrefix[i];
            } else {
                odd = evenPrefix[n - 1] - evenPrefix[i] + oddPrefix[i - 1];
                even = oddPrefix[n - 1] - oddPrefix[i] + evenPrefix[i - 1];
            }

            if (odd == even) {
                res++;
            }
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
        sc.close();
        System.out.println(waysToMakeFair(nums));
    }
}
