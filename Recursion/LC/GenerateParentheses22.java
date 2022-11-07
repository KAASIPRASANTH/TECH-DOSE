import java.util.*;

public class GenerateParentheses22 {
    static List<String> res;

    public static void solve(String s, int open, int close, int n) {
        if (s.length() == 2 * n) {
            res.add(s);
            return;
        }
        if (open < n) {
            solve(s + "(", open + 1, close, n);
        }
        if (close < open) {
            solve(s + ")", open, close + 1, n);
        }
    }

    public static List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        solve("", 0, 0, n);
        return res;
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(generateParenthesis(n));
    }
}
