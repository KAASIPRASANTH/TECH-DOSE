import java.util.*;

public class StronglyConnectedComponent {
    static int[] disc, low;
    static int time;

    public static void DFS(List<List<Integer>> al, boolean[] visited, Stack<Integer> stk, int u) {
        disc[u] = low[u] = time++;
        visited[u] = true;
        stk.push(u);
        for (int i = 0; i < al.get(u).size(); i++) {
            int v = al.get(u).get(i);
            if (disc[v] == -1) {
                DFS(al, visited, stk, v);
                low[u] = Math.min(low[u], low[v]);
            } else if (visited[v]) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
        if (disc[u] == low[u]) {
            List<Integer> res = new ArrayList<>();
            while (stk.peek() != u) {
                visited[stk.peek()] = false;
                res.add(stk.pop());
            }
            visited[stk.peek()] = false;
            res.add(stk.pop());
            System.out.println(" SCC " + res);
        }
        visited[u] = false;
    }

    public static void SCC(List<List<Integer>> al, int n) {
        disc = new int[n + 1];
        low = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        Stack<Integer> stk = new Stack<>();
        Arrays.fill(disc, -1);
        Arrays.fill(low, -1);
        time = 0;
        for (int i = 0; i <= n; i++) {
            if (disc[i] == -1) {
                DFS(al, visited, stk, i);
            }
        }
    }

    public static void main(String[] args) {
        int n = 6;
        List<List<Integer>> al = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            al.add(new ArrayList<>());
        }
        al.get(0).add(1);

        al.get(1).add(2);
        al.get(1).add(3);

        al.get(3).add(4);

        al.get(4).add(0);
        al.get(4).add(5);
        al.get(4).add(6);

        al.get(5).add(2);
        al.get(5).add(6);

        al.get(6).add(5);

        SCC(al, n);
    }
}
