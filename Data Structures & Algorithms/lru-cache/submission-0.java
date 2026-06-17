class Node {
    int key, val;
    Node prev, next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {

    int cap;
    HashMap<Integer, Node> hs;

    Node left;   // LRU
    Node right;  // MRU

    public LRUCache(int capacity) {

        cap = capacity;
        hs = new HashMap<>();

        left = new Node(0, 0);
        right = new Node(0, 0);

        left.next = right;
        right.prev = left;
    }

    private void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    private void insert(Node node) {
        Node prev = right.prev;

        prev.next = node;
        node.prev = prev;

        node.next = right;
        right.prev = node;
    }

    public int get(int key) {

        if (!hs.containsKey(key)) {
            return -1;
        }

        Node node = hs.get(key);

        remove(node);
        insert(node);

        return node.val;
    }

    public void put(int key, int value) {

        if (hs.containsKey(key)) {
            remove(hs.get(key));
            hs.remove(key);
        }

        Node node = new Node(key, value);

        hs.put(key, node);
        insert(node);

        if (hs.size() > cap) {

            Node lru = left.next;

            remove(lru);
            hs.remove(lru.key);
        }
    }
}