import java.util.*;
public class ImplementStackUsingQueues225 {
    static Deque<Integer> dq;
    public static void MyStack() {
        dq = new ArrayDeque<>();
    }
    
    public void push(int x) {
        dq.addLast(x);
    }
    
    public int pop() {
        return dq.removeLast();
    }
    
    public static int top() {
        return dq.getLast();
    }
    
    public static boolean empty() {
        return dq.isEmpty();
    }
    public static void main(String[] args) {
        /*
        Input:
        ["MyStack", "push", "push", "top", "pop", "empty"]
        [[], [1], [2], [], [], []]

        OutPut:
        [null, null, null, 2, 2, false]
        */
    }
}
