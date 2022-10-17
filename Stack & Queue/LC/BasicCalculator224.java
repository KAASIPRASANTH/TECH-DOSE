import java.util.*;

public class BasicCalculator224 {
    public static int calculate(String s) {
        Stack<Integer> stk = new Stack<>();
        int len = s.length(), result = 0, currNum = 0, sign = 1;
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (ch == '+') {
                result += (sign * currNum);
                currNum = 0;
                sign = 1;
            } else if (ch == '-') {
                result += (sign * currNum);
                currNum = 0;
                sign = -1;
            } else if (ch == '(') {
                stk.push(result);
                stk.push(sign);
                result = 0;
                sign = 1;
            } else if (ch == ')') {
                result += (sign * currNum);
                currNum = 0;
                sign = 1;
                result *= stk.pop();
                result += stk.pop();
            } else if (Character.isDigit(ch)) {
                currNum = currNum * 10 + (int) (ch - '0');
            }
        }
        if (currNum != 0)
            result += (sign * currNum);
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String exp = sc.next();
        sc.close();
        System.out.println(calculate(exp));
    }
}