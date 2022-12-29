import java.util.*;

public class Bridges {
    static int[] disc, low, parent;
    static int time;
    static List<int[]> res;

    public static void DFS(List<List<Integer>> al, int u) {
        disc[u] = low[u] = time++;
        for (int i = 0; i < al.get(u).size(); i++) {
            int v = al.get(u).get(i);
            if (disc[v] == -1) {
                parent[v] = u;
                DFS(al, v);
                low[u] = Math.min(low[u], low[v]);
                if (low[v] > disc[u]) {
                    res.add(new int[] { u, v });
                }
            } else if (parent[u] != v) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }

    public static void findBridge(List<List<Integer>> al, int n) {
        time = 0;
        disc = new int[n + 1];
        low = new int[n + 1];
        parent = new int[n + 1];
        Arrays.fill(disc, -1);
        Arrays.fill(low, -1);
        Arrays.fill(parent, -1);
        res = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            if (disc[i] == -1) {
                DFS(al, i);
            }
        }
        for (int[] bridge : res) {
            System.out.println(bridge[0] + " " + bridge[1]);
        }
    }

    public static void main(String[] args) {
        int n = 4;
        List<List<Integer>> al = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            al.add(new ArrayList<>());
        }
        al.get(0).add(1);
        al.get(0).add(2);
        al.get(0).add(3);

        al.get(1).add(0);
        al.get(1).add(2);

        al.get(2).add(0);
        al.get(2).add(1);

        al.get(3).add(0);
        al.get(3).add(4);

        al.get(4).add(3);

        findBridge(al, n);
    }
}
