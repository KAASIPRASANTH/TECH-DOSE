import java.util.*;

public class Prob63_LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String min = strs[0];
        String max = strs[strs.length - 1];
        int i = 0;
        for (; i < min.length(); i++) {
            if (min.charAt(i) != max.charAt(i)) {
                break;
            }
        }
        return min.substring(0, i);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = sc.next();
        }
        sc.close();
        System.out.println(longestCommonPrefix(strs) + "");
    }
}
