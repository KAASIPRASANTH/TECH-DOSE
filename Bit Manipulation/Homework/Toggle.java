import java.util.*;

public class Toggle {
    public static char convertToLower(char ch) {
        int num = (1 << 5);
        // character + 32
        return (char) (ch | num);
    }

    public static char convertToUpper(char ch) {
        int num = (1 << 5);
        // character - 32
        return (char) (ch & (~num));
    }

    public static char toggle(char ch) {
        // 0 ^ 1 = 1 , 1 ^ 1 = 0
        return (char) (ch ^ (1 << 5));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char ch = sc.next().charAt(0);
        sc.close();
        System.out.println(convertToLower(ch));
        System.out.println(convertToUpper(ch));
        System.out.println(toggle(ch));
    }
}
