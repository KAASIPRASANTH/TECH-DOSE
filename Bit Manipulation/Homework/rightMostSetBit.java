import java.util.Scanner;

public class rightMostSetBit {
    public static int rightMostSet(int num) {
        return (num & ((~num) + 1));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.close();
        System.out.println(rightMostSet(num));
    }
}
