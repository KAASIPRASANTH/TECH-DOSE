import java.util.*;

public class Prob73_CourseScheduleII {
    public static int[] topo(List<List<Integer>> al, int[] indegree, int n) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        int[] a = new int[n];
        int index = n - 1;
        while (!q.isEmpty()) {
            int curr = q.remove();
            for (int i = 0; i < al.get(curr).size(); i++) {
                indegree[al.get(curr).get(i)]--;
                if (indegree[al.get(curr).get(i)] == 0) {
                    q.add(al.get(curr).get(i));
                }
            }
            a[index--] = curr;
        }
        return (index == -1) ? a : new int[0];
    }

    public static int[] findOrder(int n, int[][] pre) {
        if (n == 1)
            return new int[1];
        List<List<Integer>> al = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            al.add(new ArrayList<>());
        }
        for (int i = 0; i < pre.length; i++) {
            al.get(pre[i][0]).add(pre[i][1]);
        }
        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < al.get(i).size(); j++) {
                indegree[al.get(i).get(j)]++;
            }
        }
        int[] res = topo(al, indegree, n);
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numCourses = sc.nextInt();
        sc.close();
        int[] res = findOrder(numCourses, new int[][] { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } });
        for (int course : res) {
            System.out.println(course);
        }
    }
}