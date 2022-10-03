import java.util.*;

public class RangeSumQueryMutable307 {
    static int n, size;
    static int[] segmentTree;

    public static int createSegmet(int[] segmentTree, int[] nums, int SI, int sl, int sr) {
        if (sl == sr) {
            return (segmentTree[SI] = nums[sl]);
        }
        int mid = sl + (sr - sl) / 2;
        int left = createSegmet(segmentTree, nums, SI * 2 + 1, sl, mid);
        int right = createSegmet(segmentTree, nums, SI * 2 + 2, mid + 1, sr);
        segmentTree[SI] = left + right;
        return segmentTree[SI];
    }

    public static int updateSegment(int[] segmentTree, int SI, int sl, int sr, int pos, int value) {
        if (sl == sr && sl == pos) {
            segmentTree[SI] = value;
            return segmentTree[SI];
        }
        if (pos < sl || sr < pos) {
            return segmentTree[SI];
        }
        int mid = sl + (sr - sl) / 2;
        int left = updateSegment(segmentTree, SI * 2 + 1, sl, mid, pos, value);
        int right = updateSegment(segmentTree, SI * 2 + 2, mid + 1, sr, pos, value);
        segmentTree[SI] = left + right;
        return segmentTree[SI];
    }

    public static int getSumInRange(int[] segment, int sI, int sl, int sr, int l, int r) {
        if (l <= sl && sr <= r) {// total verlap
            return segment[sI];
        }
        if (sr < l || r < sl) {// No overlap
            return 0;
        }
        // partial overlap
        int mid = sl + (sr - sl) / 2;
        int leftSide = getSumInRange(segment, 2 * sI + 1, sl, mid, l, r);
        int rightSide = getSumInRange(segment, 2 * sI + 2, mid + 1, sr, l, r);
        return leftSide + rightSide;
    }

    public static void NumArray(int[] nums) {
        n = nums.length;
        int height = (int) (Math.ceil(Math.log10(n) / Math.log10(2))) + 1;
        size = (1 << height) - 1;
        segmentTree = new int[size];
        int sum = createSegmet(segmentTree, nums, 0, 0, n - 1);
    }

    public static void update(int index, int val) {
        int sum = updateSegment(segmentTree, 0, 0, n - 1, index, val);
    }

    public static int sumRange(int left, int right) {
        return getSumInRange(segmentTree, 0, 0, n - 1, left, right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        NumArray(nums);
        System.out.println(sumRange(0, n - 1));
        update(0, 10);
        System.out.println(sumRange(0, n - 1));
    }
}
