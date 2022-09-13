import java.util.*;

public class Prob10_LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        int[] set = new int[128];
        int n = s.length();
        int ans = 0;
        while (right < n) {
            if (left < right && set[s.charAt(right)] == 1) {
                set[s.charAt(left)] = 0;
                left++;
            } else {
                set[s.charAt(right)] = 1;
                right++;
                ans = Math.max(ans, right - left);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        sc.close();
        System.out.println(lengthOfLongestSubstring(str));
    }
}
