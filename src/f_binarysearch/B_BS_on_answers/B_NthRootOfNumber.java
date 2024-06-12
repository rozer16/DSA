package f_binarysearch.B_BS_on_answers;


/*
https://takeuforward.org/data-structure/nth-root-of-a-number-using-binary-search/
https://www.youtube.com/watch?v=rjEJeYCasHs
https://www.geeksforgeeks.org/problems/find-nth-root-of-m5843/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=find-nth-root-of-m


You are given 2 numbers (n , m); the task is to find n√m (nth root of m).


Example 1:

Input: n = 2, m = 9
Output: 3
Explanation: 3^2 = 9


Example 2:

Input: n = 3, m = 9
Output: -1
Explanation: 3rd root of 9 is not
integer.


Your Task:
You don't need to read or print anyhting.
 Your task is to complete the function NthRoot()
 which takes n and m as input parameter and returns the nth root of m.
 If the root is not integer then returns -1.


Expected Time Complexity: O(n* log(m))
Expected Space Complexity: O(1)


Constraints:
1 <= n <= 30
1 <= m <= 109


* */
public class B_NthRootOfNumber {
    public static void main(String[] args) {

    }

    public int NthRoot(int n, int m){
      int low = 1;  //1^n = 1 so min can be one
      int high = m;

      while(low < high){
          int mid = low + (high-low)/2;

          int temp = getPower1(mid, n,m);
          if(temp == 1)
              return  mid;
          else if (temp > m) {
              high = mid-1;
          }else{
              low = mid+1;
          }

      }

      return -1;
    }



    public int getPower1(int mid, int n, int m){
        long ans = 1;
        long power = n;


        for (int i = 0; i < n; i++) {
            ans = ans*mid;
            if (ans > m) return 2;
        }

        if(ans == m) return 1;
        else return  -1;
    }

    public int getPower(int mid, int n, int m){
        if(n==1)
            return mid;

        if(n%2 == 0){
            return  getPower(mid*mid,n/2,m);
        }else{
            return  mid * getPower(mid,n-1,m);
        }
    }
}
