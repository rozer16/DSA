package b_array;


import java.util.HashSet;
import java.util.Set;

/*
* Consequtive no : All elements are distinct and they set range of no
* 3,7,1,4,2,5,3,8,10,9
* 3,7,1 is not correct since 2,4,5,6 is missing
* 1,4,2,5,3 is correct since they have all no from 1-5
* 8,9,10 is another LongestConsequtive nos
*
*
* Answer is 5 since 1,4,2,5,3 is longest no of consequtive no
*
* [Left, Right] --> requirement
*                   1) All no must be distinct
*                   2) Should complete continuous range of nos
*                      Find Max & Min and do Max-Min+1 = Right-Left+1
*
*
* BruteForce Approach
*   Complexity : o(n^3)
*       for(left : 1-> n)
*              for(right=left-> n)
*                  for(k=left-> right)
*                       //1.Check frequency of element
*                       //2.Find min and max and apply below formula
*                               Check Max-Min+1 = Right-Left+1
*
*
*   Complexity : o(n^2)
*       for(left = 1 -> n)
*           int min,max;
*           min=max = a[left]
*           Reset frequency array
*           for(right = left -> n)
*               min = min(a[right],min)
*               max = max(a[right],max)
*               Check frequency and break if repeated
*               if (max-min+1) == right-left+1  set result = max-min+1
*
* */
public class B_LongestConsequtiveNumber {

    public int longestConsequtiveNo(int arr[]){

        Set<Integer> frequency = new HashSet<>();
        int longestRange = 1;
        int range = 0;
        for(int left=0;left< arr.length;left++){
            int min,max;
            min=max=arr[left];
            range = 0;
            resetFrequency(frequency);
            for(int right=left;right<arr.length;right++){
                if(frequency.contains(arr[right]))
                    break;
                frequency.add(arr[right]);
                min =getMin(min,arr[right]);
                max =getMax(max,arr[right]);
                if((max-min+1) == (right-left+1)){
                    range=right-left+1;
                }

            }
            if(longestRange < range)
                longestRange = range;
        }
        return longestRange;
    }

    public static void main(String[] args) {
        int [] arr = {3,7,1,4,2,5,3,8,10,9};
        int [] arr1 = {3,7,1,4,2,5,6,8,10,9};
        int [] arr2 = {5,7,1,4,3,2,9,6};
        B_LongestConsequtiveNumber test= new B_LongestConsequtiveNumber();
        System.out.println(test.longestConsequtiveNo(arr2));
    }

    public void resetFrequency(Set<Integer> set){
        set.clear();
    }

    public int getMin(int no1,int no2){
        if(no1>no2)
            return no2;
        return no1;
    }
    public int getMax(int no1,int no2){
        if(no1>no2)
            return no1;
        return no2;
    }
}
