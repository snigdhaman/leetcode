package linkedlist;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

    class Node {
        public int key;
        public int val;
        public Node next;
        public Node prev;

        public Node (int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    int capacity;
    Node head;
    Node tail;
    Map<Integer, Node> map;
    public LRUCache (int capacity) {
        this.capacity = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }

    public int get (int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
//        node.next.prev = node.prev;
//        node.prev.next = node.next;
//        head.next = node;
//        node.prev = head;
        remove(node);
        add(node);
        return node.val;
    }

    public void put (int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        if (map.size() >= capacity) {
            remove(tail.prev);
        }
        add(new Node(key, value));
    }

    void add (Node node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
        map.put(node.key, node);
    }

    void remove (Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
        map.remove(node.key);
    }

    void print () {
        Node n = head;
        while (n != null) {
            System.out.print(n.val + " ");
            n = n.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LRUCache lru = new LRUCache(2);
        lru.put(1,1);
        System.out.println("==============");
        lru.print();
        lru.put(2,2);
        System.out.println("==============");
        lru.print();
        lru.get(1);
        System.out.println("==============");
        lru.print();
        lru.put(3,3);
        System.out.println("==============");
        lru.print();
        lru.get(2);
        System.out.println("==============");
        lru.print();
        lru.put(4,4);
        System.out.println("==============");
        lru.print();
        lru.get(1);
        System.out.println("==============");
        lru.print();
        lru.get(3);
        System.out.println("==============");
        lru.print();
        lru.get(4);
        System.out.println("==============");
        lru.print();
    }
}