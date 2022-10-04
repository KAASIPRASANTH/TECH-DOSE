import java.util.Scanner;

public class MajorityElementI169 {
    public static int majorityElement(int[] nums) {
        int majority = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (majority == nums[i]) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    majority = nums[i];
                    count = 1;
                }
            }
        }
        return majority;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        sc.close();
        System.out.println(majorityElement(nums));
    }
}
