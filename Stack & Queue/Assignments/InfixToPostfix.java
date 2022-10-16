import java.util.*;

public class InfixToPostfix {
    public static String infixTopostfix(String exp) {
        Map<Character, Integer> precidence = new LinkedHashMap<>();
        precidence.put('+', 1);
        precidence.put('-', 1);
        precidence.put('*', 2);
        precidence.put('/', 2);
        precidence.put('%', 2);
        precidence.put('^', 3);

        Stack<Character> stk = new Stack<>();
        String postFix = "";
        int len = exp.length();
        for (int i = 0; i < len; i++) {
            char ch = exp.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                postFix += ch + "";
            } else if (ch == '(') {
                stk.push(ch);
            } else if (ch == ')') {
                while (!stk.isEmpty() && stk.peek() != '(') {
                    postFix += stk.pop() + "";
                }
                stk.pop();
            } else {
                while (!stk.isEmpty() && stk.peek() != '(' && precidence.get(stk.peek()) >= precidence.get(ch)) {
                    postFix += stk.pop() + "";
                }
                stk.push(ch);
            }
        }
        while (!stk.isEmpty()) {
            postFix += stk.pop() + "";
        }
        return postFix;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String exp = sc.next();
        sc.close();
        System.out.println(infixTopostfix(exp));
    }
}