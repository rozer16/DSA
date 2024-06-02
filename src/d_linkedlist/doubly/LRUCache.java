package d_linkedlist.doubly;


import java.util.HashMap;
import java.util.Map;

/*
*https://www.youtube.com/watch?v=Xc4sICC8m4M&t=15s
*
*
Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:

* LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
* int get(int key) Return the value of the key if the key exists, otherwise return -1.
* void put(int key, int value) Update the value of the key if the key exists. Otherwise,
* add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
* The functions get and put must each run in O(1) average time complexity.
*
*
Input
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
Output
[null, null, null, 1, null, -1, null, -1, 3, 4]

*
*
* Topic explanation : https://youtu.be/xDEuM5qa0zg
* Implementation : https://www.youtube.com/watch?v=Xc4sICC8m4M&t=15s
* */
public class LRUCache {

    int capacity;
    Map<Integer,LRUCacheNode> map = new HashMap<>();
    LRUCacheNode head = new LRUCacheNode(0,0);
    LRUCacheNode tail = new LRUCacheNode(0,0);

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.display(cache.head);
        // {key=0, value=0} -> {key=2, value=2} -> {key=1, value=1} -> {key=0, value=0} ->

        cache.get(1); // 1
        cache.display(cache.head);
        //{key=0, value=0} -> {key=1, value=1} -> {key=2, value=2} -> {key=0, value=0} ->

        cache.put(3,3);
        cache.display(cache.head);
        //{key=0, value=0} -> {key=3, value=3} -> {key=1, value=1} -> {key=0, value=0} ->

        cache.get(2);
        cache.display(cache.head);
        //{key=0, value=0} -> {key=3, value=3} -> {key=1, value=1} -> {key=0, value=0} ->

        cache.put(4,4);
        cache.display(cache.head);
        //{key=0, value=0} -> {key=4, value=4} -> {key=3, value=3} -> {key=0, value=0} ->

        cache.get(1);
        cache.get(3);
        cache.get(4);

    }
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key){
        if(map.containsKey(key)){
            LRUCacheNode node = map.get(key);
            deleteNode(node);
            insertNode(node);
            return node.getValue();
        }else
            return -1;
    }

    public void put(int key,int value){
        if(map.containsKey(key))
            deleteNode(map.get(key));
        if(map.size() == capacity)
            deleteNode(tail.getPrev());
        insertNode(new LRUCacheNode(key,value));
    }

    private void insertNode(LRUCacheNode node) {
        map.put(node.getKey(),node);
        LRUCacheNode headNext = head.next;
        head.next = node;
        node.prev = head;
        node.next = headNext;
        headNext.prev = node;

    }

    private void deleteNode(LRUCacheNode node) {
        map.remove(node.getKey());
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    private void display(LRUCacheNode node){
        while (node != null){
            System.out.print(node+" -> ");
            node = node.next;
        }
        System.out.println();
    }


}

class LRUCacheNode{
    LRUCacheNode prev;
    int key;
    int value;
    LRUCacheNode next;

    @Override
    public String toString() {
        return "{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }

    public LRUCacheNode(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public LRUCacheNode getPrev() {
        return prev;
    }

    public void setPrev(LRUCacheNode prev) {
        this.prev = prev;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public LRUCacheNode getNext() {
        return next;
    }

    public void setNext(LRUCacheNode next) {
        this.next = next;
    }
}