package hackerrank;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Java8Practice {
    public static void main(String[] args) {
        List<Pair> pairs = new ArrayList<>();
        pairs.add(new Pair("Ravi",5));
        pairs.add(new Pair("Ravi1",5));
        pairs.add(new Pair("Ravi2",5));
        pairs.add(new Pair("Ravi",5));
        pairs.add(new Pair("Ravi1",5));
        pairs.add(new Pair("Ravi3",5));
        pairs.add(new Pair("Ravi5",5));
        List<Pair> pairList1 = new ArrayList<>();
        for(Pair p:pairs){
        pairs.stream().distinct().collect(Collectors.toSet());
       pairList1.stream().forEach(System.out::println);

    }
}



}
class Pair{
    private String key;
    private int value;

    public Pair(String key, int value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "key='" + key + '\'' +
                ", value=" + value +
                '}';
    }
}
