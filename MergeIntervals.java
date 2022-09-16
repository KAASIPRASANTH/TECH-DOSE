import java.util.*;

public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        List<int[]> res = new ArrayList<>();
        for (int[] m : intervals) {
            int start = m[0];
            int end = m[1];
            if (res.size() == 0 || res.get(res.size() - 1)[1] < start) {
                res.add(m);
            } else {
                res.get(res.size() - 1)[1] = Math.max(res.get(res.size() - 1)[1], end);
            }
        }
        return res.toArray(new int[0][0]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] intervals = new int[n][2];
        for (int i = 0; i < n; i++) {
            intervals[i][0] = sc.nextInt();
            intervals[i][1] = sc.nextInt();
        }
        sc.close();
        int[][] res = merge(intervals);
        for (int[] interval : res) {
            System.out.print(interval[0] + " " + interval[1]);
        }
    }
}
