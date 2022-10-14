

import java.util.*;

public class PossibleBipartite886 {
    public static boolean isBipartite(List<List<Integer>> al, int[] color, int curr) {
        Queue<Integer> q = new LinkedList<>();
        color[curr] = 1;
        q.add(curr);

        while (!q.isEmpty()) {
            int pop = q.remove();
            for (int i = 0; i < al.get(pop).size(); i++) {
                int adj = al.get(pop).get(i);
                if (color[pop] == color[adj]) {
                    return false;
                }
                if (color[adj] == -1) {
                    color[adj] = 1 - color[pop];
                    q.add(adj);
                }
            }
        }
        return true;
    }

    public static boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> al = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            al.add(new ArrayList<>());
        }
        for (int[] pair : dislikes) {
            al.get(pair[0]).add(pair[1]);
            al.get(pair[1]).add(pair[0]);
        }
        int[] color = new int[n + 1];
        Arrays.fill(color, -1);
        for (int i = 1; i <= n; i++) {
            if (color[i] == -1) {
                if (!isBipartite(al, color, i)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] dislikes = { { 1, 2 }, { 1, 3 }, { 2, 4 } };
        sc.close();
        System.out.println(possibleBipartition(n, dislikes));
    }
}