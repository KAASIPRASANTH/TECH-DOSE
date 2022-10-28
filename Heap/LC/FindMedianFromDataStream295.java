import java.util.*;
public class FindMedianFromDataStream295 {
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;
    public FindMedianFromDataStream295() {
        left = new PriorityQueue<>((v1,v2)->{
            return v2-v1;
        });
        right = new PriorityQueue<>((v1,v2)->{
            return v1-v2;
        });
    }
    
    public void addNum(int num) {
        if(left.size()==0){
            left.add(num);
        }else if(left.size() == right.size()){
            if(right.peek()<num){
                left.add(right.poll());
                right.add(num);
            }else{
                 left.add(num);
            }
        }else{
            if(left.peek()<num){
                right.add(num);
            }else{
                right.add(left.poll());
                left.add(num);
            }
        }
    }
    
    public double findMedian() {
        return (left.size() == right.size())?(left.peek()+right.peek())/2.0 : left.peek()/1.0;
    }
    public static void main(String[] args) {
        /*
        Input:
        ["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
        [[], [1], [2], [], [3], []]
        Output:
        [null, null, null, 1.5, null, 2.0]
         */
    }
}
