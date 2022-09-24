import java.util.Scanner;

public class SortColors75 {
    public static void sortColors(int[] nums) {
        int n = nums.length;
        int left = 0, mid = 0, right = n - 1;
        while (mid <= right) {
            if (nums[mid] == 0) {
                int temp = nums[mid];
                nums[mid++] = nums[left];
                nums[left++] = temp;
            } else if (nums[mid] == 2) {
                int temp = nums[mid];
                nums[mid] = nums[right];
                nums[right--] = temp;
            } else {
                mid++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        sc.close();
        sortColors(nums);
        for (int val : nums) {
            System.out.print(val + " ");
        }
    }
}