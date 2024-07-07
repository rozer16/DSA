package f_bitmanipulation;

public class I_UnsetIthBit {
    public int unsetIthBit(int n,int i){
        return (~(1<<i) & n);
    }

    public static void main(String[] args) {
        int x = 5896;
        int i = 3;

        System.out.println(Integer.toBinaryString(x));
        int y = new I_UnsetIthBit().unsetIthBit(x,i);
        System.out.println(Integer.toBinaryString(y));
    }
}

