import java.util.*;

public class Prob15_KClosestPointsToOrigin {
    public static int distance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    public static int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, (point1, point2) -> {
            return distance(point1) - distance(point2);
        });
        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            res[i][0] = points[i][0];
            res[i][1] = points[i][1];
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] points = new int[n][2];
        for (int i = 0; i < n; i++) {
            points[i][0] = sc.nextInt();
            points[i][1] = sc.nextInt();
        }
        int k = sc.nextInt();
        sc.close();
        int[][] res = kClosest(points, k);
        for (int[] point : res) {
            System.out.println(point[0] + " " + point[1]);
        }
    }
}