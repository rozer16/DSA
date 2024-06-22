package o_heap;

import java.util.*;

/*
https://leetcode.com/problems/hand-of-straights/description/
Alice has some number of cards and she wants to rearrange the cards into groups so that each group is of size groupSize, and consists of groupSize consecutive cards.

Given an integer array hand where hand[i] is the value written on the ith card and an integer groupSize, return true if she can rearrange the cards, or false otherwise.



Example 1:

Input: hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
Output: true
Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8]
Example 2:

Input: hand = [1,2,3,4,5], groupSize = 4
Output: false
Explanation: Alice's hand can not be rearranged into groups of 4.



Constraints:

1 <= hand.length <= 104
0 <= hand[i] <= 109
1 <= groupSize <= hand.length


Note: This question is the same as 1296: https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/




Intuition
When first approaching this problem, the idea is to check if we can rearrange the cards in such a way that we form groups of consecutive cards of a specific size. We need to ensure that every card can be part of a group of the specified size and that no cards are left ungrouped.

Approach
Check for Valid Group Size: The total number of cards must be divisible by the group size to possibly form the required groups. If not, return False.
Count Card Frequencies: Use a dictionary or Counter from the collections module to count how many times each card appears.
Sort the Card Values: Sort the unique card values. This helps in sequentially forming groups starting from the smallest card value.
Form Groups: Iterate through the sorted card values and try to form groups starting from each card:
For each card value, if it has not been fully used in previous groups, attempt to form a group of consecutive cards starting from that value.
For each card in the required group, check if there are enough cards to form the group. If not, return False.
Decrement the count of each card in the group as they are used.
Return Result: If all groups can be successfully formed, return True.


* */
public class R_Hand_Of_Straights {

    public static void main(String[] args) {
        R_Hand_Of_Straights sol = new R_Hand_Of_Straights();
        System.out.println(sol.isNStraightHand(new int[]{1,2,3,6,2,3,4,7,8},3));
    }

    //Complexity
    //Time complexity:O(n)
    //Space complexity:O(k)
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }

        Map<Integer, Integer> cardCount = new TreeMap<>();
        for (int card : hand) {
            cardCount.put(card, cardCount.getOrDefault(card, 0) + 1);
        }

        for (int card : cardCount.keySet()) {
            int count = cardCount.get(card);
            if (count > 0) {
                for (int i = 0; i < groupSize; ++i) {
                    if (cardCount.getOrDefault(card + i, 0) < count) {
                        return false;
                    }
                    cardCount.put(card + i, cardCount.get(card + i) - count);
                }
            }
        }

        return true;
    }

    public boolean isPossibleDivide(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        PriorityQueue<Integer> pq=new PriorityQueue<>();

        for (int val:nums){
            if (map.containsKey(val)){

                map.put(val,map.get(val)+1);
            }
            else{

                map.put(val,1);
                pq.add(val);
            }

        }
        while (!pq.isEmpty()){
            int top=pq.poll();

            map.put(top,map.get(top)-1);
            ArrayList<Integer> temp=new ArrayList<>();
            temp.add(top);
            for (int i=0;i<k-1;i++){
                if (!pq.isEmpty()){
                    int cur=pq.poll();
                    System.out.println(cur);
                    if (cur-temp.get(temp.size()-1)>1) return false;
                    else{
                        if (map.get(cur)>0){
                            if (map.get(cur)>=1) temp.add(cur);
                            map.put(cur,map.get(cur)-1);

                        }
                    }
                }
            }
            System.out.println(temp);
            if (temp.size()!=k) return false;
            for (int val:temp){
                if (map.get(val)>=1) pq.add(val);
            }
            // if (map.get(top)>=1) map.put(top,map.get(top)-1);

            System.out.println(map);

        }
        // for (int v)
        return true;
    }
}
