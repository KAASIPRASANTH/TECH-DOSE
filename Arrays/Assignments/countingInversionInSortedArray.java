import java.util.*;

public class countingInversionInSortedArray {
    public static int countOfInversions(int[] nums1, int[] nums2, int m, int n) {
        int count = 0, i = 0, j = 0;
        while (i < m && j < n) {
            if (nums1[i] > nums2[j]) {
                count += (m - i);
                j++;
            } else {
                i++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[] nums1 = new int[m];
        int[] nums2 = new int[n];
        for (int i = 0; i < m; i++) {
            nums1[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            nums2[i] = sc.nextInt();
        }
        sc.close();
        System.out.println(countOfInversions(nums1, nums2, m, n) + "");
    }
}
