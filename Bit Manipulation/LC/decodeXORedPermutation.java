import java.util.*;

public class decodeXORedPermutation {
    public static int[] decode(int[] encoded) {
        int n = encoded.length + 1, tot_xor = 0;
        for (int i = 1; i <= n; i++) {
            tot_xor ^= i;
        }
        int x = 0;
        for (int i = 1; i < n - 1; i += 2) {
            x ^= encoded[i];
        }
        int[] perm = new int[n];
        // (a0^a1^a2^a3) ^ (a1^a2^a2) = a0
        perm[0] = tot_xor ^ x;
        for (int i = 1; i < n; i++) {
            perm[i] = perm[i - 1] ^ encoded[i - 1];
        }
        return perm;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int encodedSize = sc.nextInt();
        int[] encoded = new int[encodedSize];
        for (int i = 0; i < encodedSize; i++) {
            encoded[i] = sc.nextInt();
        }
        sc.close();
        int[] perm = new int[encodedSize];
        perm = decode(encoded);
        for (int i = 0; i < encodedSize + 1; i++) {
            System.out.println(perm[i] + " ");
        }
    }
}
