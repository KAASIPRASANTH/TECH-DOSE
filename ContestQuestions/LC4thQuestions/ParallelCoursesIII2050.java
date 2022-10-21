import java.util.*;
public class ParallelCoursesIII2050 {
    public static int topo(List<List<Integer>> al,int[] indegree,int[] time,int n){

        Queue<Integer> q=new LinkedList<>();
        int[] completionTime = new int[n+1];
        for(int i=1;i<=n;i++){
            if(indegree[i] == 0){
                q.add(i);
                completionTime[i] = time[i-1];
            }
        }

        while(!q.isEmpty()){
            int prevCourse = q.remove();
            for(int i=0;i<al.get(prevCourse).size();i++){
                int nextCourse = al.get(prevCourse).get(i);
                completionTime[nextCourse]=Math.max(completionTime[nextCourse],completionTime[prevCourse]+time[nextCourse-1]);
                indegree[nextCourse]--;
                if(indegree[nextCourse] == 0){
                    q.add(nextCourse);
                }
            }
        }
        int totMonths=0;
        for(int i=1;i<=n;i++){
            if(totMonths<completionTime[i]){
                totMonths = completionTime[i];
            }
        }
        return totMonths;
    }
    public static int minimumTime(int n, int[][] relations, int[] time) {
        List<List<Integer>> al=new ArrayList<>();
        for(int i=0;i<=n;i++){
            al.add(new ArrayList<>());
        }
        for(int i=0;i<relations.length;i++){
            int prev = relations[i][0],next = relations[i][1];
            al.get(prev).add(next);
        }
        int[] indegree = new int[n+1];
        for(int i=1;i<=n;i++){
            for(int j=0;j<al.get(i).size();j++){
                indegree[al.get(i).get(j)]++;
            }
        }
        return topo(al,indegree,time,n);
    }
    public static void main(String[] args) {
        int n = 3;
        int[][] relation = {
                {1,3},
                {2,3}
        };
        int[] time = {3,2,5};
        System.out.println(minimumTime(n,relation,time));
    }
}
