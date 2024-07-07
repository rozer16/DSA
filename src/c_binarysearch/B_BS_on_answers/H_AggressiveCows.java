package c_binarysearch.B_BS_on_answers;


import java.util.Arrays;

/*

https://takeuforward.org/data-structure/aggressive-cows-detailed-solution/

https://www.youtube.com/watch?v=R_Mfw4ew-Vo


https://www.spoj.com/problems/AGGRCOW/
https://www.naukri.com/code360/problems/aggressive-cows_1082559?leftPanelTabValue=SUBMISSION
https://www.geeksforgeeks.org/problems/aggressive-cows/0

You are given an array 'arr' consisting of 'n' integers which denote the position of a stall.



You are also given an integer 'k' which denotes the number of aggressive cows.



You are given the task of assigning stalls to 'k' cows such that the minimum distance between any two of them is the maximum possible.



Print the maximum possible minimum distance.



Example:
Input: 'n' = 3, 'k' = 2 and 'arr' = {1, 2, 3}

Output: 2

Explanation: The maximum possible minimum distance will be 2 when 2 cows are placed at positions {1, 3}. Here distance between cows is 2.
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1 :
6 4
0 3 4 7 10 9


Sample Output 1 :
3


Explanation to Sample Input 1 :
The maximum possible minimum distance between any two cows will be 3 when 4 cows are placed at positions {0, 3, 7, 10}.
 Here distance between cows are 3, 4 and 3 respectively.


Sample Input 2 :
5 2
4 2 1 3 6


Sample Output 2 :
5



Sample Input 3
0 3 4 7  9 10
cows = 4

Expected time complexity:
Can you solve this in O(n * log(n)) time complexity?




Constraints :
2 <= 'n' <= 10 ^ 5
2 <= 'k' <= n
0 <= 'arr[i]' <= 10 ^ 9
Time Limit: 1 sec.
* */
public class H_AggressiveCows {
    public static void main(String[] args) {
        H_AggressiveCows sol = new H_AggressiveCows();
        System.out.println(sol.aggressiveCows(new int[]{0,3,4,7,10,9}, 4)); //3
        System.out.println(sol.aggressiveCows(new int[]{1,2,3}, 2)); //2

    }

    public  int aggressiveCows(int []stalls, int k) {
        int len = stalls.length;
        Arrays.sort(stalls); //Sorting position of stalls so that we can calculate properly
        int low = 1;
        int high = stalls[len-1]-stalls[0]; //Max distance we can keep is max-min
        while(low <= high){
            int mid = low + (high-low)/2;
            if(canWePlaceNCowsWtihDistanceD(stalls,mid,k)){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return high;
    }
    public  int aggressiveCowsBruteForce(int []stalls, int k) {
        int len = stalls.length;
        Arrays.sort(stalls); //Sorting position of stalls so that we can calculate properly
        int low = 1;
        int high = stalls[len-1]-stalls[0]; //Max distance we can keep is max-min
        int maxDist = 0;
        for(int dist = low; dist<=high; dist++){
            if(!canWePlaceNCowsWtihDistanceD(stalls,dist, k)){
                return dist-1;
            }
        }
        return high;
    }



    public  boolean canWePlaceNCowsWtihDistanceD(int [] stalls, int distance,  int cows){
        int noOfCows = 1;  //no. of cows placed, by default we will place 1 cow at 0
        int last = stalls[0]; //position of last placed cow.
        for (int i = 1; i < stalls.length; i++) {
            if(stalls[i] - last >= distance){
                noOfCows++;
                last = stalls[i];
            }

            if(noOfCows >= cows)
                return true;
        }
        return false;
    }
}
