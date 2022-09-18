import java.util.*;

public class Prob74_MergeSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int lastPos = (m + n) - 1;
        for (int i = n - 1; i >= 0; i--) {
            int last = 0, j;
            if (m > 0)
                last = nums1[m - 1];
            for (j = m - 2; j >= 0 && nums1[j] > nums2[i]; j--) {
                nums1[j + 1] = nums1[j];
            }
            if (m > 0 && j == m - 2 && last > nums2[i]) {
                nums1[j + 1] = nums2[i];
                nums1[lastPos--] = last;
            } else if (m > 0 && j != m - 2 && last > nums2[i]) {
                nums1[j + 1] = nums2[i];
                nums1[lastPos--] = last;
            } else {
                nums1[lastPos--] = nums2[i];
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size1 = sc.nextInt();
        int size2 = sc.nextInt();
        int[] nums1 = new int[size1];
        int[] nums2 = new int[size2];
        int m = sc.nextInt();
        int n = sc.nextInt();
        for (int i = 0; i < m; i++) {
            nums1[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            nums2[i] = sc.nextInt();
        }
        sc.close();
        merge(nums1, m, nums2, n);
        for (int val : nums1) {
            System.out.print(val + " ");
        }
    }
}
