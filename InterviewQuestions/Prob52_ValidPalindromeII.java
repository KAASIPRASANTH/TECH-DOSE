import java.util.Scanner;

public class Prob52_ValidPalindromeII {
    public static boolean isPlaindrom(String s, int left, int right) {
        while (left <= right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean validPalindrome(String s) {
        int len = s.length();
        int left = 0, right = len - 1;
        while (left <= right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return isPlaindrom(s, left + 1, right) || isPlaindrom(s, left, right - 1);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        sc.close();
        System.out.println(validPalindrome(s));
    }
}
