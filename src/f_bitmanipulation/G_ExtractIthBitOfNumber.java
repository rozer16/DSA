package f_bitmanipulation;

public class G_ExtractIthBitOfNumber {

    public static void main(String[] args) {
        int x = 10;
        int i = 1;


        System.out.println(Integer.toBinaryString(x));
        System.out.println(new G_ExtractIthBitOfNumber().extractIthBitOfNumber(x,i));
    }

    /*
    *
    * N = 12     : 1100
    * i = 2
    *
    * x = 0001<<2: 0100
    *
    * (N & X) > 0 ==> 1 else 0
    *
    * */
    public int extractIthBitOfNumber(int no, int i){
        return ((1<<i) & no ) > 0 ? 1 : 0;
    }

}
