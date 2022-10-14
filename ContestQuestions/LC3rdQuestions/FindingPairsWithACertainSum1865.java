

import java.util.*;

public class FindingPairsWithACertainSum1865 {
    static int[] n1, n2;
    static Map<Integer, Integer> map = new HashMap<>();

    public static void FindSumPairs(int[] nums1, int[] nums2) {
        n1 = nums1;
        n2 = nums2;
        for (int i = 0; i < n2.length; i++) {
            map.put(n2[i], map.getOrDefault(n2[i], 0) + 1);
        }
    }

    public static void add(int index, int val) {
        map.put(n2[index], map.getOrDefault(n2[index], 0) - 1);
        n2[index] += val;
        map.put(n2[index], map.getOrDefault(n2[index], 0) + 1);
    }

    public static int count(int tot) {
        int NumOfPairs = 0;
        for (int val : n1) {
            NumOfPairs += map.getOrDefault((tot - val), 0);
        }
        return NumOfPairs;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums1 = new int[n];
        int[] nums2 = new int[n];
        for (int i = 0; i < n; i++) {
            nums1[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            nums2[i] = sc.nextInt();
        }
        FindSumPairs(nums1, nums2);
        System.out.println(count(23));
        add(13, n - 1);
        System.out.println(count(12));
        sc.close();
    }
}
