package bitmanipulation;

import java.util.ArrayList;
import java.util.List;

/*
*
* https://codeforces.com/problemset/problem/1097/B
*
*
*
* Petr has just bought a new car. He's just arrived at the most known Petersburg's petrol station to refuel it when he suddenly discovered that the petrol tank is secured with a combination lock! The lock has a scale of 360
 degrees and a pointer which initially points at zero:
 *
 * Petr called his car dealer, who instructed him to rotate the lock's wheel exactly n
 times. The i
-th rotation should be ai
 degrees, either clockwise or counterclockwise, and after all n
 rotations the pointer should again point at zero.

This confused Petr a little bit as he isn't sure which rotations should be done clockwise and which should be done counterclockwise. As there are many possible ways of rotating the lock, help him and find out whether there exists at least one, such that after all n
 rotations the pointer will point at zero again.
 *
 *
 * Exemple:
 * 10 20 30
 * true
 *
 * 10 10 10
 * false
 *
 * 120 120 120
 * true
 *
* */
public class O_PetrAnd_A_Combination_Lock {

    public static void main(String[] args) {
        int [] arr = {120,120,120};
        O_PetrAnd_A_Combination_Lock test = new O_PetrAnd_A_Combination_Lock();
        List<List<Integer>> result = new ArrayList<>();
        //test.findCombinationByRecursion(0,0,new ArrayList<>(),arr, result);
        result = test.findCombinationByBit(arr);
        System.out.println(result);
    }

    public void findCombinationByRecursion(int index, int sum, List<Integer> result, int [] arr, List<List<Integer>> finalResult){
        if(index >= arr.length ){
            if(sum % 360 == 0){
                finalResult.add(new ArrayList<>(result));

            }
            return;
        }

        result.add(arr[index]*(-1));
        findCombinationByRecursion(index+1,sum-arr[index],result,arr,finalResult);
        result.remove(result.size()-1);
        result.add(arr[index]);
        findCombinationByRecursion(index+1,sum+arr[index],result,arr,finalResult);
        result.remove(result.size()-1);
    }
    
    public List<List<Integer>> findCombinationByBit(int [] arr){
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < (1<<arr.length);i++) {
            List<Integer> temp = new ArrayList<>();
            int sum = 0;Er
            for (int j = 0; j < arr.length; j++) {
                if(this.isIthBitSet(i,j)){
                    sum+= arr[j];
                    temp.add(arr[j]);
                }else{
                    sum-= arr[j];
                    temp.add(arr[j]*-1);
                }
            }

            if(sum %360 == 0){
                result.add(new ArrayList<>(temp));
            }

        }
        return result;
    }

    public boolean isIthBitSet(int no, int i){
        return (no & 1<<i) > 0;
    }
}
