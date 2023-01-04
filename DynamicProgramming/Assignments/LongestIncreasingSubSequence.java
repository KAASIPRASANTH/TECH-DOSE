public class LongestIncreasingSubSequence {
    public static int upperBound(int[] LIS, int len, int val) {
        int index = -1, resVal = Integer.MAX_VALUE, left = 0, right = len - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (LIS[mid] < val) {
                left = mid + 1;
            } else {
                if (LIS[mid] < resVal) {
                    resVal = LIS[mid];
                    index = mid;
                }
                right = mid - 1;
            }
        }
        return index;
    }

    public static int findLCS(int[] nums) {
        int n = nums.length, len = 1;
        int[] LIS = new int[n];
        LIS[0] = nums[0];
        for (int i = 1; i < n; i++) {
            if (LIS[0] > nums[i]) {
                LIS[0] = nums[i];
            } else if (nums[i] > LIS[len - 1]) {
                LIS[len++] = nums[i];
            } else {
                int index = upperBound(LIS, len, nums[i]);
                LIS[index] = nums[i];
            }
        }
        return len;
    }

    public static void main(String[] args) {
        // int[] nums = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };
        int[] nums = { 5, 8, 7, 1, 9 };
        System.out.println(findLCS(nums));
    }
}

/*
  Time Complexity = O(N*logN)
  N-> N elements
  logN -> Binary Search to find upperbound
 */