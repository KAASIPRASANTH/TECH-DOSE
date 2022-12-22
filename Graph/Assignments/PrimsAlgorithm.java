import java.util.*;

public class PrimsAlgorithm {
    public static void prims(List<List<int[]>> al, int n) {
        int[] distance = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        int[] Parent = new int[n + 1];
        Arrays.fill(Parent, -1);
        Arrays.fill(distance, Integer.MAX_VALUE);
        int vertex = 0;
        distance[vertex] = 0;
        while (vertex != -1) {
            visited[vertex] = true;
            for (int[] con : al.get(vertex)) {
                if (visited[con[0]] == false && distance[con[0]] > con[1]) {
                    distance[con[0]] = con[1];
                    Parent[con[0]] = vertex;
                }
            }
            int weight = Integer.MAX_VALUE, minVertex = -1;
            for (int i = 0; i <= n; i++) {
                if (visited[i] == false && distance[i] < weight) {
                    weight = distance[i];
                    minVertex = i;
                }
            }
            vertex = minVertex;
        }
        for (int i = 0; i <= n; i++) {
            System.out.println(i + " " + Parent[i] + " " + distance[i]);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        List<List<int[]>> al = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            al.add(new ArrayList<>());
        }
        al.get(0).add(new int[] { 1, 3 });
        al.get(0).add(new int[] { 2, 1 });

        al.get(1).add(new int[] { 0, 3 });
        al.get(1).add(new int[] { 2, 2 });
        al.get(1).add(new int[] { 3, 4 });

        al.get(2).add(new int[] { 0, 1 });
        al.get(2).add(new int[] { 1, 2 });
        al.get(2).add(new int[] { 3, 5 });

        al.get(3).add(new int[] { 1, 4 });
        al.get(3).add(new int[] { 2, 5 });

        prims(al, n);
    }
}
