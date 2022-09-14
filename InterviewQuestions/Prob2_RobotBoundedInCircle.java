import java.util.*;
public class Prob2_RobotBoundedInCircle{
    public static boolean isRobotBounded(String instructions) {
        char direction = 'N';
        int x=0,y=0;
        for(int i=0;i<instructions.length();i++){
            char ch = instructions.charAt(i);
            if(ch == 'G'){
                if(direction == 'N') y++;
                else if(direction == 'S') y--;
                else if(direction == 'E') x++;
                else if(direction == 'W') x--;
            }else if(ch=='L'){
                if(direction == 'N') direction = 'W';
                else if(direction == 'S') direction = 'E';
                else if(direction == 'E') direction = 'N';
                else if(direction == 'W') direction = 'S';
            }else if(ch=='R'){
                if(direction == 'N') direction = 'E';
                else if(direction == 'S') direction = 'W';
                else if(direction == 'E') direction = 'S';
                else if(direction == 'W') direction = 'N';
            }
        }
        if(x==0 && y==0){
            return true;
        }
        if(direction == 'N'){
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String instructions = sc.next();
        sc.close();
        System.out.println(isRobotBounded(instructions));
    }
}