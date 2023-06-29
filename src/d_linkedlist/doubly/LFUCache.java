package d_linkedlist.doubly;

import java.util.HashMap;
import java.util.Map;


/*
* https://leetcode.com/problems/lfu-cache/
*
* LFU Explanation : https://youtu.be/0PSB9y8ehbk
* Code Implementation : https://youtu.be/mzqHlAW7jeE
*
**
* */
public class LFUCache {
    //Map to store value and its address
    Map<Integer,DLLNode> cache;

    //Map to store freq and all nodes for that freq
    Map<Integer,DoublyLinkedList> freqMap;

    int capacity;

    int currSize;

    int minFreq;


    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.freqMap = new HashMap<>();
    }


    public static void main(String[] args) {
        LFUCache lfu = new LFUCache(2);
        lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
        lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
        System.out.println(lfu.get(1));      // return 1
        // cache=[1,2], cnt(2)=1, cnt(1)=2
        lfu.put(3, 3);   // 2 is the LFU key because cnt(2)=1 is the smallest, invalidate 2.
        // cache=[3,1], cnt(3)=1, cnt(1)=2
        System.out.println(lfu.get(2));      // return -1 (not found)
        System.out.println(lfu.get(3));      // return 3
        // cache=[3,1], cnt(3)=2, cnt(1)=2
        lfu.put(4, 4);   // Both 1 and 3 have the same cnt, but 1 is LRU, invalidate 1.
        // cache=[4,3], cnt(4)=1, cnt(3)=2
        System.out.println(lfu.get(1));      // return -1 (not found)
        System.out.println(lfu.get(3));      // return 3
        // cache=[3,4], cnt(4)=1, cnt(3)=3
        System.out.println(lfu.get(4));      // return 4
        // cache=[4,3], cnt(4)=2, cnt(3)=3

    }

    //If key exists in cache then get it and update its frequency
    public int get(int key){
        DLLNode currNode = this.cache.get(key);
        if(currNode == null){
            return -1;
        }
        updateNodeFreq(currNode);
        return currNode.getVal();
    }

    /*
    * Add new node into LFU cache as well as doubly linked list
    * Condition 1 : If LFU cache has already Entry with this key
    *       Update value and its frequency
    * Condition 2 : If LFU cache does not have Entry with this key
    *   subCondition
    *       sCondition1 : If LFUCache does not have enough space, then remove the node with minFreq and add
    *       sCondition2 : If LFUCache has enough space, add new node directly
    *
    * */

    public void put(int key,int value){
        if(capacity == 0)
            return;
        if(cache.containsKey(key)){
            DLLNode node = cache.get(key);
            node.setVal(value);
            updateNodeFreq(node);
        }else{
            currSize++;
            //sCondition1 : If LFUCache does not have enough space, then remove the node with minFreq
            if(currSize > capacity){
                //Get min freq list
                DoublyLinkedList minFreqList = freqMap.get(minFreq);

                //Remove last node from cache
                cache.remove(minFreqList.getTail().getPrev().getKey());
                //Remove LRU node from DLL
                minFreqList.removeNodeByItsAddress(minFreqList.getTail().getPrev());
                currSize--;
            }
            // reset min frequency to 1 because of adding new node
            minFreq = 1;
            DLLNode newNode = new DLLNode(key,value);
            // get the list with frequency 1, and then add new node into the list, as well as into LFU cache
            DoublyLinkedList curList = freqMap.getOrDefault(1, new DoublyLinkedList());
            curList.addNodeAfterHead(newNode);
            freqMap.put(1,curList);
            cache.put(key,newNode);

        }
    }
    /*
    Function to update frequency of node,
      Step1 : Remove node from DoublyLinkedList of current frequency

      Step2 : if node's frequency is = minFreq and this was the last node of that list
              i.e. listSize = 0 after deleting then increase minFrequency

      Step3 : Increase the frequency of node

      Step4 :  Add current node to another list has current frequency + 1,
               If we do not have the list with this frequency, initialize it.
               Put it back to freq map

     */
    private void updateNodeFreq(DLLNode currNode) {
        int freq = currNode.getFreq();
        DoublyLinkedList list = freqMap.get(freq);
        list.removeNodeByItsAddress(currNode);

        /*Step2 : if node's frequency is = minFreq and this was the last node of that list
        i.e. listSize = 0 after deleting then increase minFrequency*/

        if(freq == minFreq && list.getListSize() == 0)
            minFreq++;

        //Step3 : Increase the frequency of node
        currNode.setFreq(currNode.getFreq()+1);

        /*Step4 :  Add current node to another list has current frequency + 1,
                If we do not have the list with this frequency, initialize it.
                Put it back to freq map*/

        DoublyLinkedList list1 = freqMap.getOrDefault(currNode.getFreq(),new DoublyLinkedList());
        list1.addNodeAfterHead(currNode);
        freqMap.put(currNode.getFreq(), list1);


    }
}

class DoublyLinkedList{
    private DLLNode head;
    private DLLNode tail;

    private int listSize;



    public DoublyLinkedList() {

        this.head = new DLLNode(0,0);
        this.tail = new DLLNode(0,0);
        head.setNext(tail);
        tail.setPrev(head);
    }

    public void addNodeAfterHead(DLLNode node){
        DLLNode headNext = head.getNext();
        head.setNext(node);
        node.setPrev(head);
        node.setNext(headNext);
        headNext.setPrev(node);
        listSize++;

    }

    public void removeNodeByItsAddress(DLLNode node){
        node.getPrev().setNext(node.getNext());
        node.getNext().setPrev(node.getPrev());
        listSize--;
    }

    public DLLNode getHead() {
        return head;
    }

    public void setHead(DLLNode head) {
        this.head = head;
    }

    public DLLNode getTail() {
        return tail;
    }

    public void setTail(DLLNode tail) {
        this.tail = tail;
    }

    public int getListSize() {
        return listSize;
    }

    public void setListSize(int listSize) {
        this.listSize = listSize;
    }
}
class DLLNode{
    private DLLNode prev;
    private DLLNode next;
    private int freq; //To maintain frequency how many times this node has been accessed
    private int key;
    private int val;

    public DLLNode(int key, int val) {
        this.key = key;
        this.val = val;
        freq = 1;
    }

    public DLLNode getPrev() {
        return prev;
    }

    public void setPrev(DLLNode prev) {
        this.prev = prev;
    }

    public DLLNode getNext() {
        return next;
    }

    public void setNext(DLLNode next) {
        this.next = next;
    }

    public int getFreq() {
        return freq;
    }

    public void setFreq(int freq) {
        this.freq = freq;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
}
