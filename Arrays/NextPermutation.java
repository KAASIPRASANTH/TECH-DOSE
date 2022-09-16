import java.util.*;

public class NextPermutation {
    public static void nextPermutation(int[] nums) {
        int index = -1, n = nums.length;
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] < nums[i]) {
                index = i;
            }
        }
        if (index == -1) {
            Arrays.sort(nums);
            return;
        }
        int swapIndex = index;
        for (int i = index; i < n; i++) {
            if (nums[i] > nums[index - 1] && nums[swapIndex] > nums[i]) {
                swapIndex = i;
            }
        }
        int temp = nums[index - 1];
        nums[index - 1] = nums[swapIndex];
        nums[swapIndex] = temp;
        Arrays.sort(nums, index, n);
        return;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        sc.close();
        nextPermutation(nums);
    }
}
