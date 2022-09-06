import java.util.*;

public class oddOrEven {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.close();
        if ((num & 1) == 1) {
            System.out.println("ODD");
        } else {
            System.out.println("EVEN");
        }
    }
}
