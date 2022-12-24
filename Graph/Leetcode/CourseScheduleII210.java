import java.util.*;

public class CourseScheduleII210 {
    public static int[] topo(List<List<Integer>> al, int[] inDeg, int n) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDeg[i] == 0) {
                q.add(i);
            }
        }
        int[] res = new int[n];
        int index = 0;
        while (!q.isEmpty()) {
            int poll = q.poll();
            for (int i = 0; i < al.get(poll).size(); i++) {
                int adj = al.get(poll).get(i);
                if (--inDeg[adj] == 0) {
                    q.add(adj);
                }
            }
            res[index++] = poll;
        }
        return (index == n) ? res : new int[0];
    }

    public int[] findOrder(int n, int[][] prerequisites) {
        List<List<Integer>> al = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            al.add(new ArrayList<>());
        }
        int[] inDeg = new int[n];
        for (int i = 0; i < prerequisites.length; i++) {
            for (int j = 0; j < prerequisites[i].length; j++) {
                al.get(prerequisites[i][1]).add(prerequisites[i][0]);
                inDeg[prerequisites[i][0]]++;
            }
        }
        return topo(al, inDeg, n);
    }
}