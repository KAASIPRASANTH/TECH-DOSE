import java.util.*;

public class RangeSum {
    static int[] segmentTree;

    public static int buildSegmentTree(int SI, int[] nums, int sl, int sr) {
        if (sl == sr) {
            return segmentTree[SI] = nums[sl];
        }
        int mid = sl + (sr - sl) / 2;
        int leftSide = buildSegmentTree(SI * 2 + 1, nums, sl, mid);
        int rightSide = buildSegmentTree(SI * 2 + 2, nums, mid + 1, sr);
        segmentTree[SI] = leftSide + rightSide;
        return segmentTree[SI];
    }

    public static int getRangeSum(int SI, int sl, int sr, int left, int right) {
        if (right < sl || sr < left) { // partially overlap
            return 0;
        }
        if (left <= sl && sr <= right) {// Fully overlap
            return segmentTree[SI];
        }
        int mid = sl + (sr - sl) / 2;
        int leftSide = getRangeSum(SI * 2 + 1, sl, mid, left, right);
        int rightSide = getRangeSum(SI * 2 + 2, mid + 1, sr, left, right);
        return leftSide + rightSide;
    }

    public static int update(int SI, int sl, int sr, int pos, int newVal) {
        if (sl > pos || sr < pos) { // no overlap
            return segmentTree[SI];
        }
        if (sl == sr && sl == pos) {
            return segmentTree[SI] = newVal;
        }
        int mid = sl + (sr - sl) / 2;
        int leftSide = update(SI * 2 + 1, sl, mid, pos, newVal);
        int rightSide = update(SI * 2 + 2, mid + 1, sr, pos, newVal);
        segmentTree[SI] = leftSide + rightSide;
        return segmentTree[SI];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        sc.close();
        int height = (int) Math.ceil(Math.log10(n) / Math.log10(2)) + 1;
        int size = (1 << height) - 1;
        segmentTree = new int[size];

        // Building an segement Tree
        int sum = buildSegmentTree(0, nums, 0, n - 1);
        System.out.println("sum : " + sum);
        // get Range Sum
        System.out.println("Range Sum (0,4) : " + getRangeSum(0, 0, n - 1, 0, 4));
        System.out.println("Range Sum (0,2) : " + getRangeSum(0, 0, n - 1, 0, 2));
        System.out.println("Range Sum (2,5) : " + getRangeSum(0, 0, n - 1, 2, 5));

        // update
        sum = update(0, 0, n - 1, 0, 2);
        // get Range Sum
        System.out.println("Range Sum (0,4) : " + getRangeSum(0, 0, n - 1, 0, 4));
        System.out.println("Range Sum (0,2) : " + getRangeSum(0, 0, n - 1, 0, 2));
        System.out.println("Range Sum (2,5) : " + getRangeSum(0, 0, n - 1, 2, 5));
    }
}