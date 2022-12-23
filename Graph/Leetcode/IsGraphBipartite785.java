import java.util.*;

class IsGraphBipartite785 {
    public static boolean isBipartite(List<List<Integer>> al, int[] colors, int curr) {
        Queue<Integer> q = new LinkedList<>();
        colors[curr] = 0;
        q.add(curr);
        while (!q.isEmpty()) {
            int poll = q.poll();
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

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> al = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            al.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                al.get(i).add(graph[i][j]);
                al.get(graph[i][j]).add(i);
            }
        }
        int[] colors = new int[n];
        Arrays.fill(colors, -1);
        for (int i = 0; i < n; i++) {
            if (colors[i] == -1 && !isBipartite(al, colors, i)) {
                return false;
            }
        }
        return true;
    }
}