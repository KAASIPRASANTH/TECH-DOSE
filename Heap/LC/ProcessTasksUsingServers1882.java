import java.util.*;
public class ProcessTasksUsingServers1882 {
    public static int[] assignTasks(int[] servers, int[] tasks) {
        int len = servers.length;
        PriorityQueue<int[]> available = new PriorityQueue<>((a,b)->{
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        for(int i=0;i<len;i++){
            available.add(new int[]{servers[i],i});
        }
        int[] res = new int[tasks.length];
        PriorityQueue<int[]> working = new PriorityQueue<>((a,b)->{
            //0->weight of server
            //1->index of server
            //2->finish time
            if(a[2] == b[2]){
                if(a[0] == b[0]){
                   return a[1] - b[1];
                }
                return a[0] - b[0];
            }
            return a[2] - b[2];
        });
     
        for(int i=0;i<tasks.length;i++){
            int task = tasks[i];
            while(working.size()>0 && working.peek()[2]<=i){
                int[] nowAvailable = working.poll();
                available.add(new int[]{nowAvailable[0],nowAvailable[1]});
            }
            if(available.size()>0){
                 int[] NowGoingToWork = available.poll();
                 res[i] = NowGoingToWork[1];
                 working.add(new int[]{NowGoingToWork[0],NowGoingToWork[1],i+task});
            }else{
                int[] InFutureGoingToWork = working.poll();
                res[i] = InFutureGoingToWork[1];
                working.add(new int[]{InFutureGoingToWork[0],InFutureGoingToWork[1],InFutureGoingToWork[2]+task});
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] servers = {3,3,2};
        int[] tasks = {1,2,3,2,1,2};
        int[] res = assignTasks(servers, tasks);
        for(int val:res){
            System.out.print(val+" ");
        }
    }  
}
    
