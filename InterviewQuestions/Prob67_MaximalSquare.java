import java.util.Scanner;
public class Prob67_MaximalSquare {
    public static int maximalSquare(char[][] matrix) {
        int m=matrix.length,n=matrix[0].length,largest=0;
        int[][] dp=new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(matrix[i-1][j-1] == '1'){
                    dp[i][j] = 1+Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
                    if(dp[i][j]>largest){
                        largest = dp[i][j];
                    }
                }
            }
        }
        return (largest*largest);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        char[][] matrix = new char[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                matrix[i][j] = sc.next().charAt(0);
            }
        }
        sc.close();
        System.out.println(maximalSquare(matrix));
    }
}