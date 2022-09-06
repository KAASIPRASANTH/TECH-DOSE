import java.util.Scanner;

public class isSetBit {
    public static boolean isSet(int num, int pos) {
        return (num & (1 << pos - 1)) != 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int pos = sc.nextInt();
        sc.close();
        System.out.println(isSet(num, pos));
    }
}
