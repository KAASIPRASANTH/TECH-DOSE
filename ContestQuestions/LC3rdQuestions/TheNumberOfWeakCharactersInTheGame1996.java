import  java.util.*;
public interface TheNumberOfWeakCharactersInTheGame1996 {
    public static int numberOfWeakCharacters(int[][] p) {
        Arrays.sort(p,(a,b)->{
            if(a[0] == b[0]){
                return  a[1] - b[1];
            }
            return  b[0] - a[0];
        });
        int weakCharacter = 0,max = -1;
        for(int[] a:p){
            if(a[1]<max){
                weakCharacter++;
            }else{
                max = a[1];
            }
        }
        return  weakCharacter;
    }
    public static void main(String[] args) {
        int[][] properties = {
                {5,5},
                {3,6},
                {6,3}
        };
        System.out.println(numberOfWeakCharacters(properties));
    }
}
