import java.io.PrintStream;
import java.util.*;
import java.util.stream.Collectors;



public class Test{


    public static void main(String[] args) throws InterruptedException {
        int [] nums = {3,30,34,5,9};

        List<Integer> list = Arrays.stream(nums).sorted().boxed().collect(Collectors.toList());

        System.out.println(list);
    }





}
