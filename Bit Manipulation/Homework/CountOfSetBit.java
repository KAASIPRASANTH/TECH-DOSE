import java.util.*;

public class CountOfSetBit {
    public static int countSetBit1(int num) {
        int count = 0;
        while (num != 0) {
            count++;
            num = num & (num - 1);
        }
        return count;
    }

    public static int countSetBit2(int num) {
        int count = 0, val = 1;
        while (val <= num) {
            if ((num & val) > 0) {
                count++;
            }
            val = val << 1;
        }
        return count;
    }

    public static int countSetBit3(int num) {
        int count = 0;
        while (num > 0) {
            count += (num & 1);
            num = num >> 1;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.close();
        System.out.println(countSetBit1(num));
        System.out.println(countSetBit2(num));
        System.out.println(countSetBit3(num));
    }
}