package LINKED_LIST;
/*
Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:

1. LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
2. int get(int key) Return the value of the key if the key exists, otherwise return -1.
3. void put(int key, int value) Update the value of the key if the key exists.
Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation,
evict the least recently used key.

The functions get and put must each run in O(1) average time complexity.

Concept: Use Circular Doubly Linked List & Hashmap as combined data structure
- Circular Linked List will be served as LRU cache.
- For put()
    * If the key is not present in cache & the size of cache is less than maximum capacity, you can add the element to front of linked list
       & add it to hashmap <Key,Element's address>
    * If the key is not present in cache & the cache is full, remove the least frequently used item which is present at the end of linked list
       & remove it from cache. Add the new element as in step above
    * If the key is already present in cache, update the value in the linked list.
- For get()
    * If the key is not present, return -1.
    * If the key is present, move the element to the head of the linked list & remove from current position.
    * return the value against the key
 */

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

class CircularDoublyLinkedList {
    private Node head;

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node addToFront(Node newNode) {
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

    public int removeLastNode() {
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

    public void moveNodeToHead(Node x) {
        if (x == this.head) {
            return;
        }

        Node tempPrev = x.prev;
        Node tempNext = x.next;
        x.prev.next = tempNext;
        x.next.prev = tempPrev;

        x.prev = x.next = null;
        addToFront(x);
    }
}

class LRUCache {
    private CircularDoublyLinkedList circularDoublyLinkedList;
    private HashMap<Integer, Node> hashMap;
    private int capacity;
    private int currentCapacity;

    public LRUCache(int capacity) {
        this.hashMap = new HashMap<>(capacity);
        this.circularDoublyLinkedList = new CircularDoublyLinkedList();
        this.circularDoublyLinkedList.setHead(null);
        this.capacity = capacity;
        this.currentCapacity = 0;
    }

    public int get(int key) {
        Node x = this.hashMap.get(key);
        //Return -1 if the key is not present in hash table
        if (null == x) {
            return -1;
        }

        this.circularDoublyLinkedList.moveNodeToHead(x);

        hashMap.put(key, this.circularDoublyLinkedList.getHead());
        return x.value;
    }


    public void put(int key, int value) {

        int x = get(key);
        // if the key is already present, update the value against key in circular linked list
        if (x != -1) {
            this.circularDoublyLinkedList.getHead().value = value;
            return;
        }

        //If the key is not present
        Node newNode = new Node(key, value);
        if (this.currentCapacity >= this.capacity) {
            int keyRemoved = this.circularDoublyLinkedList.removeLastNode();
            if (keyRemoved != -1) {
                hashMap.remove(keyRemoved);
                this.capacity--;
            }
        }

        Node node = this.circularDoublyLinkedList.addToFront(newNode);
        this.hashMap.put(key, node);
        this.currentCapacity++;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);


        cache.put(2, 1);
        cache.put(3, 2);

        System.out.println("Fetching key 3, value= " + cache.get(3));
        System.out.println("Fetching key 2, value= " + cache.get(2));

        cache.put(4, 3);


        System.out.println("Fetching key 2, value= " + cache.get(2));
        System.out.println("Fetching key 3, value= " + cache.get(3));
        System.out.println("Fetching key 4, value= " + cache.get(4));
    }
}