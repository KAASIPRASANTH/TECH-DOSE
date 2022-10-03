import java.util.*;

public class RangeSumQueryImmutable303 {
    static int[] sum;

    public static void NumArray(int[] nums) {
        int n = nums.length;
        sum = new int[n];
        sum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
    }

    public static int sumRange(int left, int right) {
        return sum[right] - ((left > 0) ? sum[left - 1] : 0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        sc.close();
        NumArray(nums);
        System.out.println(sumRange(0, 3));
        System.out.println(sumRange(2, 4));
    }
}
