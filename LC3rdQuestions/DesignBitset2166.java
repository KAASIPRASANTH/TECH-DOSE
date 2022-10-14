import java.util.*;

public class DesignBitset2166 {
    static Set<Integer> ones = new HashSet<>();
    static Set<Integer> zeros = new HashSet<>();
    static int size;

    public static void Bitset(int s) {
        size = s;
        for (int i = 0; i < size; i++) {
            zeros.add(i);
        }
    }

    public static void fix(int idx) {
        ones.add(idx);
        zeros.remove(idx);
    }

    public static void unfix(int idx) {
        zeros.add(idx);
        ones.remove(idx);
    }

    public static void flip() {
        Set<Integer> temp = ones;
        ones = zeros;
        zeros = temp;
    }

    public static boolean all() {
        return ones.size() == size;
    }

    public static boolean one() {
        return ones.size() > 0;
    }

    public static int count() {
        return ones.size();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            if (ones.contains(i))
                sb.append("1");
            else
                sb.append("0");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*
         * Input
         * ["Bitset", "fix", "fix", "flip", "all", "unfix", "flip", "one", "unfix",
         * "count", "toString"]
         * [[5], [3], [1], [], [], [0], [], [], [0], [], []]
         */
        sc.close();
    }
}
