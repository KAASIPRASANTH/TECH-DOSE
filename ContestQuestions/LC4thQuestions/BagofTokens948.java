import java.util.*;

public class BagofTokens948 {
    public static int bagOfTokensScore(int[] tokens, int power) {
        int score = 0, left = 0, right = tokens.length - 1, tempScore = 0;
        Arrays.sort(tokens);
        while (left <= right) {
            if (tokens[left] <= power) {
                power -= tokens[left++];
                tempScore++;
                score = Math.max(score, tempScore);
            } else if (tempScore > 0) {
                power += tokens[right--];
                tempScore--;
            } else {
                break;
            }
        }
        return score;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] tokens = new int[n];
        for (int i = 0; i < n; i++) {
            tokens[i] = sc.nextInt();
        }
        int power = sc.nextInt();
        sc.close();
        System.out.println(bagOfTokensScore(tokens, power));
    }
}