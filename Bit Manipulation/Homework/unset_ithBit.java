import java.util.Scanner;

public class unset_ithBit {
    public static int unSet(int num, int pos) {
        return (num & (~(1 << (pos - 1))));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int pos = sc.nextInt();
        sc.close();
        System.out.println(unSet(num, pos));
    }
}
