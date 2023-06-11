package h_bitmanipulation;

public class J_UnsetLastSetBit {



    /*
    * Intuition :  after deducting  1, Any power of 2 will be set to 0 all bits right to it will be set
    *
    * so last set bit will become to 0 and all right bit of set bit will become 1
    *
    * 16 : 10000
    * 15 : 01111
    *
    * 12 : 1100
    * 11 : 1011
    *
    * */
    public int unsetLastSetBit1(int n){
        return n & n-1;
    }


    public int unsetNthBit(int N,int i){
        return (~(1<<i)&N);
    }

    public int unsetLastSetBit(int N){
        int temp = 1;
        int count = 0;
        while(temp < N){
                if((temp & N) > 0) {
                    break;
                }
                count++;
                temp = temp<<1;
        }

        return unsetNthBit(N,count);
    }

    public static void main(String[] args) {
        int x = 1270;
        System.out.println(Integer.toBinaryString(x));
        int y = new J_UnsetLastSetBit().unsetLastSetBit1(x);
        System.out.println(Integer.toBinaryString(y));
    }
}
