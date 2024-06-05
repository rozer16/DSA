package c_maths;


import java.util.ArrayList;
import java.util.List;
/*
https://leetcode.com/problems/self-dividing-numbers/
*/

public class F_SelfDevidingNumber {

    public static boolean isSelfDevide(int no){
        boolean result = false;
        int tempNo = no;

        while(tempNo > 0){
            int mod = tempNo % 10;
            tempNo = tempNo/10;
            if(mod == 0 || no % mod != 0)
                return false;


        }


        return true;
    }
    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        for(int i = left;i<=right ; i++){
            if(isSelfDevide(i))
                result.add(i);
        }

        return result;
    }


}
