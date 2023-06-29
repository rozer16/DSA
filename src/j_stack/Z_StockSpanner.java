package j_stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

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
        System.out.println(stockSpanner.next(48));  // return 1
        System.out.println(stockSpanner.next(59));  // return 1
        System.out.println(stockSpanner.next(79));  // return 1

    }

    public int next(int price) {
        if(list.isEmpty()){
            list.add(price);
            stack.push(0);
            return 1;
        }
        while(!stack.isEmpty() && list.get(stack.peek()) <= price)
            stack.pop();

        int result = list.size()-(stack.isEmpty()? -1 : stack.peek());
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
