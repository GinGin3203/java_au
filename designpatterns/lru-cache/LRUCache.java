import java.util.HashMap;
import java.util.Map;

class LRUCache <K,V>{

    class Node {
        K key;
        V val;
        Node next;
        Node prev;
        Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    Map<K, Node> map = new HashMap<>();

    Node first = null;
    Node last = null;

    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public V get(K key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            deleteNode(node);
            insertToHead(node);
            return node.val;
        } else {
            return null;
        }
    }

    public void put(K key, V value) {
        if (map.containsKey(key)) {
            deleteNode(map.get(key));
        } else {
            if (map.size() == this.capacity) {
                Node q = last;
                deleteNode(q);
                map.remove(q.key);
            }
        }
        Node newNode = new Node(key, value);
        insertToHead(newNode);
        map.put(key, newNode);
    }

    public void deleteNode(Node node) {
        if (first == node && last == node) {
            first = null;
            last = null;
        } else if (first == node) {
            first = first.next;
            first.prev = null;
        } else if (last == node) {
            last = last.prev;
            last.next = null;
        } else {
            Node prevNode = node.prev;
            Node nextNode = node.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
        }
    }

    public void insertToHead(Node node) {
        if (first == null) {
            first = node;
            last = node;
        } else {
            first.prev = node;
            node.next = first;
            first = node;
        }
    }

}
