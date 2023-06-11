package h_bitmanipulation;

import java.util.Arrays;
import java.util.List;

public class M_FindTwoIntegerAppearedOnce {
    public static void main(String[] args) {
        M_FindTwoIntegerAppearedOnce test = new M_FindTwoIntegerAppearedOnce();
        List<Integer> nos = Arrays.asList(2, 1, 2, 5, 1, 4, 4, 7, 3, 3,5,7,11,15);
        System.out.println(test.M_FindTwoIntegerAppearedOnce(nos));
    }


    /*
    *
    * Doing XOR of elements will give you XOR of those two integer appeared once
    * but not those two elements
    *
    *Approaches :
    *       BruteForce : Two loops , TC :  O(n^2), SP : O(1)
    *       Optimized 1: Map, TC : O(n), SP : O(1)
    *       Optimized 2: XOR, TC : (n), SP: O(1)
    *                   Steps:
    *                       i) Do XOR of all elements from array and store into XOR var
    *                       ii) Find 1st(or any) set bit from right and store into count.
    *                       iii) Divide nos into two list.
    *                           One list will have all elements whose count bit is set
    *                           Second list will have all elements whose count bit is unset
    *                           Rather than putting them into two list, do XOR directy rather than
    *                           increasing space complexity
    *
    *                           Idea is that after doing XOR of entire list, whatever result we get we get
    *                           no whose bit are set and they would be diff for those two nos
    *
    *
    *
    * */
    public List<Integer> M_FindTwoIntegerAppearedOnce(List<Integer> nos){

        //XOR of all elements O(N)
        int XOR = 0;
        for (int i:nos)
            XOR = XOR ^ i;

        //Logic to find 1st set bit and store into count. O(32)
        int count = 0;
        int temp = XOR;

        while(temp > 0){
            if((temp & 1) == 1 ){
                break;
            }
            count++;
            temp = temp>>1;
        }

        //Logic to separate list elements into two list by set/unset count bit and doing its XOR
        //O(N)
        int no1 = 0;
        int no2 = 0;
        for (int i:nos){
            if((i & (1<<count)) > 0)
                no1 = no1 ^ i;
            else
                no2 = no2 ^ i;
        }


        return Arrays.asList(no2,no1);
    }
}
