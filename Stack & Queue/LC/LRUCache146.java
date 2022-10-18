import java.util.*;

public class LRUCache146 {
    class Node {
        int key;
        int val;
        Node prev, next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    Map<Integer, Node> map = new LinkedHashMap<>();
    int capacity;

    public void remove(Node n) {
        n.prev.next = n.next;
        n.next.prev = n.prev;
    }

    public void moveToHead(Node n) {
        Node firstNode = head.next;
        head.next = n;
        n.prev = head;

        n.next = firstNode;
        firstNode.prev = n;
    }

    public void LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
        tail.next = head;
        head.prev = tail;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            moveToHead(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            remove(node);
            moveToHead(node);
        } else {
            if (map.size() == capacity) {
                map.remove(tail.prev.key);
                remove(tail.prev);
            }
            Node nn = new Node(key, value);
            map.put(key, nn);
            moveToHead(nn);
        }
    }

    public static void main(String[] args) {
        /*
         Input:
         ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
         [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]

         Output:
         [null, null, null, 1, null, -1, null, -1, 3, 4]
         */
    }
}
