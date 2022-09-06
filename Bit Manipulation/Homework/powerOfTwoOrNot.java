import java.util.*;

class powerOfTwoOrNot {
    public static boolean isPowerOfTwo1(int num) {
        double val = Math.log10(num) / Math.log10(2);
        if (val - (int) val == 0)
            return true;
        return false;
    }

    public static boolean isPowerOfTwo2(int num) {
        if ((num & (num - 1)) == 0)
            return true;
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.close();
        System.out.println(isPowerOfTwo1(num));
        System.out.println(isPowerOfTwo2(num));
    }
}