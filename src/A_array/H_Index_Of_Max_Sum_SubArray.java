package A_array;


import java.util.Arrays;

public class H_Index_Of_Max_Sum_SubArray {


    //This approach works for negative numbers also
    //Time Complexity : O(n^2)
    //Space Complexity: O(1)
    public int[] get_Index_Of_Max_Sum_SubArray_BruteForce(int[] arr, int maxSum)
    {
        int maxlength = 0;
        int n=arr.length;
        int ansLeft = -1;
        int ansRight = -1;
        int [] result = new int[2];
        for (int i = 0; i < n; i++) {

            // Variable to store sum of subarrays
            int Sum = 0;

            for (int j = i; j < n; j++) {

                // Storing sum of subarrays
                Sum += arr[j];

                // if Sum equals K
                if (Sum == maxSum) {

                    // Update maxLength
                    maxlength = Math.max(maxlength, j - i + 1);
                    ansLeft = i;
                    ansRight = j;
                }
            }
        }

        // Return the maximum length
        result[0] = ansLeft;
        result[1] = ansRight;
        return result;
    }



    //This approach won’t work for negative numbers
    //Time Complexity : O(n)
    //Space Complexity: O(1)


    /*
     *
     * Two pointers Techniques
     *
     * Start j = -1 so that if first element of current is maximum of maxSum
     *
     * j = -1
     * sum = 0
     * leftAns = rightAns = -1
     * i = 0..n
     *   if i <= j
     *       sum = sum - arr[j];
     *   else
     *       j = i-1;
     *       sum = 0;
     *       while(j < n && sum+arr[j+1]<=maxSum)
     *           sum += arr[j++]
     *
     *       if(leftAns == -1 or leftAns-rightAns < j-i)
     *           leftAns = j
     *           rightAns = i
     *
     *
     *   return [rightAns,leftAns];
     *
     *
     * */
    public int[] get_Index_Of_Max_Sum_SubArray(int [] arr,int maxSum){
        int [] result = new int[2];
        int ansLeft, ansRight;
        ansLeft = ansRight = -1;
        int j = -1;
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            if(i<=j){
                sum= sum - arr[i-1];
            }else {
                j = i - 1;
                sum = 0;
            }
            while(j< arr.length-1 && (sum+arr[j+1]) <= maxSum) {
                j++;
                sum += arr[j];

            }

            if(ansLeft == -1 || ansRight - ansLeft < j-i){
                ansLeft = i;
                ansRight = j;
            }

        }
        result[0] = ansLeft;
        result[1] = ansRight;
        return result;
    }




    public static void main(String[] args) {
        int [] arr= {3,2,5,2,2,1,1,3,1,2};
        int [] arr1=  { 10, 5, 2, 7, 1, 9 };
        int arr2 [] = {-5, 8, -14, 2, 4, 12};
        H_Index_Of_Max_Sum_SubArray test = new H_Index_Of_Max_Sum_SubArray();
        System.out.println(Arrays.toString(test.get_Index_Of_Max_Sum_SubArray(arr,11)));
        System.out.println(Arrays.toString(test.get_Index_Of_Max_Sum_SubArray(arr1,15)));
        System.out.println(Arrays.toString(test.get_Index_Of_Max_Sum_SubArray_BruteForce(arr2,-5)));
    }
}
