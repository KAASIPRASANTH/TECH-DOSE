import java.util.*;

public class BasicCalculatorII227 {
    public static int calculate(String s) {
        s = s.replace(" ", "");
        Stack<Integer> stk = new Stack<>();
        char operator = '+';
        int result = 0, currNum = 0, len = s.length();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                currNum = currNum * 10 + (int) (ch - '0');
            }
            if (!Character.isDigit(ch) || i == len - 1) {
                if (operator == '+') {
                    stk.push(currNum);
                } else if (operator == '-') {
                    stk.push(-1 * currNum);
                } else if (operator == '*') {
                    stk.push(stk.pop() * currNum);
                } else if (operator == '/') {
                    stk.push(stk.pop() / currNum);
                }
                currNum = 0;
                operator = ch;
            }
        }
        while (!stk.isEmpty()) {
            result += stk.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String exp = sc.next();
        sc.close();
        System.out.println(calculate(exp));
    }
}
