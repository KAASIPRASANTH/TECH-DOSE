import java.util.*;

public class MinimumWindowSubstring76 {
    public static String minWindow(String s, String t) {
        int len1 = s.length(), len2 = t.length();
        int[] hash = new int[128];
        for (int i = 0; i < len2; i++) {
            hash[t.charAt(i)]++;
        }
        int count = len2, Max = Integer.MAX_VALUE, start = 0;
        for (int left = 0, right = 0; right < len1; right++) {
            char chRight = s.charAt(right);
            hash[chRight]--;
            if (hash[chRight] >= 0) {
                count--;
            }
            while (count == 0) {
                char chLeft = s.charAt(left);
                hash[chLeft]++;
                if (hash[chLeft] > 0) {
                    count++;
                    if ((right - left) + 1 < Max) {
                        start = left;
                        Max = (right - left) + 1;
                    }
                }
                left++;
            }
        }
        return Max == Integer.MAX_VALUE ? "" : s.substring(start, start + Max);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        sc.close();
        System.out.println(minWindow(s, t));
    }
}
