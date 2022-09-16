import java.util.Scanner;

public class Prob31_AddStrings {
    public static String addStrings(String num1, String num2) {
        int p1 = num1.length() - 1, p2 = num2.length() - 1, carry = 0;
        String sum = "";
        while (p1 >= 0 || p2 >= 0) {
            if (p1 >= 0) {
                carry += (num1.charAt(p1) - '0');
                p1--;
            }
            if (p2 >= 0) {
                carry += (num2.charAt(p2) - '0');
                p2--;
            }
            sum = carry % 10 + "" + sum;
            carry /= 10;
        }
        if (carry > 0) {
            sum = carry + "" + sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1 = sc.next();
        String num2 = sc.next();
        sc.close();
        System.out.println(addStrings(num1, num2));
    }
}
