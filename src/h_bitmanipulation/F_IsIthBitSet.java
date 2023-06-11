package h_bitmanipulation;


/*
*
* i starts from 0 bit of left bit
* N = 13 ==> (1101) ==>
* 0 bit : 1,
* 1st bit : 0,
* 2nd bit :1,
* 3rd bit: 1
*
* if bit value 0 then unset otherwise set.
*
* */
public class F_IsIthBitSet {

    /*
    * Not right approch since we are changing original value so always to with mask approach
    * */
    public boolean isIthBitSet(int n,int i){
         return ((n>>i) & 1) == 1? true : false;
    }



    /*
    *
    * No 1 0 0 0 1
    *
    * To get 3rd bit create mask 1<<3
    *
    * mask = 1<<3 ==> 1000
    *
    * no & mask > 0 then ith bit is set otherwise unset
    * */
    public boolean isIthBitSet1(int n,int i){
        int mask =(1<<i);
        return ( mask & n) >0? true : false;
    }

    public static void main(String[] args) {
        int x = 13;
        int i =2;

        System.out.println(Integer.toBinaryString(x));
        System.out.println(new F_IsIthBitSet().isIthBitSet1(x,i));
    }
}
