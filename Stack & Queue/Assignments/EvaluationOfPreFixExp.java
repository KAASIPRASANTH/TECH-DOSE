import java.util.*;;

public class EvaluationOfPreFixExp {
    public static int Evaluate(String[] exp) {
        Stack<Integer> stk = new Stack<>();
        List<String> operators = new ArrayList<>();
        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");
        operators.add("^");
        operators.add("%");
        for (int i = exp.length - 1; i >= 0; i--) {
            if (operators.contains(exp[i])) {
                int val1 = stk.pop();
                int val2 = stk.pop();
                switch (exp[i]) {
                    case "+":
                        stk.push(val1 + val2);
                        break;
                    case "-":
                        stk.push(val1 - val2);
                        break;
                    case "*":
                        stk.push(val1 * val2);
                        break;
                    case "/":
                        stk.push(val1 / val2);
                        break;
                    case "%":
                        stk.push(val1 % val2);
                        break;
                    default:
                        break;
                }
            } else {
                stk.push(Integer.parseInt(exp[i]));
            }
        }
        return stk.pop();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] exp = sc.nextLine().split(" ");
        System.out.println(Evaluate(exp));
        sc.close();
    }
}
