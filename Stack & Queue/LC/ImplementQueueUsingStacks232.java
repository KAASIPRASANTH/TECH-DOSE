import java.util.*;
public class ImplementQueueUsingStacks232 {
    static Stack<Integer> q1;
    static Stack<Integer> q2;
    public void MyQueue() {
        q1 = new Stack<>();
        q2 = new Stack<>();
    }
    
    public void push(int x) {
        while(!q1.isEmpty()){
            q2.push(q1.pop());
        }
        q1.push(x);
        while(!q2.isEmpty()){
            q1.push(q2.pop());
        }
    }
    
    public int pop() {
       return q1.pop();
    }
    
    public int peek() {
       return q1.peek();
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
    public static void main(String[] args) {
        /*
         Input:
         ["MyQueue", "push", "push", "peek", "pop", "empty"]
         [[], [1], [2], [], [], []]

         Output:
         [null, null, null, 1, 1, false]
         */
    }
}
