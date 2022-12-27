class Solution {
    public static int BFS(char[][] grid,int startX,int startY){
        int[][] direction = {{0,1},{0,-1},{1,0},{-1,0}};
        int r = grid.length;
        int c = grid[0].length;
        boolean[][] path = new boolean[r][c];
        int count=0;
        Queue<int[]> q = new LinkedList<>();
        path[startX][startY]=true;
        q.add(new int[]{startX,startY});
        while(!q.isEmpty()){
            count++;
            int size = q.size();
            for(int i=0;i<size;i++){
                int[] con = q.poll();
                for(int[] d:direction){
                    int x = con[0]+d[0];
                    int y = con[1]+d[1];
                    if(x<0||y<0||x>=r||y>=c||grid[x][y]=='X') continue;
                    if(grid[x][y]=='#') return count;
                    if(!path[x][y]){
                        q.add(new int[]{x,y});
                        path[x][y] = true;
                    }
                }
            }
        }
        return -1;
    }
    public int getFood(char[][] grid) {
        int startX=-1,startY=-1;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == '*'){
                    startX=i;
                    startY=j;
                    break;
                }
            }
        }
        return BFS(grid,startX,startY);
    }
}
