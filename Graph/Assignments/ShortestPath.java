import java.util.*;

public class ShortestPath {
    public static int FindShortestPath(List<List<Integer>> al, int n, int source, int destination) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        q.add(source);
        visited[source] = true;
        int count = 0;
        while (!q.isEmpty()) {
            count++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int parent = q.poll();
                for (int j = 0; j < al.get(parent).size(); j++) {
                    int adj = al.get(parent).get(j);
                    if (adj == destination) {
                        return count;
                    }
                    if (visited[adj] == false) {
                        q.add(adj);
                        visited[adj] = true;
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int n = 6;
        List<List<Integer>> al = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            al.add(new ArrayList<>());
        }
        // vertex 1
        al.get(1).add(2);
        al.get(1).add(4);
        // vertex 2
        al.get(2).add(1);
        al.get(2).add(3);
        al.get(2).add(4);
        al.get(2).add(5);
        al.get(2).add(6);

        // vertex 3
        al.get(3).add(2);
        al.get(3).add(4);
        al.get(3).add(6);

        // vertex 4
        al.get(4).add(1);
        al.get(4).add(2);
        al.get(4).add(3);

        // vertex 5
        al.get(5).add(6);
        al.get(5).add(2);

        // vertex 6
        al.get(6).add(2);
        al.get(6).add(3);
        al.get(6).add(5);

        System.out.println(FindShortestPath(al, n, 1, 6));
    }
}
