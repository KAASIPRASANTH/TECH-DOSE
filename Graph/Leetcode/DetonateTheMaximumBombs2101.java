class Solution {
    public static boolean isDetonate(int[] bomb1,int[] bomb2){
        int x = Math.abs(bomb1[0] - bomb2[0]);
        int y = Math.abs(bomb1[1] - bomb2[1]);
        /*
           sqrt(x^2 + y^2) <= r
           x^2 + y^2 <= r^2
        */
        return (long) x*x + (long) y*y <=(long) bomb1[2]*bomb1[2];
    }
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length, res = 0;
        for(int i=0;i<n;i++){
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            boolean[] visited = new boolean[n];
            int count = 0;
            visited[i] = true;
            while(!q.isEmpty()){
                int bomb1 = q.poll();
                for(int j=0;j<n;j++){
                    if(visited[j] == false && isDetonate(bombs[bomb1],bombs[j])){
                        visited[j] = true;
                        q.add(j);
                        ++count;
                    }
                }
            }
            res = Math.max(res,count+1);
        }
        return res;
    }
}
