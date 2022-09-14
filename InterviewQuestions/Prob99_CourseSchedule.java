import java.util.*;

public class Prob99_CourseSchedule {
    public static boolean dfs(List<List<Integer>> al, int[] visited, int curr) {
        if (visited[curr] == 2) {
            return true;
        }
        visited[curr] = 2;
        for (int i = 0; i < al.get(curr).size(); i++) {
            if (visited[al.get(curr).get(i)] != 1) {
                if (dfs(al, visited, al.get(curr).get(i))) {
                    return true;
                }
            }
        }
        visited[curr] = 1;
        return false;
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> al = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            al.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            al.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] != 1) {
                if (dfs(al, visited, i)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numCourses = sc.nextInt();
        sc.close();
        System.out.println(canFinish(numCourses, new int[][] { { 1, 0 } }));
    }
}
