class Solution {
    public int minimumEffortPath(int[][] heights) {
        int r = heights.length;
        int c = heights[0].length;
        int[][] effort = new int[r][c];
        for(int i=0;i<r;i++){
            Arrays.fill(effort[i],Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            return a[2] - b[2];
        });
        pq.add(new int[]{0,0,0});
        effort[0][0] = 0;
        int[][] dir = {{0,-1},{0,1},{1,0},{-1,0}};
        while(pq.size()>0){
            int[] poll = pq.poll();
            int row = poll[0];
            int col = poll[1];
            int cost = poll[2];
            for(int[] d:dir){
                int x = row+d[0];
                int y = col+d[1];
                
                if(x<0||y<0||x>=r||y>=c) continue;
                int maxCost = Math.max(cost,Math.abs(heights[row][col]-heights[x][y]));
                if(maxCost<effort[x][y]){
                    effort[x][y] = maxCost;
                    pq.add(new int[]{x,y,effort[x][y]});
                }
            }
        }
        return effort[r-1][c-1];
    }
}
