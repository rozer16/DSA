package j_stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;


/*
*
*
* https://leetcode.com/problems/online-stock-span/description/
* Problem explanation : https://youtu.be/p9T-fE1g1pU?list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd
*
*
* ["StockSpanner", "next", "next", "next", "next", "next", "next", "next"]
[[], [100], [80], [60], [70], [60], [75], [85]]
Output
[null, 1, 1, 1, 2, 1, 4, 6]

Explanation
StockSpanner stockSpanner = new StockSpanner();
stockSpanner.next(100); // return 1
stockSpanner.next(80);  // return 1
stockSpanner.next(60);  // return 1
stockSpanner.next(70);  // return 2
stockSpanner.next(60);  // return 1
stockSpanner.next(75);  // return 4, because the last 4 prices (including today's price of 75) were less than or equal to today's price.
stockSpanner.next(85);  // return 6
*
Design an algorithm that collects daily price quotes for some stock and returns the span of that stock's price for the current day.

The span of the stock's price in one day is the maximum number of consecutive days (starting from that day and going backward) for which the stock price was less than or equal to the price of that day.

For example, if the prices of the stock in the last four days is [7,2,1,2] and the price of the stock today is 2, then the span of today is 4 because starting from today, the price of the stock was less than or equal 2 for 4 consecutive days.
Also, if the prices of the stock in the last four days is [7,34,1,2] and the price of the stock today is 8, then the span of today is 3 because starting from today, the price of the stock was less than or equal 8 for 3 consecutive days.
Implement the StockSpanner class:

StockSpanner() Initializes the object of the class.
int next(int price) Returns the span of the stock's price given that today's price is price.
*
*
*
* */
public class Z_StockSpanner {

    Deque<Integer> stack;
    List<Integer> list;
    public Z_StockSpanner() {
            this.list=new ArrayList<>();
            stack = new ArrayDeque<>();
    }

    public static void main(String[] args) {
        Z_StockSpanner stockSpanner = new Z_StockSpanner();
       /* System.out.println(stockSpanner.next(100)); // return 1
        System.out.println(stockSpanner.next(80));  // return 1
        System.out.println(stockSpanner.next(60));  // return 1
        System.out.println(stockSpanner.next(70));  // return 2
        System.out.println(stockSpanner.next(60));  // return 1
        System.out.println(stockSpanner.next(75));  // return 4, because the last 4 prices (including today's price of 75) were less than or equal to today's price.
        System.out.println(stockSpanner.next(85));  // return 6*/

        System.out.println(stockSpanner.next(31));  // return 1
        System.out.println(stockSpanner.next(41));  // return 1
        System.out.println(stockSpanner.next(48));  // return 2
        System.out.println(stockSpanner.next(59));  // return 3
        System.out.println(stockSpanner.next(79));  // return 4

    }

    public int next(int price) {
        if(list.isEmpty()){
            list.add(price);
            stack.push(0);
            return 1;
        }
        while(!stack.isEmpty() && list.get(stack.peek()) <= price)
            stack.pop();

        int result = list.size()-(stack.isEmpty()? 0 : stack.peek());
        stack.push(list.size());
        list.add(price);
        return result;

    }

    public int next1(int price) {
        if(list.isEmpty()){
            list.add(price);
            return 1;
        }
        int count = 1;
        int pointer = list.size()-1;
        while(pointer >= 0 && list.get(pointer) <= price) {
            count++;
            pointer--;
        }

        list.add(price);
        return count;

    }
}
