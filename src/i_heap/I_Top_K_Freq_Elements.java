package i_heap;

import java.util.*;

public class I_Top_K_Freq_Elements {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }

        Comparator<Element> eleComp = Comparator.comparingInt(e -> e.frequency);
        PriorityQueue<Element> pq = new PriorityQueue<>(eleComp);

        for(Integer ele : map.keySet()){
            if(pq.size() < k){
                pq.offer(new Element(ele, map.get(ele)));
            }else{
                if(pq.peek().frequency < map.get(ele)){
                    pq.poll();
                    pq.offer(new Element(ele, map.get(ele)));
                }
            }
        }
        int [] result = new int[pq.size()];
        int index = 0;
        while(!pq.isEmpty())
            result[index++] = pq.poll().ele;
        return result;
    }

    static class Element{
        int ele;
        int frequency;

        public Element(int ele, int freq){
            this.ele = ele;
            this.frequency = freq;
        }
    }

}
