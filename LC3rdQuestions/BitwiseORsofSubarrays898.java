

import java.util.*;

public class BitwiseORsofSubarrays898 {
    public static int subarrayBitwiseORs(int[] arr) {
        Set<Integer> res = new HashSet<>();
        Set<Integer> prev = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            Set<Integer> curr = new HashSet<>();
            curr.add(arr[i]);
            for (int val : prev) {
                curr.add(val | arr[i]);
            }
            prev = curr;
            res.addAll(prev);
        }
        return res.size();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        System.out.println(subarrayBitwiseORs(arr));
    }
}
