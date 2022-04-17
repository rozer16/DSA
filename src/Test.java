import java.util.*;

public class Test {
    public static void main(String[] args) throws InterruptedException {

            Set<String> hashSet = new HashSet<String>();

            hashSet.add("ankit4");
            hashSet.add("javaMadeSoEasy");

            System.out.println("-------use iterator-------");
            // fail-fast
            Iterator<String> iterator = hashSet.iterator();
            while (iterator.hasNext()) {
                //hashSet.add("newElement1");//unComment to avoid ConcurrentModificationException
                System.out.println(iterator.next());
            }

            System.out.println("-------use Enumeration-------");
            // fail-fast
            Enumeration<String> listEnum = Collections.enumeration(hashSet);
            while (listEnum.hasMoreElements()) {
                //hashSet.add("newElement2");//unComment to avoid ConcurrentModificationException
                System.out.println(listEnum.nextElement());
            }

            System.out.println("-------use enhanced for loop-------");

            // enhanced for loop is fail-fast
            for (String string : hashSet) {
                hashSet.add("newElement3");//unComment to avoid ConcurrentModificationException
                System.out.println(string);
            }


    }
}
