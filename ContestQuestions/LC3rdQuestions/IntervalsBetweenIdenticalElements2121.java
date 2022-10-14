import java.util.*;

public class IntervalsBetweenIdenticalElements2121 {
    public static long[] getDistances(int[] arr) {
        int n = arr.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<Integer> al = map.getOrDefault(arr[i], new ArrayList<>());
            al.add(i);
            map.put(arr[i], al);
        }
        long[] res = new long[n];
        for (Map.Entry<Integer, List<Integer>> obj : map.entrySet()) {
            List<Integer> indices = obj.getValue();
            int size = indices.size();
            long[] prefSum = new long[size];
            for (int i = 0; i < size; i++) {
                prefSum[i] = (long) ((long) indices.get(i) + ((i > 0) ? prefSum[i - 1] : 0));
            }
            for (int i = 0; i < size && size > 1; i++) {
                long left = 0, right = 0;
                if (i == 0) {
                    right = (long) (prefSum[size - 1] - prefSum[i])
                            - ((long) (size - i - 1) * (long) indices.get(i));
                } else if (i == size - 1) {
                    left = ((long) i * indices.get(i)) - prefSum[i - 1];
                } else {
                    left = ((long) i * indices.get(i)) - prefSum[i - 1];
                    right = (prefSum[size - 1] - prefSum[i])
                            - ((long) (size - i - 1) * (long) indices.get(i));
                }
                res[indices.get(i)] = (long) (left + right);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        sc.close();
        long[] res = getDistances(nums);
        for (Long val : res) {
            System.out.print(val + " ");
        }
    }
}
