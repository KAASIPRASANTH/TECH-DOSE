class Solution {
    public int maximumMinimumPath(int[][] grid) {
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        int r = grid.length;
        int c = grid[0].length;
        int minValMaxPath = grid[0][0];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
           return b[0] - a[0]; 
        });
        pq.add(new int[]{grid[0][0],0,0});
        while(pq.size()>0){
            int[] poll = pq.poll();
            int row = poll[1];
            int col = poll[2];
            minValMaxPath = Math.min(poll[0],minValMaxPath);
            if(row==r-1 && col==c-1){
                break;
            }
            for(int[] d:directions){
                int x = row+d[0];
                int y = col+d[1];
                if(x<0||y<0||x>=r||y>=c||grid[x][y]==-1) continue;
                pq.add(new int[]{grid[x][y],x,y});
                grid[x][y] = -1;
            }
        }
        return minValMaxPath;
    }
}
