package LINKED_LIST;

import java.util.HashMap;

class Node {
    int key;
    int value;
    Node next;
    Node prev;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.next = this.prev = this;
    }
}

class LRUCache {
    private Node head;
    private HashMap<Integer, Node> hashMap;
    private int capacity;
    private int currentCapacity;

    public LRUCache(int capacity) {
        this.hashMap = new HashMap<>(capacity);
        this.head = null;
        this.capacity = capacity;
        this.currentCapacity = 0;
    }

    public int get(int key) {
        Node x = this.hashMap.get(key);
        //Return -1 if the key is not present in hash table
        if (null == x) {
            return -1;
        }

        //Check if x is present at head of linked list , if it's not present at head, make it to head.
        if (x == head) {
            return x.value;
        }
        Node tempPrev = x.prev;
        Node tempNext = x.next;
        x.prev.next = tempNext;
        x.next.prev = tempPrev;
        hashMap.remove(key);

        addToFront(new Node(x.key, x.value));
        hashMap.put(key, head);
        return x.value;
    }

    private Node addToFront(Node newNode) {
        if (null == this.head) {
            this.head = newNode;
            return head;
        }
        //Save previous of head
        Node temp = head.prev;
        head.prev.next = newNode;
        //Update previous of head
        head.prev = newNode;
        //Update newNode's next
        newNode.next = head;
        //Update newNode's prev
        newNode.prev = temp;
        //Update current head
        head = newNode;
        return head;
    }

    private int removeLastNode() {
        if (null == head) {
            return -1;
        }
        int keyRemoved = head.prev.key;
        //linkedList has only one node
        if (head.prev == head && head.next == head) {
            head = null;
            return keyRemoved;
        }

        Node lastNode = head.prev;
        lastNode.prev.next = head;
        head.prev = lastNode.prev;
        return keyRemoved;
    }

    public void put(int key, int value) {

        int x = get(key);
        if (x != -1) {
            head.value = value;
            hashMap.put(key, head);
            return;
        }

        Node newNode = new Node(key, value);
        if (this.currentCapacity >= this.capacity) {
            int keyRemoved = removeLastNode();
            if (keyRemoved != -1) {
                hashMap.remove(keyRemoved);
                this.capacity--;
            }
        }

        Node node = addToFront(newNode);
        this.hashMap.put(key, node);
        this.currentCapacity++;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);


        cache.put(2, 1);
        cache.printList();

        cache.put(3, 2);
        cache.printList();

        System.out.println("Fetching key 3, value= " + cache.get(3));

        cache.printList();

        System.out.println("Fetching key 2, value= " + cache.get(2));

        cache.printList();

        cache.put(4, 3);
        cache.printList();

        System.out.println("Fetching key 2, value= " + cache.get(2));
        cache.printList();
        System.out.println("Fetching key 3, value= " + cache.get(3));
        cache.printList();
        System.out.println("Fetching key 4, value= " + cache.get(4));
        cache.printList();
    }
}