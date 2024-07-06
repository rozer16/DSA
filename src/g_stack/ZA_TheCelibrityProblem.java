package g_stack;


import java.sql.SQLOutput;
import java.util.Arrays;

/*
* https://youtu.be/Z5AEc12ieOs?list=PLDdcY4olLQk1bZS0OOFLAysk6keprt00U
* https://www.geeksforgeeks.org/problems/the-celebrity-problem/1
* https://leetcode.com/problems/find-the-celebrity/
*
*
In a party of N people, only one person is known to everyone. Such a person may be present at the party,.
 if yes, (s)he doesn’t know anyone at the party. We can only ask questions like “does A know B? “. Find the stranger (celebrity) in the minimum number of questions.
We can describe the problem input as an array of numbers/characters representing persons in the party. We also have a hypothetical function HaveAcquaintance(A, B) which returns true if A knows B, and false otherwise. How can we solve the problem?

Examples:

Input:
MATRIX = { {0, 0, 1, 0},
           {0, 0, 1, 0},
           {0, 0, 0, 0},
           {0, 0, 1, 0}
         }


Output: id = 2
Explanation: The person with ID 2 does not know anyone but everyone knows him

Input:
MATRIX = {
            {0, 0, 1, 0},
            {0, 0, 1, 0},
            {0, 1, 0, 0},
            {0, 0, 1, 0}
         }

Output: No celebrity
Explanation: There is no celebrity.
*
*
* */
public class ZA_TheCelibrityProblem {

    /*
    * Bruteforce approach
    * TC : O(n^2)
    * SC : O(1)
    * */

    public static void main(String[] args) {
            ZA_TheCelibrityProblem test = new ZA_TheCelibrityProblem();
            int [][] MATRIX = {
                    {0, 0, 1, 0},
                    {0, 0, 1, 0},
                    {0, 0, 0, 0},
                    {0, 0, 1, 0}
            };
            System.out.println(test.getCelebrity(MATRIX)); //2


        int [][] MATRIX1 = {
                {0, 0, 1, 0},
                {0, 0, 1, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0}
        };
        System.out.println(test.getCelebrity(MATRIX1)); //-1


    }



    //TC : O(2n) && SC : O(1)
    public int getCelebrity(int [][] M){
        int n = M.length;
        int celebrity = 0;
        //Start 0-> 1, 1-> 2, 2-> 3 and so on
        //If 0 knows 1 then 1 is celebrity
        //If 1 knows 2 then 2 is celebrity
        //if 2 doesn't know 2 then then still 2 is celebrity
        //if 3 knows 2 then 2 is celebrity
        for (int i = 1; i < n; i++) {
            if(M[celebrity][i] == 1)
                celebrity = i;
        }

        //In order to be celebrity it should follow this rule that celebrity doesn't know anyone but everyone know him
        for (int i = 0; i < n; i++) {
            if(celebrity != i && (M[celebrity][i] == 1 || M[i][celebrity] != 1))
                return -1;
        }


        return celebrity;

    }

    //TC : O(n^2)
    //SC : O(2n)
    public int getCelebrityBF(int [][] matrix){
        int n = matrix.length;
       int in[]  = new int[n];  //ith Person knows how many people
       int out[] = new int[n];  // How many people knows ith person


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i != j && matrix[i][j] == 1){
                    in[i]++;
                    out[j]++;
                }
            }
        }

        //If there is any person who doesn't know anyone but all other person knows him
        for (int i = 0; i < n; i++) {
            if(in[i] == 0 && out[i] == n-1) {
                return i;
            }
        }

        return -1;
    }
}
