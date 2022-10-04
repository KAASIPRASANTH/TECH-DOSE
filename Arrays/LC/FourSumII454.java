import java.util.*;

public class FourSumII454 {
    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int sum = nums1[i] + nums2[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        for (int i = 0; i < nums3.length; i++) {
            for (int j = 0; j < nums4.length; j++) {
                int sum = nums3[i] + nums4[j];
                count += map.getOrDefault(-1 * sum, 0);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int[] nums1 = new int[n1];
        for (int i = 0; i < n1; i++) {
            nums1[i] = sc.nextInt();
        }
        int n2 = sc.nextInt();
        int[] nums2 = new int[n2];
        for (int i = 0; i < n2; i++) {
            nums2[i] = sc.nextInt();
        }
        int n3 = sc.nextInt();
        int[] nums3 = new int[n3];
        for (int i = 0; i < n2; i++) {
            nums3[i] = sc.nextInt();
        }
        int n4 = sc.nextInt();
        int[] nums4 = new int[n4];
        for (int i = 0; i < n1; i++) {
            nums4[i] = sc.nextInt();
        }
        sc.close();
        System.out.println(fourSumCount(nums1, nums2, nums3, nums4));
    }
}
