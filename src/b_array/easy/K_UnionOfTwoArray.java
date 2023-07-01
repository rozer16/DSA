package b_array.easy;

import java.util.ArrayList;

/*
* https://practice.geeksforgeeks.org/problems/union-of-two-sorted-arrays-1587115621/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=union-of-two-sorted-arrays
*
* nion of two arrays can be defined as the common and distinct elements in the two arrays.
Given two sorted arrays of size n and m respectively, find their union.


Example 1:

Input:
n = 5, arr1[] = {1, 2, 3, 4, 5}
m = 3, arr2 [] = {1, 2, 3}
Output: 1 2 3 4 5
Explanation: Distinct elements including
both the arrays are: 1 2 3 4 5.


Example 2:

Input:
n = 5, arr1[] = {2, 2, 3, 4, 5}
m = 5, arr2[] = {1, 1, 2, 3, 4}
Output: 1 2 3 4 5
Explanation: Distinct elements including
both the arrays are: 1 2 3 4 5.


Example 3:

Input:
n = 5, arr1[] = {1, 1, 1, 1, 1}
m = 5, arr2[] = {2, 2, 2, 2, 2}
Output: 1 2
Explanation: Distinct elements including
both the arrays are: 1 2.

Your Task:
You do not need to read input or print anything. Complete the function findUnion() that takes two arrays arr1[], arr2[], and their size n and m as input parameters and returns a list containing the union of the two arrays.


Expected Time Complexity: O(n+m).
Expected Auxiliary Space: O(n+m).
*
* */
public class K_UnionOfTwoArray {

    public static void main(String[] args) {
        int [] arr1 = {1,4,18,19,19,28,29,32,35,35,36};
        int [] arr2 = {6,35};
        K_UnionOfTwoArray test = new K_UnionOfTwoArray();
        System.out.println(test.findUnion(arr1,arr2,arr1.length, arr2.length));
    }
    public  ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m)
    {
        int len1 = arr1.length;
        int len2 = arr2.length;
        ArrayList<Integer> result = new ArrayList(len1+len2);
        int i1 =0,i2=0;
        while(i1< len1 && i2 < len2){
            if(i1> 0 && arr1[i1] == arr1[i1-1]){
                i1++;
                continue;
            }
            if(i2> 0 && arr2[i2] == arr2[i2-1]){
                i2++;
                continue;
            }
            if(arr1[i1]==arr2[i2]){
                result.add(arr1[i1]);
                i1++;
                i2++;
            }else if(arr1[i1] < arr2[i2]){
                result.add(arr1[i1]);
                i1++;
            }else{
                result.add(arr2[i2]);
                i2++;
            }
        }
        while(i1< len1){
            if(i1> 0 && arr1[i1] == arr1[i1-1]){
                i1++;
                continue;
            }
            result.add(arr1[i1]);
            i1++;
        }

        while(i2< len2){
            if(i2> 0 && arr2[i2] == arr2[i2-1]){
                i2++;
                continue;
            }
            result.add(arr2[i2]);
            i2++;
        }

        return result;
    }
}
