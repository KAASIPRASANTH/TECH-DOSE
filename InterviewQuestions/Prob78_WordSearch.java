import java.util.*;
public class Prob78_WordSearch {
    public static boolean isPresent(char[][] board,String word,int index,int i,int j,int row,int col,int len,boolean[][] visited){
        if(i<0||j<0||i>=row||j>=col||index>len||(visited[i][j]==true)){
            return false;
        }
        if(index<len && word.charAt(index) != board[i][j]){
            return false;
        }
        visited[i][j] = true;
        if(index+1 == len){
            return true;
        }
        boolean l = isPresent(board,word,index+1,i,j-1,row,col,len,visited);
        boolean r = isPresent(board,word,index+1,i,j+1,row,col,len,visited);
        boolean t = isPresent(board,word,index+1,i-1,j,row,col,len,visited);
        boolean d = isPresent(board,word,index+1,i+1,j,row,col,len,visited);
        visited[i][j] = false;
        return (l||r||t||d);
    }
    public static boolean exist(char[][] ch, String s) {
        int len = s.length(),row=ch.length,col=ch[0].length;
		for(int i=0;i<row;i++){
		    for(int j=0;j<col;j++){
		        if(ch[i][j] == s.charAt(0) && isPresent(ch,s,0,i,j,row,col,len,new boolean[row][col])){
		            return true;
		        }
		    }
		}
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        char[][] board = new char[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                board[i][j] = sc.next().charAt(0);
            }
        }
        String word = sc.next();
        sc.close();
        System.out.println(exist(board,word));
    }
}
