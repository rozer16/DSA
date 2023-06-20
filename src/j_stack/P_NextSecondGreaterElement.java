package j_stack;

import java.util.*;
/*
* https://leetcode.com/problems/next-greater-element-iv/
* */
public class P_NextSecondGreaterElement {


    public static void main(String[] args) {
        int [] arr = {1,17,18,0,18,10,20,0};
        P_NextSecondGreaterElement test = new P_NextSecondGreaterElement();
        System.out.println(Arrays.toString(test.nextSecondGreaterEle(arr)));
    }
    public int[] nextSecondGreaterEle(int[] nums){
        int [] result = new int[nums.length];
        if(nums.length <= 2){
            Arrays.fill(result,-1);
            return result;
        }
        int [] sortedNums =new int[nums.length];

        System.arraycopy(nums,0, sortedNums,0, nums.length);
        int n = nums.length;


        Map<Integer,Integer>  valueIndex = new HashMap<>();
        for (int i = 0; i < n; i++) {
            valueIndex.put(nums[i],i);
        }
        Arrays.sort(sortedNums);

        int [] arr = new int[nums.length];
        Arrays.fill(arr,-1);

        for (int j = n-1; j >=0 ; j--) {
                    int index = valueIndex.get(sortedNums[j]);
                    result[index] = findSecondLargest(nums,arr,index);

        }
        return result;
    }

    public int findSecondLargest(int [] originalNum,int [] sortedNum,int index){
        int result = -1;
        boolean firstFound = false;
        for (int i = index+1; i < sortedNum.length; i++) {

            if(sortedNum[i] == 1){
                if(!firstFound){
                    firstFound = true;
                }else{
                    result = originalNum[i];
                    break;
                }
            }
        }
        sortedNum[index] = 1;
        return result;
    }

    public static int[] count_NGEs(int N, int arr[], int queries, int indices[]) {
        // code here
        int count=0;
        int index=0;
        int ans[]=new int[queries];
        for(int num:indices)
        {
            count=0;
            for(int j=num;j<arr.length;j++)
            {
                if(arr[num]<arr[j])
                {
                    count++;
                }
            }
            ans[index++]=count;
        }
        return ans;

    }
}
