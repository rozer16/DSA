import java.io.PrintStream;
import java.util.*;
import java.util.stream.Collectors;



public class Test{


    public static void main(String[] args) throws InterruptedException {
        Deque<String> deque = new ArrayDeque<String>();
        deque.add("Ravi");
        deque.add("Vijay");
        deque.add("Ajay");

        Stack<String> stack = new Stack<String>();
        stack.add("Ravi");
        stack.add("Vijay");
        stack.add("Ajay");
        System.out.println(deque);
    }



}
