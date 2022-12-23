import java.util.*;

public class PossibleBipartition886 {
    public static boolean isBipartite(List<List<Integer>> al, int[] colors, int curr) {
        Queue<Integer> q = new LinkedList<>();
        q.add(curr);
        colors[curr] = 0;
        while (!q.isEmpty()) {
            int poll = q.remove();
            for (int i = 0; i < al.get(poll).size(); i++) {
                int adj = al.get(poll).get(i);
                if (colors[adj] == colors[poll]) {
                    return false;
                }
                if (colors[adj] == -1) {
                    colors[adj] = 1 - colors[poll];
                    q.add(adj);
                }
            }
        }
        return true;
    }

    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> al = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            al.add(new ArrayList<>());
        }
        for (int[] con : dislikes) {
            al.get(con[0]).add(con[1]);
            al.get(con[1]).add(con[0]);
        }
        int[] colors = new int[n + 1];
        Arrays.fill(colors, -1);
        for (int i = 1; i <= n; i++) {
            if (colors[i] == -1) {
                if (!isBipartite(al, colors, i)) {
                    return false;
                }
            }
        }
        return true;
    }
}
