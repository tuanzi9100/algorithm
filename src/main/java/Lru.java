import java.util.HashMap;

/**
 * @author shenWenWen 2022/6/2 下午7:10
 */
public class Lru {
    public static class Node {
        int key;
        int value;
        Node pre;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private final HashMap<Integer, Node> map;
    private Node head;
    private Node end;

    public Lru(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node n = map.get(key);
            remove(n);
            setHead(n);
            return n.value;
        }
        return key;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            setHead(node);
        } else {
            Node created = new Node(key, value);
            if (map.size() >= capacity) {
                map.remove(end.key);
                remove(end);
            } else {
                setHead(created);
            }
            map.put(key, created);
        }
    }

    public void remove(Node node) {
        if (node.pre != null) {
            node.pre.next = node.next;
        } else {
            end = node.pre;
        }
    }

    public void setHead(Node node) {
        node.next = head;
        node.pre = null;
        if (head != null) {
            head = node;
        }
        if (end == null) {
            end = head;
        }
    }

}
