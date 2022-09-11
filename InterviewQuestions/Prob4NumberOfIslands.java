import java.util.*;
public class Prob4NumberOfIslands {
    public static int dfs(char[][] grid,int i,int j,int r,int c){
        if(i<0 || j<0 || i>=r || j>=c || grid[i][j]=='0') return 0;
        grid[i][j]='0';
        return dfs(grid,i,j-1,r,c)+dfs(grid,i-1,j,r,c)+dfs(grid,i,j+1,r,c)+dfs(grid,i+1,j,r,c)+1;
    }
    public static int numIslands(char[][] grid) {
        int r=grid.length,c=grid[0].length,cnt=0,max=-1;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]=='1'){
                    cnt++;
                    int currVal = dfs(grid, i, j, r, c);
                    if(max<currVal){
                        max = currVal;
                    }        
                }
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        char[][] grid = new char[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                grid[i][j] = sc.next().charAt(0);
            }
        }
        sc.close();
        System.out.println(numIslands(grid));
    }
}

