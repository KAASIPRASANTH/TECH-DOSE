import java.util.Scanner;

public class complement {
    public static int complementOf1(int num) {
        return (~num);
    }

    public static int complementOf2(int num) {
        return ((~num) + 1);
    }

    public static int complementUpToMSB(int num) {
        int val = 0, pos = 0;
        while (num != 0) {
            if ((num & 1) == 0) {
                val = val | (1 << pos);
            }
            num = num >> 1;
            pos++;
        }
        return val;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        System.out.println(complementOf1(n));
        System.err.println(complementOf2(n));
        System.out.println(complementUpToMSB(n));
    }
}
