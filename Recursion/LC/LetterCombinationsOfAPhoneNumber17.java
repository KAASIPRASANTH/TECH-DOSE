import java.util.*;

public class LetterCombinationsOfAPhoneNumber17 {
    static String[] numbers = { "", "@", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    static List<String> res;
    static String d = "";

    public static void solve(int index, String temp) {
        if (index == d.length()) {
            res.add(temp);
            return;
        }
        char ch = d.charAt(index);
        int pos = (int) (d.charAt(index) - '0');

        solve(index + 1, temp + "" + numbers[pos].charAt(0) + "");
        solve(index + 1, temp + "" + numbers[pos].charAt(1) + "");
        solve(index + 1, temp + "" + numbers[pos].charAt(2) + "");

        if (ch == '7' || ch == '9') {
            solve(index + 1, temp + "" + numbers[pos].charAt(3) + "");
        }
    }

    public static List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        if (digits.length() == 0) {
            return res;
        }
        d = digits;
        solve(0, "");
        return res;
    }

    public static void main(String[] args) {
        String digits = "237";
        System.out.println(letterCombinations(digits));
    }
}
