import java.util.*;

public class DijikstraAlgoritm {
    public static int findMinWeightVertex(int[] distance, boolean[] visited, int n) {
        int vertex = -1, weight = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (visited[i] == false && distance[i] < weight) {
                weight = distance[i];
                vertex = i;
            }
        }
        return vertex;
    }

    public static void shortestPath(int[][] cost, int n) {
        boolean[] visited = new boolean[n];
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        int[] Parent = new int[n];
        Arrays.fill(Parent, -1);
        distance[0] = 0;

        for (int i = 0; i < n; i++) {
            int vertex = findMinWeightVertex(distance, visited, n);
            if (vertex != -1) {
                visited[vertex] = true;
                for (int j = 0; j < n; j++) {
                    if (!visited[j] && cost[vertex][j] != 0 && distance[vertex] + cost[vertex][j] < distance[j]) {
                        Parent[j] = vertex;
                        distance[j] = distance[vertex] + cost[vertex][j];
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(i + " " + Parent[i] + " " + distance[i]);
        }
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] cost = {
                { 0, 1, 4, 0, 0, 0 },
                { 1, 0, 4, 2, 7, 0 },
                { 4, 4, 0, 3, 5, 0 },
                { 0, 2, 3, 0, 4, 6 },
                { 0, 7, 5, 4, 0, 7 },
                { 0, 0, 0, 6, 7, 0 }
        };
        shortestPath(cost, n);
    }
}