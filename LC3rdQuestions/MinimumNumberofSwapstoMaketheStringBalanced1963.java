import java.util.*;

public class MinimumNumberofSwapstoMaketheStringBalanced1963 {
    public static int minSwaps(String s) {
        int open = 0, close = 0, unBalanced = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[')
                open++;
            else {
                if (open > close)
                    close++;
                else
                    unBalanced++;
            }
        }
        return (unBalanced + 1) / 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        sc.close();
        System.err.println(minSwaps(s));
    }
}
