import java.util.*;

public class flip_ithBit {
    public static int flip(int num, int pos) {
        return (num ^ (1 << (pos - 1)));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int pos = sc.nextInt();
        sc.close();
        System.out.println(flip(num, pos));
    }
}
