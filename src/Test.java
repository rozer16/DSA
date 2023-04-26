import java.io.PrintStream;
import java.util.*;
import java.util.stream.Collectors;


interface T{

   public static void hashCode1(){
       System.out.println("Fro T");
   };
}
interface T1 extends  T{


}
public class Test implements  T1{


    public static void main(String[] args) throws InterruptedException {
        Map<String,String> a = new HashMap<>();
        a.put("eee","ff");
        a.put("aaa","bb");
        a.put("fff","gggg");
        a.put("ccc","dd");


        System.out.println(a);
        //a.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));

        System.out.println(a);
    }

    static int countGoodVertices(int N, int M, int[][] edges) {
        int[] inDegree = new int[N];
        int[] outDegree = new int[N];
        for (int[] edge : edges) {
            outDegree[edge[0]]++;
            inDegree[edge[1]]++;
        }
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (inDegree[i] == outDegree[i]) {
                count++;
            }
        }
        return count;
    }


}
