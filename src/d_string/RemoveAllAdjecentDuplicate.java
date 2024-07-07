package d_string;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveAllAdjecentDuplicate {

    public static void main(String[] args) {
        String str = "pbbcggttciiippooaais";
        RemoveAllAdjecentDuplicate sol = new RemoveAllAdjecentDuplicate();
        System.out.println(sol.removeDuplicates(str,2));
    }
    public String removeDuplicates(String s, int k) {
        Deque<Pair> stack = new ArrayDeque<>();
        for(char c : s.toCharArray()){
            if(!stack.isEmpty() && stack.peek().ch == c){
                if(stack.peek().count == k-1){
                    stack.pop();
                }else{
                    Pair pair = stack.peek();
                    pair.count = pair.count+1;
                }
            }else{
                stack.push(new Pair(c,1));
            }
        }
        StringBuilder s1 = new StringBuilder();
        while(!stack.isEmpty()){
            Pair pair = stack.pop();
            for(int i =0;i<pair.count;i++)
                s1.insert(0,pair.ch);

        }


        return s1.toString();
    }
}

class Pair{
    char ch;
    int count;

    public Pair(char ch_, int count_){
        this.ch = ch_;
        this.count = count_;
    }
}