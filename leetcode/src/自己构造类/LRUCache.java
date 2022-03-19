package 自己构造类;

import java.util.HashMap;

/**
 * @author yubingtao
 * @date 2022/3/19
 */
public class LRUCache {

    //hashmap：保证get() O(1)
    private HashMap<Integer,Node> map;
    //要求前后顺序：list,又要保证put() O(1):链表
    private Node head;
    private Node tail;
    private int capacity;

    static class Node{
        public Node pre;
        public Node next;
        public int val;
        public int key;

        public Node(int key,int val) {
            this.key = key;
            this.val = val;
        }
    }

    public LRUCache(int capacity) {
        this.map = new HashMap<>(capacity);
        this.capacity = capacity;
        this.head = new Node(-1,-1);
        this.tail = new Node(-1,-1);
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        Node node = map.get(key);
        //移除node，挪到头上
        if (node != null) {
            removeNode(node);
            addNodeToHead(node);
            return node.val;
        }

        return -1;
    }

    private void addNodeToHead(Node node) {
        Node realHead = head.next;
        node.next = realHead;
        realHead.pre = node;
        node.pre = head;
        head.next = node;
    }

    private void removeNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }


    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            //移除node，挪到头上
            removeNode(node);
            addNodeToHead(node);
            node.val = value;
        } else {
            Node node = new Node(key,value);
            if (map.size() >= capacity) {
                //移除tail
                Node removeNode = tail.pre;
                removeNode(removeNode);
                map.remove(removeNode.key);
            }
            //node挪到头上
            addNodeToHead(node);
            map.put(key,node);
        }
    }



    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(2, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        int i = lRUCache.get(2);// return 2
        lRUCache.put(1, 1); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        lRUCache.put(4, 1); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        i = lRUCache.get(2);    // return -1 (not found)
    }
}
