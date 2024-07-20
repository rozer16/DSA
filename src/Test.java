import java.io.PrintStream;
import java.util.*;
import java.util.stream.Collectors;



public class Test {
//["LFUCache","put","put","get","put","get","get","put","get","get","get"]
// [[2],[1,1],[2,2],[1],[3,3],[2],[3],[4,4],[1],[3],[4]]

    public static void main(String[] args) throws InterruptedException {

        Deque<Integer> deque = new ArrayDeque<>();
        deque.push(1);
        deque.push(2);
        deque.push(3);
        deque.push(4);
    }

    public long kthElement( int arr1[], int arr2[], int len1, int len2, int k) {

        if(len1 > len2)
                return kthElement(arr2,arr1, len2, len1, k);




        int noOfLeft = k;
        int low = Math.min(0, )


        return -1;
    }

}


class LFUCache {

    Map<Integer,DLLNode> cache;
    Map<Integer,DoublyLL> freqMap;
    int capacity;
    int minFreq;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.freqMap = new HashMap();
    }

    public int get(int key) {
        DLLNode node = cache.get(key);
        if(node == null)
            return -1;


        increaseFreq(node);
        return node.value;
    }

    public void put(int key, int value) {
        if(capacity == 0)
            return;

        if(cache.containsKey(key)){
            DLLNode node = cache.get(key);
            node.value = value;
            increaseFreq(node);
        }else{
            if(cache.size() == capacity){
                DoublyLL list = freqMap.get(minFreq);
                DLLNode  node = list.tail.prev;
                cache.remove(node.key);
                list.removeNode(node);
                //No need to update min freq since we are going to insert new node so it will b always one
            }

            minFreq=1;
            DLLNode node = new DLLNode(key,value) ;
            DoublyLL list = freqMap.getOrDefault(1,new DoublyLL());
            list.addNode(node);
            cache.put(key,node);
            freqMap.put(1,list);

        }
    }

    public void increaseFreq(DLLNode node){
        DoublyLL list = freqMap.get(node.freq);
        list.removeNode(node);

        if(node.freq == minFreq && list.listSize == 0)
            minFreq++;

        node.freq = node.freq+1;
        DoublyLL list1 = freqMap.getOrDefault(node.freq, new DoublyLL());
        list1.addNode(node);
        cache.put(node.key, node);
        freqMap.put(node.freq, list1);
    }
}


class DLLNode{
    int key;
    int value;
    int freq;
    DLLNode next;
    DLLNode prev;


    public DLLNode(int key, int value){
        this.key = key;
        this.value = value;
        this.freq = 1;
    }

    @Override
    public String toString() {
        return "DLLNode{" +
                "key=" + key +
                ", value=" + value +
                ", freq=" + freq +

                '}';
    }
}

class DoublyLL{
    DLLNode head;
    DLLNode tail;
    int listSize;

    public DoublyLL(){
        head = new DLLNode(-1,-1);
        tail = new DLLNode(-1,-1);

        head.next = tail;
        tail.prev = head;

    }

    public void addNode(DLLNode node){
        node.next = head.next;
        node.prev = head;
        head.next=node;
        node.next.prev = node;
        listSize++;
    }

    public void removeNode(DLLNode node){
        node.next.prev = node.prev;
        node.prev.next = node.next;
        listSize--;
    }

    @Override
    public String toString() {
        return "DoublyLL{" +

                ", listSize=" + listSize +
                '}';
    }
}